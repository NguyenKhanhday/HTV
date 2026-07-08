package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.dto.SubBlockMatrixDTO;
import vn.htv.ams_backend.entity.SubBlock;
import vn.htv.ams_backend.repository.SubBlockRepository;
import vn.htv.ams_backend.service.SubBlockService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sub-blocks")
@CrossOrigin("*")
public class SubBlockController {
    @Autowired
    private SubBlockService subBlockService;
    @Autowired
    private SubBlockRepository repository;

    @GetMapping("/block/{blockId}")
    public List<SubBlock> getByBlockId(@PathVariable Integer blockId) {
        return repository.findByBlockId(blockId);
    }

    @PostMapping("/save")
    public SubBlock save(@RequestBody SubBlock payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getSubBlockId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1);
            payload.setObjId(UUID.randomUUID().toString()); // Tự sinh ObjID tránh lỗi SQL
        }
        payload.setModifiedTime(now);
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
    // API trả về toàn bộ danh sách Khung QC cho Ma trận
    @GetMapping
    public ResponseEntity<List<SubBlock>> getAllSubBlocks() {
        // Thay subBlockService.getAllSubBlocks() thành repository.findAll()
        return ResponseEntity.ok(repository.findAll());
    }
    // Thêm API mới này vào Controller
    @GetMapping("/matrix-load")
    public ResponseEntity<List<SubBlockMatrixDTO>> getSubblocksForMatrix(
            @RequestParam Integer channelId,
            @RequestParam String toDate) {
        return ResponseEntity.ok(subBlockService.getSubblocksForMatrix(channelId, toDate));
    }
}