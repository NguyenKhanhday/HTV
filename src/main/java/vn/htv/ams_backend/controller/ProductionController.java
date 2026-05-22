package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Production;
import vn.htv.ams_backend.repository.ProductionRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/productions")
public class ProductionController {

    @Autowired
    private ProductionRepository productionRepository;

    @GetMapping
    public List<Production> getAll() {
        return productionRepository.findAll();
    }

    @PostMapping("/save")
    public Production save(@RequestBody Production payload) {
        if (payload.getProductionDescription() == null) payload.setProductionDescription("");
        if (payload.getProductionAddress() == null) payload.setProductionAddress("");

        if (payload.getProductionId() == null) {
            // THÊM MỚI
            payload.setDateCreated(LocalDateTime.now());
            payload.setDateUpdated(LocalDateTime.now());

            // LƯU BẰNG SỐ (ID = 1) THAY VÌ CHỮ "Admin"
            payload.setUserCreated(1);
            payload.setUserUpdated(1);

            return productionRepository.save(payload);
        } else {
            // CẬP NHẬT
            Production existing = productionRepository.findById(payload.getProductionId()).orElse(null);
            if (existing != null) {
                existing.setProductionCode(payload.getProductionCode());
                existing.setProductionName(payload.getProductionName());
                existing.setProductionAddress(payload.getProductionAddress());
                existing.setProductionDescription(payload.getProductionDescription());

                existing.setUserUpdated(1); // Cập nhật bằng Số
                existing.setDateUpdated(LocalDateTime.now());

                return productionRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productionRepository.deleteById(id);
    }
}