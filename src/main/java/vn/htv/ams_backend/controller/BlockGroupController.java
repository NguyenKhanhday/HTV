package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.BlockGroup;
import vn.htv.ams_backend.repository.BlockGroupRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/block-groups")
public class BlockGroupController {

    @Autowired
    private BlockGroupRepository blockGroupRepository;

    @GetMapping
    public List<BlockGroup> getAll() {
        return blockGroupRepository.findAll();
    }

    @PostMapping("/save")
    public BlockGroup save(@RequestBody BlockGroup payload) {

        // Chống lỗi NULL cho các chuỗi
        if (payload.getDescription() == null) payload.setDescription("");
        if (payload.getReportName() == null) payload.setReportName("");

        if (payload.getBlockGroupId() == null) {
            // === THÊM MỚI ===
            payload.setCreatedTime(LocalDateTime.now());
            payload.setModifiedTime(LocalDateTime.now());
            if (payload.getStatus() == null) payload.setStatus(1); // 1 = Đang sử dụng
            payload.setCreatorId(1); // ID người tạo (tạm fix cứng)
            payload.setObjId(UUID.randomUUID().toString()); // Tạo chuỗi ngẫu nhiên cho ObjID

            return blockGroupRepository.save(payload);
        } else {
            // === CẬP NHẬT ===
            BlockGroup existing = blockGroupRepository.findById(payload.getBlockGroupId()).orElse(null);
            if (existing != null) {
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setReportName(payload.getReportName());
                existing.setDescription(payload.getDescription());
                existing.setStatus(payload.getStatus());

                existing.setModifiedTime(LocalDateTime.now()); // Cập nhật lại ngày sửa

                return blockGroupRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        blockGroupRepository.deleteById(id);
    }
}