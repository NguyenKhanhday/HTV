package vn.htv.ams_backend.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PriceDetail")
public class PriceDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PriceDetailID") private Integer priceDetailId;

    @Column(name = "PriceID") private Integer priceId;
    @Column(name = "MinDur") private Integer minDur;
    @Column(name = "MaxDur") private Integer maxDur;
    @Column(name = "Unit") private String unit;
    @Column(name = "Type") private Integer type = 0; // 0: Đơn giá, 1: Tam suất
    @Column(name = "Amount") private Double amount;

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "CreatedTime") private LocalDateTime createdTime;
    @Column(name = "ModifiedTime") private LocalDateTime modifiedTime;
    @Column(name = "ObjID", updatable = false) private String objId;

    // Sinh Getter/Setter tại đây...

    public Integer getPriceDetailId() {
        return priceDetailId;
    }

    public void setPriceDetailId(Integer priceDetailId) {
        this.priceDetailId = priceDetailId;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getMinDur() {
        return minDur;
    }

    public void setMinDur(Integer minDur) {
        this.minDur = minDur;
    }

    public Integer getMaxDur() {
        return maxDur;
    }

    public void setMaxDur(Integer maxDur) {
        this.maxDur = maxDur;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
}