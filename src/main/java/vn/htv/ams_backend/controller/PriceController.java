package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Price;
import vn.htv.ams_backend.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/prices")
@CrossOrigin("*")
public class PriceController {
    @Autowired
    private PriceRepository repository;

    @GetMapping
    public List<Price> getAll() {
        return repository.findAll();
    }
    @PostMapping("/save")
    public Price save(@RequestBody Price payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getPriceId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1);
            // THÊM DÒNG NÀY: Tự động sinh mã ngẫu nhiên (VD: 550e8400-e29b-41d4-a716-446655440000)
            payload.setObjId(java.util.UUID.randomUUID().toString());
        }
        payload.setModifiedTime(now);
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}