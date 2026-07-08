package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.PriorityPolicyDetail;
import vn.htv.ams_backend.repository.PriorityPolicyDetailRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/priority-policy-details")
@CrossOrigin("*")
public class PriorityPolicyDetailController {

    @Autowired
    private PriorityPolicyDetailRepository repository;

    @GetMapping
    public List<PriorityPolicyDetail> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public PriorityPolicyDetail save(@RequestBody PriorityPolicyDetail payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getPriorityDetailId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1);
            payload.setObjId(UUID.randomUUID().toString()); // Tự sinh mã UUID để khỏi dính lỗi SQL
        }
        payload.setModifiedTime(now);
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}