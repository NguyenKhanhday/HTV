package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChannelID")
    private Integer channelId;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Status")
    private Integer status;

    // --- CÁC TRƯỜNG MỚI ĐÃ ĐƯỢC CHUẨN HÓA THEO ẢNH SQL ---
    @Column(name = "LockHint")
    private Integer lockHint;
    @Column(name = "NumberDayLock") // Sửa tên cột ở đây cho khớp 100% với SQL
    private Integer numberDate;     // Biến này giữ nguyên để khỏi phải sửa bên Controller
    @Column(name = "PercentDiscount")
    private Double percentDiscount;

    @Column(name = "PercentCommission")
    private Double percentCommission;

    @Column(name = "PercentVTUT")
    private Double percentVTUT;

    @Column(name = "IsVAT")
    private Integer isVAT;

    @Column(name = "UsePriceNet")
    private Integer usePriceNet;

    // --- CÁC TRƯỜNG HỆ THỐNG ---
    @Column(name = "CreatorID")
    private Integer creatorId;

    @Column(name = "CreatedTime")
    private LocalDateTime createdTime;

    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    @Column(name = "ObjID")
    private String objId;

    @Column(name = "IsUpdate")
    private Integer isUpdate;

    @Column(name = "LastUpdate")
    private LocalDateTime lastUpdate;

    // ================= GETTER & SETTER =================
    public Integer getChannelId() { return channelId; }
    public void setChannelId(Integer channelId) { this.channelId = channelId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Integer getLockHint() { return lockHint; }
    public void setLockHint(Integer lockHint) { this.lockHint = lockHint; }

    public Integer getNumberDate() { return numberDate; }
    public void setNumberDate(Integer numberDate) { this.numberDate = numberDate; }

    public Double getPercentDiscount() { return percentDiscount; }
    public void setPercentDiscount(Double percentDiscount) { this.percentDiscount = percentDiscount; }

    public Double getPercentCommission() { return percentCommission; }
    public void setPercentCommission(Double percentCommission) { this.percentCommission = percentCommission; }

    public Double getPercentVTUT() { return percentVTUT; }
    public void setPercentVTUT(Double percentVTUT) { this.percentVTUT = percentVTUT; }

    public Integer getIsVAT() { return isVAT; }
    public void setIsVAT(Integer isVAT) { this.isVAT = isVAT; }

    public Integer getUsePriceNet() { return usePriceNet; }
    public void setUsePriceNet(Integer usePriceNet) { this.usePriceNet = usePriceNet; }

    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }

    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }

    public LocalDateTime getModifiedTime() { return modifiedTime; }
    public void setModifiedTime(LocalDateTime modifiedTime) { this.modifiedTime = modifiedTime; }

    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }

    public Integer getIsUpdate() { return isUpdate; }
    public void setIsUpdate(Integer isUpdate) { this.isUpdate = isUpdate; }

    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }
}