package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.PriceDetail;
import vn.htv.ams_backend.repository.PriceDetailRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/price-details")
@CrossOrigin("*")
public class PriceDetailController {

    @Autowired
    private PriceDetailRepository repository;

    @GetMapping
    public List<PriceDetail> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public PriceDetail save(@RequestBody PriceDetail payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getPriceDetailId() == null) {
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