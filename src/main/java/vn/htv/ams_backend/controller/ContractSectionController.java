package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.ContractSection;
import vn.htv.ams_backend.repository.ContractSectionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contract-sections")
@CrossOrigin("*")
public class ContractSectionController {

    @Autowired
    private ContractSectionRepository repository;

    @GetMapping
    public List<ContractSection> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public ContractSection save(@RequestBody ContractSection payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);

        // Nếu tạo mới
        if (payload.getSectionId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1);
            payload.setObjId(UUID.randomUUID().toString()); // Đóng gói ObjID chống lỗi
        }

        // Cập nhật ngày sửa đổi
        payload.setModifiedTime(now);

        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}