package vn.htv.ams_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.htv.ams_backend.entity.Users;
import vn.htv.ams_backend.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ==========================================
    // PHẦN 1: CÁC HÀM CŨ (ĐĂNG NHẬP, LẤY TẤT CẢ)
    // ==========================================

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> response = new HashMap<>();

        Users user = userRepository.findByCode(username);

        if (user == null) {
            response.put("success", false);
            response.put("message", "Sai tên đăng nhập!");
            return response;
        }

        // Lưu ý: Dùng getPass() cho khớp với Entity mới
        if (!password.equals(user.getPass())) {
            response.put("success", false);
            response.put("message", "Sai mật khẩu!");
            return response;
        }

        response.put("success", true);
        response.put("message", "Đăng nhập thành công!");
        response.put("user", user);

        return response;
    }

    // ==========================================
    // PHẦN 2: CÁC HÀM MỚI THEO YÊU CẦU CỦA SẾP
    // ==========================================

    // 1. Lấy danh sách (Chỉ lấy Status = 1)
    public List<Users> getActiveUsers() {
        return userRepository.findByStatus(1);
    }

    // 2. Thêm hoặc Sửa User
    public String saveUser(Users user) {
        // Kiểm tra trùng Code khi thêm mới
        if (user.getUserId() == null && userRepository.existsByCode(user.getCode())) {
            return "Mã người dùng đã tồn tại!";
        }

        // Gán thời gian tạo/cập nhật tự động
        if (user.getUserId() == null) {
            user.setCreatedTime(LocalDateTime.now());
            user.setStatus(1);
        } else {
            user.setUpdateTime(LocalDateTime.now());
        }

        userRepository.save(user);
        return "Lưu thành công!";
    }

    // 3. Xóa mềm (Chuyển Status về 0)
    public void softDelete(Long id) {
        Users user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(0);
            userRepository.save(user);
        }
    }
}