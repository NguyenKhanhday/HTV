package vn.htv.ams_backend.dto;

import java.util.List;

public class PermissionRequest {
    private Integer userId;
    private List<Integer> channelIds;

    // --- GETTER & SETTER ---
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Integer> channelIds) {
        this.channelIds = channelIds;
    }
}