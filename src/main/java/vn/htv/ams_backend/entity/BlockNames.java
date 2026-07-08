package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BlockNames")
public class BlockNames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlockNameID")
    private Integer blockNameId;

    @Column(name = "BlockID") private Integer blockId;
    @Column(name = "ContentID") private Integer contentId;

    @Column(name = "IsRepeat") private Integer isRepeat = 0;
    @Column(name = "IsRerun") private Integer isRerun = 0;

    @Column(name = "PrintName") private String printName;
    @Column(name = "Description") private String description;

    @Column(name = "StartDate") private LocalDateTime startDate;
    @Column(name = "EndDate") private LocalDateTime endDate;

    @Column(name = "ObjID", updatable = false) private String objId;

    // Lịch phát sóng trong tuần (1 = có chiếu, 0 = không chiếu)
    @Column(name = "MON") private Integer mon = 0;
    @Column(name = "TUE") private Integer tue = 0;
    @Column(name = "WEB") private Integer web = 0; // Chú ý: Bám sát thiết kế DB (WEB)
    @Column(name = "THU") private Integer thu = 0;
    @Column(name = "FRI") private Integer fri = 0;
    @Column(name = "SAT") private Integer sat = 0;
    @Column(name = "SUN") private Integer sun = 0;

    @Column(name = "OrderAir") private Integer orderAir;

    // --- GETTERS & SETTERS ---
    public Integer getBlockNameId() { return blockNameId; }
    public void setBlockNameId(Integer blockNameId) { this.blockNameId = blockNameId; }
    public Integer getBlockId() { return blockId; }
    public void setBlockId(Integer blockId) { this.blockId = blockId; }
    public Integer getContentId() { return contentId; }
    public void setContentId(Integer contentId) { this.contentId = contentId; }
    public Integer getIsRepeat() { return isRepeat; }
    public void setIsRepeat(Integer isRepeat) { this.isRepeat = isRepeat; }
    public Integer getIsRerun() { return isRerun; }
    public void setIsRerun(Integer isRerun) { this.isRerun = isRerun; }
    public String getPrintName() { return printName; }
    public void setPrintName(String printName) { this.printName = printName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }
    public Integer getMon() { return mon; }
    public void setMon(Integer mon) { this.mon = mon; }
    public Integer getTue() { return tue; }
    public void setTue(Integer tue) { this.tue = tue; }
    public Integer getWeb() { return web; }
    public void setWeb(Integer web) { this.web = web; }
    public Integer getThu() { return thu; }
    public void setThu(Integer thu) { this.thu = thu; }
    public Integer getFri() { return fri; }
    public void setFri(Integer fri) { this.fri = fri; }
    public Integer getSat() { return sat; }
    public void setSat(Integer sat) { this.sat = sat; }
    public Integer getSun() { return sun; }
    public void setSun(Integer sun) { this.sun = sun; }
    public Integer getOrderAir() { return orderAir; }
    public void setOrderAir(Integer orderAir) { this.orderAir = orderAir; }
}