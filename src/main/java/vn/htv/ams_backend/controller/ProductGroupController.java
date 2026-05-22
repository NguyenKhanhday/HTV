package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.ProductGroup;
import vn.htv.ams_backend.repository.ProductGroupRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-groups")
public class ProductGroupController {

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @GetMapping
    public List<ProductGroup> getAll() {
        return productGroupRepository.findAll();
    }

    @PostMapping("/save")
    public ProductGroup save(@RequestBody ProductGroup payload) {
        if (payload.getDescription() == null) payload.setDescription("");
        if (payload.getStatus() == null) payload.setStatus(1); // Mặc định là 1 (Đang dùng)

        if (payload.getCatId() == null) {
            // THÊM MỚI
            payload.setCreatedTime(LocalDateTime.now());
            payload.setModifiedTime(LocalDateTime.now());
            payload.setCreatorId(1);
            payload.setObjId(UUID.randomUUID().toString());

            return productGroupRepository.save(payload);
        } else {
            // CẬP NHẬT
            ProductGroup existing = productGroupRepository.findById(payload.getCatId()).orElse(null);
            if (existing != null) {
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setDescription(payload.getDescription());
                existing.setStatus(payload.getStatus());

                existing.setModifiedTime(LocalDateTime.now());

                return productGroupRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productGroupRepository.deleteById(id);
    }
}