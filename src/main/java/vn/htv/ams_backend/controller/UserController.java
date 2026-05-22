package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.dto.ChangePasswordRequest;
import vn.htv.ams_backend.dto.LoginRequest;
import vn.htv.ams_backend.entity.Users;
import vn.htv.ams_backend.service.UserService;
import vn.htv.ams_backend.repository.UserRepository; // Import thêm cái này để dùng được userRepository

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users") // Đây là đường dẫn gốc của API
public class UserController {

    @Autowired
    private UserService userService;

    // BỔ SUNG KHAI BÁO userRepository VÀO ĐÂY
    @Autowired
    private UserRepository userRepository;

    // --- CÁC API CŨ ---

    // 1. Lấy toàn bộ danh sách User
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    // 2. Đăng nhập (Trả về Map để chống lỗi trắng màn hình bên React)
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

    // --- CÁC API MỚI THEO YÊU CẦU CỦA SẾP ---

    // 3. API lấy danh sách User đang hoạt động (Đổ dữ liệu lên cái bảng/Grid)
    @GetMapping("/active")
    public List<Users> getActiveUsers() {
        return userService.getActiveUsers();
    }

    // 4. API Lưu User (Dùng chung cho cả nút Add và Edit)
    @PostMapping("/save")
    public Map<String, Object> saveUser(@RequestBody Users user) {
        Map<String, Object> response = new HashMap<>();
        String result = userService.saveUser(user);

        if (result.equals("Lưu thành công!")) {
            response.put("success", true);
            response.put("message", result);
        } else {
            response.put("success", false);
            response.put("message", result); // Ví dụ báo: "Mã người dùng đã tồn tại!"
        }
        return response;
    }

    // 5. API Xóa mềm (Chuyển status về 0)
    @PutMapping("/delete/{id}")
    public Map<String, Object> deleteUser(@PathVariable Long id) {
        userService.softDelete(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Đã xóa người dùng!");
        return response;
    }

    // 6. API Đổi mật khẩu
    @PostMapping("/change-password")
    public Map<String, Object> changePassword(@RequestBody ChangePasswordRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Sửa lại thành Users (Có chữ s) cho khớp với khai báo entity của em
        Users user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null) {
            response.put("success", false);
            response.put("message", "Không tìm thấy người dùng!");
            return response;
        }

        // Kiểm tra mật khẩu cũ xem có khớp không
        if (!user.getPass().equals(request.getOldPassword())) {
            response.put("success", false);
            response.put("message", "Mật khẩu cũ không chính xác!");
            return response;
        }

        // Nếu mọi thứ OK -> Cập nhật mật khẩu mới và lưu lại
        user.setPass(request.getNewPassword());
        userRepository.save(user);

        response.put("success", true);
        response.put("message", "Đổi mật khẩu thành công!");
        return response;
    }
}