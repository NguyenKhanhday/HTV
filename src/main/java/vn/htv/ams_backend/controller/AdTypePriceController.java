package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.AdTypePrice;
import vn.htv.ams_backend.repository.AdTypePriceRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ad-type-prices")
public class AdTypePriceController {

    @Autowired
    private AdTypePriceRepository adTypePriceRepository;

    @GetMapping
    public List<AdTypePrice> getAll() {
        return adTypePriceRepository.findAll();
    }

    @PostMapping("/save")
    public AdTypePrice save(@RequestBody AdTypePrice payload) {
        if (payload.getDescription() == null) payload.setDescription("");

        if (payload.getAdTypePriceId() == null) {
            // THÊM MỚI
            payload.setDateCreated(LocalDateTime.now());
            payload.setUserCreated(1); // Mặc định Admin ID = 1
            return adTypePriceRepository.save(payload);
        } else {
            // CẬP NHẬT
            AdTypePrice existing = adTypePriceRepository.findById(payload.getAdTypePriceId()).orElse(null);
            if (existing != null) {
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setAdTypeId(payload.getAdTypeId());
                existing.setPriceId(payload.getPriceId());
                existing.setDescription(payload.getDescription());

                return adTypePriceRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adTypePriceRepository.deleteById(id);
    }
}