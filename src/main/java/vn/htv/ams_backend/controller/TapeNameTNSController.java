package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.TapeNameTNS;
import vn.htv.ams_backend.repository.TapeNameTNSRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tape-name-tns")
public class TapeNameTNSController {

    @Autowired
    private TapeNameTNSRepository repository;

    @GetMapping
    public List<TapeNameTNS> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public TapeNameTNS save(@RequestBody TapeNameTNS payload) {
        if (payload.getDescription() == null) payload.setDescription("");
        if (payload.getModel() == null) payload.setModel("");
        if (payload.getCamping() == null) payload.setCamping("");

        LocalDateTime now = LocalDateTime.now().withNano(0); // Áo giáp chống lỗi datetime2

        if (payload.getTapeNameId() == null) {
            // THÊM MỚI
            payload.setDateCreated(now);
            payload.setDateUpdated(now);
            payload.setUserCreated(1);
            payload.setUserUpdated(1);
            return repository.save(payload);
        } else {
            // CẬP NHẬT
            TapeNameTNS existing = repository.findById(payload.getTapeNameId()).orElse(null);
            if (existing != null) {
                existing.setTapeId(payload.getTapeId());
                existing.setModel(payload.getModel());
                existing.setCamping(payload.getCamping());
                existing.setDescription(payload.getDescription());

                existing.setDateUpdated(now);
                existing.setUserUpdated(1);
                return repository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}