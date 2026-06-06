package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.AdType;
import vn.htv.ams_backend.repository.AdTypeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ad-types")
public class AdTypeController {

    @Autowired
    private AdTypeRepository adTypeRepository;

    @GetMapping
    public List<AdType> getAll() {
        return adTypeRepository.findAll();
    }

    @PostMapping("/save")
    public AdType save(@RequestBody AdType payload) {
        if (payload.getDescription() == null) payload.setDescription("");

        if (payload.getAdTypeId() == null) {
            // THÊM MỚI
            payload.setDateCreated(LocalDateTime.now());
            payload.setDateUpdated(LocalDateTime.now());
            payload.setUserCreated(1); // Mặc định Admin ID = 1
            payload.setUserUpdated(1);
            payload.setObjId(UUID.randomUUID().toString());

            return adTypeRepository.save(payload);
        } else {
            // CẬP NHẬT
            AdType existing = adTypeRepository.findById(payload.getAdTypeId()).orElse(null);
            if (existing != null) {
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setDescription(payload.getDescription());

                existing.setUserUpdated(1);
                existing.setDateUpdated(LocalDateTime.now());

                return adTypeRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adTypeRepository.deleteById(id);
    }
}