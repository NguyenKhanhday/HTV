package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users") // Tên bảng trong SQL Server
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Code")
    private String code;

    @Column(name = "Pass")
    private String pass;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Status")
    private Integer status; // 1: Hoạt động, 0: Đã xóa

    @Column(name = "DeparmentID") // Theo đúng lỗi chính tả "Deparment" trong DB của sếp
    private Long departmentId;

    @Column(name = "UserCreate")
    private Integer userCreate;

    @Column(name = "CreatedTime")
    private LocalDateTime createdTime;

    @Column(name = "UserUpdate")
    private Integer userUpdate;

    @Column(name = "UpdateTime")
    private LocalDateTime updateTime;

    // --- GETTER AND SETTER (Dùng để UserService gọi dữ liệu) ---

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }

    public Integer getUserCreate() { return userCreate; }
    public void setUserCreate(Integer userCreate) { this.userCreate = userCreate; }

    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }

    public Integer getUserUpdate() { return userUpdate; }
    public void setUserUpdate(Integer userUpdate) { this.userUpdate = userUpdate; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }
}