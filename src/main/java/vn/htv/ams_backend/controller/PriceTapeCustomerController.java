package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.PriceTapeCustomer;
import vn.htv.ams_backend.repository.PriceTapeCustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/price-tape-customers")
public class PriceTapeCustomerController {

    @Autowired
    private PriceTapeCustomerRepository repository;

    @GetMapping
    public List<PriceTapeCustomer> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public PriceTapeCustomer save(@RequestBody PriceTapeCustomer payload) {
        if (payload.getDescription() == null) payload.setDescription("");

        // Bảo vệ ngày tháng cho SQL Server
        LocalDateTime now = LocalDateTime.now().withNano(0);

        if (payload.getDateStart() != null && payload.getDateStart().getYear() < 1753) payload.setDateStart(null);
        if (payload.getDateEnd() != null && payload.getDateEnd().getYear() < 1753) payload.setDateEnd(null);

        if (payload.getPriceTapeId() == null) {
            // THÊM MỚI
            payload.setDateCreated(now);
            payload.setDateUpdated(now);
            payload.setUserCreated(1); // Mặc định ID Admin
            payload.setUserUpdated(1);
            return repository.save(payload);
        } else {
            // CẬP NHẬT
            PriceTapeCustomer existing = repository.findById(payload.getPriceTapeId()).orElse(null);
            if (existing != null) {
                existing.setTapeId(payload.getTapeId());
                existing.setCustomerId(payload.getCustomerId());
                existing.setPriceAmount(payload.getPriceAmount());
                existing.setPriorityAmount(payload.getPriorityAmount());
                existing.setDateStart(payload.getDateStart());
                existing.setDateEnd(payload.getDateEnd());
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