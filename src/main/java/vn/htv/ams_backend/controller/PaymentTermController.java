package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.PaymentTerm;
import vn.htv.ams_backend.repository.PaymentTermRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment-terms")
@CrossOrigin("*")
public class PaymentTermController {

    @Autowired
    private PaymentTermRepository repository;

    @GetMapping
    public List<PaymentTerm> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public PaymentTerm save(@RequestBody PaymentTerm payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);

        if (payload.getTermId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1); // Gán người tạo = 1
            payload.setObjId(UUID.randomUUID().toString());
        }

        payload.setModifiedTime(now);

        // THÊM DÒNG NÀY ĐỂ FIX TRỰC TIẾP LỖI 515 NULL MODIFIED_ID
        payload.setModifiedId(1); // Gán người cập nhật = 1

        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}