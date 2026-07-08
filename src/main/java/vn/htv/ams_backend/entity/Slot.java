package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SlotID")
    private Integer slotId;

    @Column(name = "PriceID") private Integer priceId;
    @Column(name = "SubBlockID") private Integer subBlockId;
    @Column(name = "PriorityID") private Integer priorityId;

    // 0: CN, 1: T2, 2: T3, 3: T4, 4: T5, 5: T6, 6: T7
    @Column(name = "WeekDay") private Integer weekDay;

    @Column(name = "StartDate") private LocalDateTime startDate;
    @Column(name = "EndDate") private LocalDateTime endDate; // Có thể null
    @Column(name = "IssueDate") private LocalDateTime issueDate; // Có thể null

    @Column(name = "Production") private Integer production = 0; // Mặc định là 0

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "CreatedTime") private LocalDateTime createdTime;
    @Column(name = "ModifiedTime") private LocalDateTime modifiedTime;

    @Column(name = "ObjID", updatable = false) private String objId;

    // --- GETTERS & SETTERS (Generate bằng IDE nhé) ---
    public Integer getSlotId() { return slotId; }
    public void setSlotId(Integer slotId) { this.slotId = slotId; }
    public Integer getPriceId() { return priceId; }
    public void setPriceId(Integer priceId) { this.priceId = priceId; }
    public Integer getSubBlockId() { return subBlockId; }
    public void setSubBlockId(Integer subBlockId) { this.subBlockId = subBlockId; }
    public Integer getPriorityId() { return priorityId; }
    public void setPriorityId(Integer priorityId) { this.priorityId = priorityId; }
    public Integer getWeekDay() { return weekDay; }
    public void setWeekDay(Integer weekDay) { this.weekDay = weekDay; }
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    public LocalDateTime getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDateTime issueDate) { this.issueDate = issueDate; }
    public Integer getProduction() { return production; }
    public void setProduction(Integer production) { this.production = production; }
    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
    public LocalDateTime getModifiedTime() { return modifiedTime; }
    public void setModifiedTime(LocalDateTime modifiedTime) { this.modifiedTime = modifiedTime; }
    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }
}