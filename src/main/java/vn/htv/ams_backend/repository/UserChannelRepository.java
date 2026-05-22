package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.htv.ams_backend.entity.UserChannel;
import java.util.List;

@Repository
public interface UserChannelRepository extends JpaRepository<UserChannel, Integer> {

    // Tìm các kênh mà User đang có quyền
    List<UserChannel> findByUserId(Integer userId);

    // Hàm xóa sạch quyền cũ để lưu quyền mới
    @Modifying
    @Transactional
    @Query("DELETE FROM UserChannel u WHERE u.userId = ?1")
    void deleteByUserId(Integer userId);
}