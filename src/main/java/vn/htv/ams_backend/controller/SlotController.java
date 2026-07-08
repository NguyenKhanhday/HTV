package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Slot;
import vn.htv.ams_backend.repository.SlotRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/slots")
@CrossOrigin("*")
public class SlotController {

    @Autowired
    private SlotRepository repository;

    @GetMapping
    public List<Slot> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public Slot save(@RequestBody Slot payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getSlotId() == null) {
            payload.setCreatedTime(now);
            payload.setCreatorId(1);
            payload.setObjId(UUID.randomUUID().toString()); // Fix lỗi null ObjID
        }
        payload.setModifiedTime(now);
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}