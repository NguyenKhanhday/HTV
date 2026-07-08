package vn.htv.ams_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.htv.ams_backend.entity.Book;
import vn.htv.ams_backend.entity.Spot;
import vn.htv.ams_backend.repository.BookRepository;
import vn.htv.ams_backend.repository.SpotRepository;
import java.time.LocalDate;
import java.util.List;

@Service
public class SpotService {

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private BookRepository bookRepository; // THÊM REPOSITORY CỦA BẢNG BOOK VÀO ĐÂY

    public List<Spot> getSpotsByBookId(Integer bookId) {
        return spotRepository.findByBookId(bookId);
    }

    // Hàm lưu toàn bộ Ma trận
    // Hàm lưu toàn bộ Ma trận
    @Transactional
    public List<Spot> saveMatrix(Integer bookId, List<Spot> spots) {

        // BƯỚC CHUẨN BỊ: Lấy thời lượng (Duration) của cuốn Băng hình
        Integer tapeDuration = spotRepository.getTapeDurationByBookId(bookId);
        if (tapeDuration == null) tapeDuration = 0; // Đề phòng lỗi thiếu băng hình

        LocalDate today = LocalDate.now();

        // XÓA DỮ LIỆU CŨ TRƯỚC KHI LƯU MỚI VÀ TÍNH TOÁN
        spotRepository.deleteByBookId(bookId);

        // QUÉT TỪNG Ô SPOT ĐỂ KIỂM TRA 4 YÊU CẦU CỦA SẾP
        if (spots != null && !spots.isEmpty()) {
            for (Spot spot : spots) {

                Integer subBlockId = spot.getSlotId();

                // === ĐÃ FIX LỖI DATE Ở ĐÂY ===
                // Chuyển kiểu Date/LocalDateTime thành String một cách an toàn rồi mới cắt chuỗi YYYY-MM-DD
                String dateSpotStr = String.valueOf(spot.getDate()).split("T")[0].split(" ")[0];
                LocalDate dateSpot = LocalDate.parse(dateSpotStr);

                // ==========================================
                // YÊU CẦU 1: KHÔNG CHO BOOK NGÀY QUÁ KHỨ
                // ==========================================
                if (dateSpot.isBefore(today)) {
                    throw new RuntimeException("Lỗi: Không được book Spot vào ngày quá khứ (" + dateSpotStr + ")!");
                }

                // ==========================================
                // YÊU CẦU 2: KIỂM TRA THỜI LƯỢNG SUB-BLOCK
                // ==========================================
                Integer durationRemain = spotRepository.checkSubBlockMax(subBlockId, dateSpotStr, tapeDuration);
                if (durationRemain != null && durationRemain <= 0) {
                    throw new RuntimeException("Lỗi: Khung QC " + subBlockId + " vào ngày " + dateSpotStr + " đã hết thời lượng trống!");
                }

                // ==========================================
                // YÊU CẦU 3 & 4: TÍNH GIÁ TIỀN VÀ PHÂN LOẠI SPOT
                // ==========================================
                Double basePrice = spotRepository.getPriceOfSpot(subBlockId, tapeDuration);
                if (basePrice == null) basePrice = 0.0;

                String position = spot.getPosition().toUpperCase();
                if (position.equals("A")) {
                    // Spot thường: Giữ nguyên giá
                    spot.setAmount(basePrice);
                } else {
                    // Spot đặc biệt (Ưu tiên): Cộng thêm 10% (Tức là nhân 1.1)
                    spot.setAmount(basePrice + (basePrice * 0.10));
                }

                // ==========================================
                // YÊU CẦU Cuối: TÍNH SỐ THỨ TỰ (ORD)
                // ==========================================
                Integer ord = spotRepository.getOrdSpotOfBook(spot.getSlotId(), dateSpotStr);
                spot.setOrd(ord != null ? ord : 1);

                // Gắn mã BookID
                spot.setBookId(bookId);
            }

            // NẾU QUA ĐƯỢC HẾT CÁC CỬA KIỂM DUYỆT TRÊN -> LƯU VÀO DATABASE
            spotRepository.saveAll(spots);
        }

        // Cập nhật lại cột Tổng Spot sang bảng Book
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            book.setSpotCount(spots != null ? spots.size() : 0);
            bookRepository.save(book);
        }

        return spots;
    }
}