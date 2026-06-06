package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Tape;
import vn.htv.ams_backend.repository.TapeRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tapes")
public class TapeController {

    @Autowired
    private TapeRepository tapeRepository;

    @GetMapping
    public List<Tape> getAll() {
        return tapeRepository.findAll();
    }

    @PostMapping("/save")
    public Tape save(@RequestBody Tape payload) {
        if (payload.getDescription() == null) payload.setDescription("");
        if (payload.getStatus() == null) payload.setStatus(1);

        // BẢO VỆ 1: Cắt bỏ phần tỷ giây (nanoseconds) để tương thích 100% với SQL Server DATETIME
        LocalDateTime now = LocalDateTime.now().withNano(0);

        // BẢO VỆ 2: Lọc ngày hết hạn nếu lỡ nhập sai năm (năm < 1753)
        if (payload.getExpiredDate() != null && payload.getExpiredDate().getYear() < 1753) {
            payload.setExpiredDate(null); // Trả về null nếu ngày không hợp lệ
        }

        if (payload.getTapeId() == null) {
            // THÊM MỚI
            payload.setCreatedTime(now);
            payload.setModifiedTime(now);

            // BẢO VỆ 3: Cấp luôn ngày LastUsedDate đề phòng Database bắt buộc (NOT NULL)
            payload.setLastUsedDate(now);

            payload.setCreatorId(1);
            return tapeRepository.save(payload);
        } else {
            // CẬP NHẬT
            Tape existing = tapeRepository.findById(payload.getTapeId()).orElse(null);
            if (existing != null) {
                existing.setProductId(payload.getProductId());
                existing.setCustomerId(payload.getCustomerId());
                existing.setAdTypeId(payload.getAdTypeId());
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setDuration(payload.getDuration());
                existing.setStatus(payload.getStatus());

                existing.setExpiredDate(payload.getExpiredDate());
                existing.setDescription(payload.getDescription());

                existing.setLastUsedDate(now);
                existing.setModifiedTime(now);

                return tapeRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tapeRepository.deleteById(id);
    }
}