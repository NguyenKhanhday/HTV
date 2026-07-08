package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PriorityPolicyDetail")
public class PriorityPolicyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PriorityDetailID")
    private Integer priorityDetailId;

    @Column(name = "PriorityID") private Integer priorityId;
    @Column(name = "Positions") private Integer positions;

    @Column(name = "Price") private Double price;
    @Column(name = "Unit")
    private Integer unit;

    @Column(name = "Type") private Integer type; // 0: % chỉ định, 1: % của spot, 2: % giá trị cụ thể

    @Column(name = "Description") private String description;

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "CreatedTime") private LocalDateTime createdTime;
    @Column(name = "ModifiedTime") private LocalDateTime modifiedTime;
    @Column(name = "ObjID", updatable = false) private String objId;

    // --- GETTERS & SETTERS (Em dùng tính năng Generate của IntelliJ để tạo tự động nhé) ---
    public Integer getPriorityDetailId() { return priorityDetailId; }
    public void setPriorityDetailId(Integer priorityDetailId) { this.priorityDetailId = priorityDetailId; }
    public Integer getPriorityId() { return priorityId; }
    public void setPriorityId(Integer priorityId) { this.priorityId = priorityId; }
    public Integer getPositions() { return positions; }
    public void setPositions(Integer positions) { this.positions = positions; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getUnit() { return unit; }
    public void setUnit(Integer unit) { this.unit = unit; }
    public Integer getType() { return type; }
    public void setType(Integer type) { this.type = type; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
    public LocalDateTime getModifiedTime() { return modifiedTime; }
    public void setModifiedTime(LocalDateTime modifiedTime) { this.modifiedTime = modifiedTime; }
    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }
}