package vn.htv.ams_backend.controller;
import vn.htv.ams_backend.entity.Product;
import vn.htv.ams_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Cho phép React (localhost:3000) gọi API
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // ─── GET ALL ────────────────────────────────────────────────────────────────
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    // ─── GET BY ID ──────────────────────────────────────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────────
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product) {
        // Kiểm tra mã sản phẩm đã tồn tại chưa
        if (productRepository.existsByCode(product.getCode())) {
            return ResponseEntity.badRequest()
                    .body("Mã sản phẩm '" + product.getCode() + "' đã tồn tại.");
        }
        // createdTime & modifiedTime tự động gán bởi @CreationTimestamp / @UpdateTimestamp
        Product saved = productRepository.save(product);
        return ResponseEntity.ok(saved);
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────────
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody Product payload) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product existing = optional.get();

        // Nếu code thay đổi, kiểm tra trùng với sản phẩm khác
        if (!existing.getCode().equals(payload.getCode())
                && productRepository.existsByCode(payload.getCode())) {
            return ResponseEntity.badRequest()
                    .body("Mã sản phẩm '" + payload.getCode() + "' đã tồn tại.");
        }

        // Cập nhật các trường
        existing.setCatID(payload.getCatID());
        existing.setCode(payload.getCode());
        existing.setName(payload.getName());
        existing.setDescription(payload.getDescription());
        existing.setStatus(payload.getStatus());
        existing.setCreatorID(payload.getCreatorID());
        existing.setBrandName(payload.getBrandName());
        existing.setProductionID(payload.getProductionID());
        // modifiedTime tự cập nhật bởi @UpdateTimestamp

        return ResponseEntity.ok(productRepository.save(existing));
    }

    // ─── DELETE ─────────────────────────────────────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ─── FILTER BY STATUS ───────────────────────────────────────────────────────
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Product>> getByStatus(@PathVariable Integer status) {
        return ResponseEntity.ok(productRepository.findByStatus(status));
    }

    // ─── SEARCH BY NAME ─────────────────────────────────────────────────────────
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam String name) {
        return ResponseEntity.ok(productRepository.findByNameContainingIgnoreCase(name));
    }
}