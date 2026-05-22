package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ProductCategory") // Tên bảng chuẩn xác 100%
public class ProductGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatID") // Cột ID tên là CatID theo Excel
    private Integer catId;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status") // Thêm cột Trạng thái
    private Integer status;

    @Column(name = "CreatorID")
    private Integer creatorId;

    @Column(name = "CreatedTime")
    private LocalDateTime createdTime;

    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    @Column(name = "ObjID")
    private String objId;

    // ================= GETTER & SETTER =================
    public Integer getCatId() { return catId; }
    public void setCatId(Integer catId) { this.catId = catId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }

    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }

    public LocalDateTime getModifiedTime() { return modifiedTime; }
    public void setModifiedTime(LocalDateTime modifiedTime) { this.modifiedTime = modifiedTime; }

    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }
}