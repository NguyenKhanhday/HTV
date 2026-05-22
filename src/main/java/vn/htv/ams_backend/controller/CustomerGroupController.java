package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.CustomerGroup;
import vn.htv.ams_backend.repository.CustomerGroupRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer-groups")
public class CustomerGroupController {

    @Autowired
    private CustomerGroupRepository customerGroupRepository;

    @GetMapping
    public List<CustomerGroup> getAll() {
        return customerGroupRepository.findAll();
    }

    @PostMapping("/save")
    public CustomerGroup save(@RequestBody CustomerGroup payload) {

        // Chống lỗi NULL
        if (payload.getDescription() == null) payload.setDescription("");

        if (payload.getCustomerGroupId() == null) {
            // === THÊM MỚI ===
            payload.setDateCreated(LocalDateTime.now());
            payload.setDateUpdated(LocalDateTime.now());
            payload.setUserCreated("Admin"); // Sau này có login thì thế tên user vào
            payload.setUserUpdated("Admin");
            payload.setObjId(UUID.randomUUID().toString());

            return customerGroupRepository.save(payload);
        } else {
            // === CẬP NHẬT ===
            CustomerGroup existing = customerGroupRepository.findById(payload.getCustomerGroupId()).orElse(null);
            if (existing != null) {
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setDescription(payload.getDescription());

                existing.setUserUpdated("Admin");
                existing.setDateUpdated(LocalDateTime.now());

                return customerGroupRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerGroupRepository.deleteById(id);
    }
}