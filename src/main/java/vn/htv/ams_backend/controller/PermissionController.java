package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Channel;
import vn.htv.ams_backend.entity.UserChannel;
import vn.htv.ams_backend.service.PermissionService;
import vn.htv.ams_backend.dto.PermissionRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/channels")
    public List<Channel> getChannels() {
        return permissionService.getAllActiveChannels();
    }

    @GetMapping("/user/{userId}")
    public List<Integer> getUserPermissions(@PathVariable Integer userId) {
        return permissionService.getPermissionsByUserId(userId)
                .stream()
                .map(UserChannel::getChannelId)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public Map<String, String> savePermissions(@RequestBody PermissionRequest payload) {
        if (payload.getChannelIds() != null) {
            permissionService.savePermissions(payload.getUserId(), payload.getChannelIds());
        }
        return Map.of("message", "Lưu quyền thành công!");
    }
}