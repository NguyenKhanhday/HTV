package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Contract;
import vn.htv.ams_backend.repository.ContractRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin("*")
public class ContractController {

    @Autowired
    private ContractRepository repository;

    @GetMapping
    public List<Contract> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public Contract save(@RequestBody Contract payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);

        // Nếu là Thêm mới (ID null)
        if (payload.getContractId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1);
            payload.setObjId(UUID.randomUUID().toString()); // Tự sinh mã để tránh lỗi NULL ObjID
        }

        // Cập nhật thời gian chỉnh sửa
        payload.setModifiedTime(now);

        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}