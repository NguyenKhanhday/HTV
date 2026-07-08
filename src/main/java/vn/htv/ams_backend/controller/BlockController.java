package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Block;
import vn.htv.ams_backend.repository.BlockRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/blocks")
@CrossOrigin("*")
public class BlockController {

    @Autowired
    private BlockRepository repository;

    @GetMapping
    public List<Block> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public Block save(@RequestBody Block payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getBlockId() == null) {
            payload.setDateCreated(now);
            payload.setUserCreated("Admin"); // Có thể đổi thành user đang đăng nhập sau này
            // Fix lỗi SQL đòi ObjID:
            payload.setObjId(UUID.randomUUID().toString());
        }
        payload.setDateUpdated(now);
        payload.setUserUpdated("Admin");
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}