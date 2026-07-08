package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SubBlock")
public class SubBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubBlockID")
    private Integer subBlockId;

    @Column(name = "BlockID") private Integer blockId;
    @Column(name = "PriceID") private Integer priceId;
    @Column(name = "PriorityID") private Integer priorityId;
    @Column(name = "Production") private Integer productionId; // Table Producitons

    @Column(name = "DisplayName") private String displayName;
    @Column(name = "PrintedName") private String printedName;

    @Column(name = "StartDate") private LocalDateTime startDate;
    @Column(name = "EndDate") private LocalDateTime endDate;
    @Column(name = "StartRange") private String startRange;
    @Column(name = "EndRange") private String endRange;

    @Column(name = "Ord") private Integer ord = 0;
    @Column(name = "MaxDur") private Integer maxDur = 0;

    @Column(name = "Status") private Integer status = 1;
    @Column(name = "UseCaculatorGRP") private Integer useCaculatorGrp = 0;

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "CreatedTime") private LocalDateTime createdTime;
    @Column(name = "ModifiedTime") private LocalDateTime modifiedTime;
    @Column(name = "ObjID", updatable = false) private String objId;

    // --- GETTERS & SETTERS (Em dùng tính năng Generate của IntelliJ để tạo tự động nhé) ---
    public Integer getSubBlockId() { return subBlockId; }
    public void setSubBlockId(Integer subBlockId) { this.subBlockId = subBlockId; }
    public Integer getBlockId() { return blockId; }
    public void setBlockId(Integer blockId) { this.blockId = blockId; }
    public Integer getPriceId() { return priceId; }
    public void setPriceId(Integer priceId) { this.priceId = priceId; }
    public Integer getPriorityId() { return priorityId; }
    public void setPriorityId(Integer priorityId) { this.priorityId = priorityId; }
    public Integer getProductionId() { return productionId; }
    public void setProductionId(Integer productionId) { this.productionId = productionId; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public String getPrintedName() { return printedName; }
    public void setPrintedName(String printedName) { this.printedName = printedName; }
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    public String getStartRange() { return startRange; }
    public void setStartRange(String startRange) { this.startRange = startRange; }
    public String getEndRange() { return endRange; }
    public void setEndRange(String endRange) { this.endRange = endRange; }
    public Integer getOrd() { return ord; }
    public void setOrd(Integer ord) { this.ord = ord; }
    public Integer getMaxDur() { return maxDur; }
    public void setMaxDur(Integer maxDur) { this.maxDur = maxDur; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Integer getUseCaculatorGrp() { return useCaculatorGrp; }
    public void setUseCaculatorGrp(Integer useCaculatorGrp) { this.useCaculatorGrp = useCaculatorGrp; }
    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
    public LocalDateTime getModifiedTime() { return modifiedTime; }
    public void setModifiedTime(LocalDateTime modifiedTime) { this.modifiedTime = modifiedTime; }
    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }
}