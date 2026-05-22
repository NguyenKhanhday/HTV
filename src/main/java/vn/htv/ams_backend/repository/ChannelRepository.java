package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.htv.ams_backend.entity.Channel;
import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    // Hàm này để lấy danh sách kênh đang hoạt động
    List<Channel> findByStatus(Integer status);
}