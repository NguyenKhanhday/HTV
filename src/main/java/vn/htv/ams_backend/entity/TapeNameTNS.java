package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TapeNameTNSs") // Đúng tên bảng trong ảnh
public class TapeNameTNS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TapeNameID")
    private Integer tapeNameId;

    @Column(name = "TapeID")
    private Integer tapeId;

    @Column(name = "Model")
    private String model;

    @Column(name = "Description")
    private String description;

    @Column(name = "UserCreated")
    private Integer userCreated;

    @Column(name = "UserUpdated")
    private Integer userUpdated;

    @Column(name = "DateUpdated")
    private LocalDateTime dateUpdated;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "Camping") // Giữ nguyên lỗi chính tả của DB để không lỗi map cột
    private String camping;

    // ================= GETTER & SETTER =================
    public Integer getTapeNameId() { return tapeNameId; }
    public void setTapeNameId(Integer tapeNameId) { this.tapeNameId = tapeNameId; }

    public Integer getTapeId() { return tapeId; }
    public void setTapeId(Integer tapeId) { this.tapeId = tapeId; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getUserCreated() { return userCreated; }
    public void setUserCreated(Integer userCreated) { this.userCreated = userCreated; }

    public Integer getUserUpdated() { return userUpdated; }
    public void setUserUpdated(Integer userUpdated) { this.userUpdated = userUpdated; }

    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }

    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }

    public String getCamping() { return camping; }
    public void setCamping(String camping) { this.camping = camping; }
}