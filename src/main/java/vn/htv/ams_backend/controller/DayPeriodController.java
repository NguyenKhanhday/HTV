package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.DayPeriod;
import vn.htv.ams_backend.repository.DayPeriodRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/day-periods")
public class DayPeriodController {

    @Autowired
    private DayPeriodRepository dayPeriodRepository;

    // 1. LẤY DANH SÁCH
    @GetMapping
    public List<DayPeriod> getAll() {
        return dayPeriodRepository.findAll();
    }

    // --- HÀM HỖ TRỢ: Tự động ghép ngày giả vào giờ để SQL Server không báo lỗi ---
    private String formatTimeToDateTime(String timeStr) {
        if (timeStr == null || timeStr.trim().isEmpty()) {
            return "2007-01-01 00:00:00.000";
        }
        // Nếu user chỉ nhập "05:00" thì tự động bù thêm "2007-01-01" và ":00" giây
        if (!timeStr.contains("-")) {
            if (timeStr.length() <= 5) {
                timeStr += ":00";
            }
            return "2007-01-01 " + timeStr + ".000";
        }
        return timeStr; // Nếu đã chuẩn rồi thì giữ nguyên
    }

    // 2. THÊM MỚI VÀ CẬP NHẬT (Đã chống mọi loại lỗi SQL)
    @PostMapping("/save")
    public DayPeriod save(@RequestBody DayPeriod payload) {

        // A. Xử lý dữ liệu đầu vào trước khi lưu
        if (payload.getDescription() == null) {
            payload.setDescription(""); // Chống lỗi NULL cột Description
        }

        // Ép kiểu giờ cho khớp chuẩn DATETIME của SQL Server
        payload.setStartTime(formatTimeToDateTime(payload.getStartTime()));
        payload.setEndTime(formatTimeToDateTime(payload.getEndTime()));

        // B. Phân luồng: Thêm mới hay Sửa
        if (payload.getPeriodId() == null) {
            // ============ TRƯỜNG HỢP: THÊM MỚI ============
            payload.setCreatedTime(LocalDateTime.now());
            payload.setModifiedTime(LocalDateTime.now()); // Chống lỗi NULL cột ModifiedTime
            payload.setStatus(1); // 1 = Đang dùng
            payload.setCreatorId(1); // Mặc định ID người tạo
            payload.setObjId(UUID.randomUUID().toString()); // Tự sinh chuỗi định danh chống lỗi ObjID

            return dayPeriodRepository.save(payload);

        } else {
            // ============ TRƯỜNG HỢP: CẬP NHẬT (SỬA) ============
            // Moi dữ liệu cũ từ Database lên để không bị mất các cột hệ thống
            DayPeriod existing = dayPeriodRepository.findById(payload.getPeriodId()).orElse(null);

            if (existing != null) {
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setStartTime(payload.getStartTime()); // Đã được format ở trên
                existing.setEndTime(payload.getEndTime());     // Đã được format ở trên
                existing.setIsPrintFilter(payload.getIsPrintFilter());
                existing.setDescription(payload.getDescription());
                existing.setStatus(payload.getStatus());

                existing.setModifiedTime(LocalDateTime.now()); // Cập nhật lại ngày sửa

                return dayPeriodRepository.save(existing);
            }
            return null;
        }
    }

    // 3. XÓA BUỔI PHÁT SÓNG
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dayPeriodRepository.deleteById(id);
    }
}