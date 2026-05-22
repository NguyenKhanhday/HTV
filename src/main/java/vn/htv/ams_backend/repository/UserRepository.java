package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.Users;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    // Tìm danh sách user đang hoạt động (Status = 1)
    List<Users> findByStatus(Integer status);

    // Kiểm tra xem mã đăng nhập đã tồn tại chưa (Dùng cho nút Add)
    boolean existsByCode(String code);

    // Tìm user theo mã đăng nhập (Dùng cho Login)
    Users findByCode(String code);
}