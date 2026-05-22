package vn.htv.ams_backend.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Deparment") // Ghi đúng tên bảng anh Lập viết trong SQL
public class Department {
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Id
    @Column(name = "DeparmentID")
    private Long departmentId;

    @Column(name = "DeparmentName")
    private String departmentName;

    // Getter and Setter...
}