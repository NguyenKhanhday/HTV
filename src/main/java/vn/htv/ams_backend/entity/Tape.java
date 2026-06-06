package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Tape")
public class Tape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TapeID")
    private Integer tapeId;

    @Column(name = "ProductID")
    private Integer productId;

    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "AdTypeID")
    private Integer adTypeId;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Duration")
    private Integer duration;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "ExpiredDate")
    private LocalDateTime expiredDate;

    @Column(name = "LastUsedDate")
    private LocalDateTime lastUsedDate;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreatorID")
    private Integer creatorId;

    @Column(name = "CreatedTime")
    private LocalDateTime createdTime;

    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    // ================= GETTER & SETTER =================
    public Integer getTapeId() { return tapeId; }
    public void setTapeId(Integer tapeId) { this.tapeId = tapeId; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getAdTypeId() { return adTypeId; }
    public void setAdTypeId(Integer adTypeId) { this.adTypeId = adTypeId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public LocalDateTime getExpiredDate() { return expiredDate; }
    public void setExpiredDate(LocalDateTime expiredDate) { this.expiredDate = expiredDate; }

    public LocalDateTime getLastUsedDate() { return lastUsedDate; }
    public void setLastUsedDate(LocalDateTime lastUsedDate) { this.lastUsedDate = lastUsedDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }

    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }

    public LocalDateTime getModifiedTime() { return modifiedTime; }
    public void setModifiedTime(LocalDateTime modifiedTime) { this.modifiedTime = modifiedTime; }
}