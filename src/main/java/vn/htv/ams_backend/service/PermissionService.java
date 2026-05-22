package vn.htv.ams_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.htv.ams_backend.entity.Channel;
import vn.htv.ams_backend.entity.UserChannel;
import vn.htv.ams_backend.repository.ChannelRepository;
import vn.htv.ams_backend.repository.UserChannelRepository;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserChannelRepository userChannelRepository;

    // 1. Lấy tất cả các kênh đang hoạt động
    public List<Channel> getAllActiveChannels() {
        return channelRepository.findByStatus(1);
    }

    // 2. Lấy danh sách quyền của User
    public List<UserChannel> getPermissionsByUserId(Integer userId) {
        return userChannelRepository.findByUserId(userId);
    }
    // 3. Lưu quyền (Xóa sạch quyền cũ rồi lưu danh sách quyền mới)
    @org.springframework.transaction.annotation.Transactional
    public void savePermissions(Integer userId, List<Integer> channelIds) {
        // Xóa hết quyền cũ
        userChannelRepository.deleteByUserId(userId);

        // Lưu từng quyền mới vào bảng UserChannel
        for (Integer cId : channelIds) {
            UserChannel uc = new UserChannel();
            uc.setUserId(userId);
            uc.setChannelId(cId);

            // Gán ngày tạo và người tạo
            uc.setDateCreated(java.time.LocalDateTime.now());
            uc.setUserCreated(1);

            // BỔ SUNG 2 DÒNG NÀY ĐỂ TRÁNH LỖI NOT NULL BÊN SQL:
            uc.setDateUpdated(java.time.LocalDateTime.now());
            uc.setUserUpdated(1);

            userChannelRepository.save(uc);
        }
    }
}