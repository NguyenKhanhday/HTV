package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PriceID")
    private Integer priceId;

    @Column(name = "Code", unique = true)
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private Integer status = 1; // 1: Đang dùng, 0: Hết hạn

    @Column(name = "CreatorID")
    private Integer creatorId;

    @Column(name = "CreatedTime")
    private LocalDateTime createdTime;

    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    @Column(name = "EffectDate")
    private LocalDateTime effectDate;
    @Column(name = "ObjID", updatable = false)
    private String objId;
    // Getters và Setters
    public Integer getPriceId() { return priceId; }
    public void setPriceId(Integer priceId) { this.priceId = priceId; }
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
    public LocalDateTime getEffectDate() { return effectDate; }
    public void setEffectDate(LocalDateTime effectDate) { this.effectDate = effectDate; }

    // Getter và Setter cho ObjID
    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }
}