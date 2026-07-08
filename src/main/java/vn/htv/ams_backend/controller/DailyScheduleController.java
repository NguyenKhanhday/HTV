package vn.htv.ams_backend.controller; // Nhớ đổi tên package cho đúng với project của em

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.repository.SpotRepository; // Đổi lại import theo Repo của em
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // Cho phép React gọi API không bị lỗi CORS
public class DailyScheduleController {

    @Autowired
    private SpotRepository spotRepository;

    // TIÊM JDBCTEMPLATE VÀO ĐÂY ĐỂ DÙNG
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ==============================================================
    // API 1: LẤY DANH SÁCH LỊCH TỔNG (BẰNG JDBCTEMPLATE)
    // ==============================================================
    @GetMapping("/daily-schedules")
    public ResponseEntity<?> getSchedules(@RequestParam("fromDate") String fromDate,
                                          @RequestParam("toDate") String toDate) {
        try {
            // SỬ DỤNG JDBCTEMPLATE ĐỂ BỎ QUA HIBERNATE
            String sql = "EXEC TVAMSMTV_DailySchedule_Select ?, ?";

            // Hàm này tự động trả về List<Map> cực kỳ mượt mà, không bị lỗi ép kiểu
            List<Map<String, Object>> rawData = jdbcTemplate.queryForList(sql, fromDate, toDate);

            List<Map<String, Object>> formattedData = new ArrayList<>();
            for (Map<String, Object> row : rawData) {
                Map<String, Object> map = new HashMap<>();
                map.put("date", row.get("Date") != null ? row.get("Date").toString() : "");
                map.put("code", row.get("Code"));
                map.put("channelId", row.get("ChannelID"));
                map.put("isClock", row.get("IsClock"));
                map.put("tl", row.get("TL"));
                // TLDay là chuỗi rỗng, ta có thể bỏ qua không cần lấy
                map.put("stastus", row.get("Stastus"));

                formattedData.add(map);
            }

            return ResponseEntity.ok(formattedData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi khi tải lịch phát sóng: " + e.getMessage());
        }
    }

    // ==============================================================
    // API 2: LẤY BẢNG CHI TIẾT (MOCK DATA TẠM TRONG LÚC ĐỢI SẾP VIẾT SP)
    // ==============================================================
    // ==============================================================
    // API 2: LẤY BẢNG CHI TIẾT (ĐÃ DÙNG JDBCTEMPLATE + SP CỦA SẾP)
    // ==============================================================
    @GetMapping("/daily-schedule-details")
    public ResponseEntity<?> getScheduleDetails(@RequestParam("channelId") Integer channelId,
                                                @RequestParam("date") String date) {
        try {
            // GỌI THẲNG STORED PROCEDURE CỦA SẾP BẰNG JDBCTEMPLATE
            String sql = "EXEC TVAMSMTV_PrintableDailySchedule_ByDate ?, ?";

            // Chú ý: SP của sếp truyền @Day trước, @ChannelID sau
            List<Map<String, Object>> rawData = jdbcTemplate.queryForList(sql, date, channelId);

            List<Map<String, Object>> formattedDetails = new ArrayList<>();
            int idCounter = 1; // Tạo ID ảo cho Frontend dễ render

            for (Map<String, Object> row : rawData) {
                Map<String, Object> map = new HashMap<>();

                map.put("id", idCounter++);

                // Móc đúng tên cột (chuỗi trong dấu ngoặc kép hoặc ngoặc vuông) mà sếp viết sau chữ "AS"
                map.put("period", row.get("DayPeriodName")); // Buổi
                map.put("timeRange", row.get("Time")); // Thời gian PS
                map.put("symbol", row.get("Symbol")); // Ký hiệu A, B, C...
                map.put("tapeName", row.get("TapeName")); // Băng hình

                // --- CHÚ Ý: SP của sếp JOIN 2 bảng này nhưng quên SELECT ra nên tạm thời để rỗng ---
                map.put("contract", ""); // Hợp đồng
                map.put("section", ""); // Điều khoản

                map.put("subBlock", row.get("BlockCode")); // Block con
                map.put("bookCode", row.get("BookCode")); // Mã Book
                map.put("tapeCode", row.get("TapeCode")); // Mã băng
                map.put("tl", row.get("TL")); // Thời lượng
                map.put("position", row.get("Position")); // Vị trí
                map.put("description", row.get("ProductName")); // Mô tả (SP map ProductName vào)

                // --- CHÚ Ý: SP của sếp cũng không SELECT 2 cột này ---
                map.put("status", "Sử dụng"); // Cứ mặc định hiện chữ "Sử dụng" cho đẹp giao diện
                map.put("isCPP", 0);

                formattedDetails.add(map);
            }

            return ResponseEntity.ok(formattedDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi khi tải chi tiết lịch phát sóng: " + e.getMessage());
        }
    }
}