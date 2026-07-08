package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.BlockNames;
import vn.htv.ams_backend.repository.BlockNamesRepository;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/block-names")
@CrossOrigin("*")
public class BlockNamesController {

    @Autowired
    private BlockNamesRepository repository;

    @GetMapping("/block/{blockId}")
    public List<BlockNames> getByBlockId(@PathVariable Integer blockId) {
        return repository.findByBlockId(blockId);
    }

    @PostMapping("/save")
    public BlockNames save(@RequestBody BlockNames payload) {
        if (payload.getBlockNameId() == null) {
            payload.setObjId(UUID.randomUUID().toString()); // Fix cứng lỗi thiếu ObjID
        }
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}