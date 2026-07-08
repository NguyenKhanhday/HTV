package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Block")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlockID")
    private Integer blockId;

    @Column(name = "ChannelID") private Integer channelId;
    @Column(name = "PeriodID") private Integer periodId;
    @Column(name = "BlockGroupID") private Integer blockGroupId;
    @Column(name = "PriceID") private Integer priceId;
    @Column(name = "PriorityID") private Integer priorityId;

    @Column(name = "Code", unique = true) private String code;
    @Column(name = "DisplayName") private String displayName;
    @Column(name = "PrintedName") private String printedName;

    @Column(name = "StartDate") private LocalDateTime startDate;
    @Column(name = "EndDate") private LocalDateTime endDate;
    @Column(name = "StartRange") private String startRange;
    @Column(name = "EndRange") private String endRange;

    @Column(name = "Ord") private Integer ord;
    @Column(name = "MaxDur") private Integer maxDur;

    @Column(name = "Status") private Integer status = 1;
    @Column(name = "Description") private String description;

    @Column(name = "UserCreated") private String userCreated;
    @Column(name = "UserUpdated") private String userUpdated;
    @Column(name = "DateCreated") private LocalDateTime dateCreated;
    @Column(name = "DateUpdated") private LocalDateTime dateUpdated;

    @Column(name = "ObjID", updatable = false)
    private String objId;

    // --- GETTERS & SETTERS (Em dùng tính năng Generate của IntelliJ hoặc Lombok @Data nhé) ---
    public Integer getBlockId() { return blockId; }
    public void setBlockId(Integer blockId) { this.blockId = blockId; }
    public Integer getChannelId() { return channelId; }
    public void setChannelId(Integer channelId) { this.channelId = channelId; }
    public Integer getPeriodId() { return periodId; }
    public void setPeriodId(Integer periodId) { this.periodId = periodId; }
    public Integer getBlockGroupId() { return blockGroupId; }
    public void setBlockGroupId(Integer blockGroupId) { this.blockGroupId = blockGroupId; }
    public Integer getPriceId() { return priceId; }
    public void setPriceId(Integer priceId) { this.priceId = priceId; }
    public Integer getPriorityId() { return priorityId; }
    public void setPriorityId(Integer priorityId) { this.priorityId = priorityId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
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
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getUserCreated() { return userCreated; }
    public void setUserCreated(String userCreated) { this.userCreated = userCreated; }
    public String getUserUpdated() { return userUpdated; }
    public void setUserUpdated(String userUpdated) { this.userUpdated = userUpdated; }
    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }
    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }
}