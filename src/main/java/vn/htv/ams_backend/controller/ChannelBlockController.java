package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.ChannelBlock;
import vn.htv.ams_backend.repository.ChannelBlockRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/channel-blocks")
@CrossOrigin("*")
public class ChannelBlockController {

    @Autowired
    private ChannelBlockRepository repository;

    // API lấy danh sách kênh theo ID của Block
    @GetMapping("/block/{blockId}")
    public List<ChannelBlock> getByBlockId(@PathVariable Integer blockId) {
        return repository.findAll().stream()
                .filter(cb -> cb.getBlockId() != null && cb.getBlockId().equals(blockId))
                .collect(Collectors.toList());
    }

    // API lưu hàng loạt kênh cho 1 Block
    @PostMapping("/save-batch")
    public void saveBatch(@RequestParam Integer blockId, @RequestBody List<Integer> channelIds) {
        // 1. Xóa các kênh cũ của block này
        List<ChannelBlock> oldData = getByBlockId(blockId);
        repository.deleteAll(oldData);

        // 2. Thêm danh sách kênh mới
        LocalDateTime now = LocalDateTime.now().withNano(0);
        List<ChannelBlock> newData = channelIds.stream().map(cid -> {
            ChannelBlock cb = new ChannelBlock();
            cb.setBlockId(blockId);
            cb.setChannelId(cid);
            cb.setDateCreated(now);
            cb.setDateUpdated(now);
            cb.setUserUpdated("Admin");
            return cb;
        }).collect(Collectors.toList());

        repository.saveAll(newData);
    }
}