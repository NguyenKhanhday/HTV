package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Customer;
import vn.htv.ams_backend.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer payload) {
        // Gán giá trị mặc định chống lỗi hệ thống dữ liệu trống
        if (payload.getType() == null) payload.setType(1); // Mặc định loại KH là 1
        if (payload.getTypeCaculator() == null) payload.setTypeCaculator(0); // Mặc định để nguyên
        if (payload.getNumberGround() == null) payload.setNumberGround(0);
        if (payload.getPercentUpDow() == null) payload.setPercentUpDow(0.0);
        if (payload.getStatus() == null) payload.setStatus(1); // Mặc định còn sử dụng

        if (payload.getCustomerId() == null) {
            // === THÊM MỚI ===
            payload.setCreatedTime(LocalDateTime.now());
            payload.setModifiedTime(LocalDateTime.now());
            payload.setCreatorId(1); // ID của Admin tạm thời
            payload.setObjId(UUID.randomUUID().toString());
            payload.setUserId(null); // Luôn để null theo thiết kế file Excel

            return customerRepository.save(payload);
        } else {
            // === CẬP NHẬT ===
            Customer existing = customerRepository.findById(payload.getCustomerId()).orElse(null);
            if (existing != null) {
                existing.setCustomerGroupId(payload.getCustomerGroupId());
                existing.setCode(payload.getCode());
                existing.setDisplayName(payload.getDisplayName());
                existing.setPrintedName(payload.getPrintedName());
                existing.setTel(payload.getTel());
                existing.setFax(payload.getFax());
                existing.setTax(payload.getTax());
                existing.setAccountNo(payload.getAccountNo());
                existing.setAccountBank(payload.getAccountBank());
                existing.setStatus(payload.getStatus());
                existing.setType(payload.getType());
                existing.setAddress(payload.getAddress());
                existing.setDescription(payload.getDescription());
                existing.setTypeCaculator(payload.getTypeCaculator());
                existing.setNumberGround(payload.getNumberGround());
                existing.setPercentUpDow(payload.getPercentUpDow());

                existing.setModifiedTime(LocalDateTime.now());

                return customerRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerRepository.deleteById(id);
    }
}