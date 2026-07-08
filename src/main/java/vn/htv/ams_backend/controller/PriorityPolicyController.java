package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.PriorityPolicy;
import vn.htv.ams_backend.repository.PriorityPolicyRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/priority-policies")
@CrossOrigin("*")
public class PriorityPolicyController {

    @Autowired
    private PriorityPolicyRepository repository;

    @GetMapping
    public List<PriorityPolicy> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public PriorityPolicy save(@RequestBody PriorityPolicy payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getPriorityId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1);
            // Tự động sinh ObjID để SQL không báo lỗi NULL
            payload.setObjId(UUID.randomUUID().toString());
        }
        payload.setModifiedTime(now);
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}