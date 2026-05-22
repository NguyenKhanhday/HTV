package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Channel;
import vn.htv.ams_backend.repository.ChannelRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    @GetMapping
    public List<Channel> getAll() {
        return channelRepository.findAll();
    }

    @PostMapping("/save")
    public Channel save(@RequestBody Channel payload) {
        // Chống lỗi NULL cho các cột số (Mặc định là 0 nếu React không gửi xuống)
        if (payload.getLockHint() == null) payload.setLockHint(0);
        if (payload.getNumberDate() == null) payload.setNumberDate(0);
        if (payload.getPercentDiscount() == null) payload.setPercentDiscount(0.0);
        if (payload.getPercentCommission() == null) payload.setPercentCommission(0.0);
        if (payload.getPercentVTUT() == null) payload.setPercentVTUT(0.0);
        if (payload.getIsVAT() == null) payload.setIsVAT(0);
        if (payload.getUsePriceNet() == null) payload.setUsePriceNet(0);
        if (payload.getIsUpdate() == null) payload.setIsUpdate(0);

        if (payload.getChannelId() == null) {
            // === THÊM MỚI ===
            payload.setCreatedTime(LocalDateTime.now());
            payload.setModifiedTime(LocalDateTime.now());
            if (payload.getStatus() == null) payload.setStatus(1);
            payload.setCreatorId(1);
            payload.setObjId(UUID.randomUUID().toString());

            return channelRepository.save(payload);
        } else {
            // === CẬP NHẬT ===
            Channel existing = channelRepository.findById(payload.getChannelId()).orElse(null);
            if (existing != null) {
                existing.setCode(payload.getCode());
                existing.setName(payload.getName());
                existing.setStatus(payload.getStatus());

                existing.setLockHint(payload.getLockHint());
                existing.setNumberDate(payload.getNumberDate());
                existing.setPercentDiscount(payload.getPercentDiscount());
                existing.setPercentCommission(payload.getPercentCommission());
                existing.setPercentVTUT(payload.getPercentVTUT());
                existing.setIsVAT(payload.getIsVAT());
                existing.setUsePriceNet(payload.getUsePriceNet());

                existing.setModifiedTime(LocalDateTime.now());
                existing.setIsUpdate(1); // Đánh dấu là đã bị update
                existing.setLastUpdate(LocalDateTime.now());

                return channelRepository.save(existing);
            }
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        channelRepository.deleteById(id);
    }
}