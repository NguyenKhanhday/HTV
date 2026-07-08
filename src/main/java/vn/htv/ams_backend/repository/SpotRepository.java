package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.htv.ams_backend.entity.Spot;
import java.util.List;
import java.util.Map;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer> {

    // Lấy danh sách Spot để hiển thị lên Ma trận
    List<Spot> findByBookId(Integer bookId);

    // Dùng để reset Ma trận trước khi lưu mới
    void deleteByBookId(Integer bookId);

    // 1. Hàm phụ: Lấy thời lượng (Duration) của Băng hình đang gắn với Book này
    @Query(value = "SELECT TOP 1 t.Duration FROM Tape t INNER JOIN Book b ON t.TapeID = b.TapeID WHERE b.BookID = :bookId", nativeQuery = true)
    Integer getTapeDurationByBookId(@Param("bookId") Integer bookId);

    // 2. Gọi SP check thời lượng còn lại
    @Query(value = "EXEC Book_CheckSubBlockMax :subBlockId, :dateSpot, :duration", nativeQuery = true)
    Integer checkSubBlockMax(@Param("subBlockId") Integer subBlockId, @Param("dateSpot") String dateSpot, @Param("duration") Integer duration);

    // 3. Gọi SP tính giá tiền (Spot thường)
    @Query(value = "EXEC GetPriceOfSpot :subBlockId, :duration", nativeQuery = true)
    Double getPriceOfSpot(@Param("subBlockId") Integer subBlockId, @Param("duration") Integer duration);

    // 4. Gọi SP tính số thứ tự (Ord)
    @Query(value = "EXEC GetOrdSpotOfBook :slotId, :dateSpot", nativeQuery = true)
    Integer getOrdSpotOfBook(@Param("slotId") Integer slotId, @Param("dateSpot") String dateSpot);

    // Sửa kiểu trả về thành List<Object[]> để tránh lỗi CoercionException của Hibernate
    @Query(value = "EXEC TVAMSMTV_DailySchedule_Select :fromDate, :toDate", nativeQuery = true)
    List<Object[]> getDailySchedules(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}