package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID", columnDefinition = "numeric")
    private Long bookId;

    @Column(name = "SectionID", columnDefinition = "numeric")
    private Long sectionId;

    @Column(name = "ChannelID", nullable = false, columnDefinition = "numeric")
    private Long channelId;

    @Column(name = "TapeID", nullable = false, columnDefinition = "numeric")
    private Long tapeId;

    @Column(name = "Code", unique = true, nullable = false, length = 50)
    private String code;

    @Column(name = "CustomerCode", unique = true, length = 50)
    private String customerCode;

    @Column(name = "BookDate")
    private LocalDateTime bookDate;

    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "Status", columnDefinition = "tinyint")
    private Integer status = 0;

    @Column(name = "SpotCount", columnDefinition = "int")
    private Integer spotCount = 0;

    @Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "CreatorID", columnDefinition = "numeric")
    private Long creatorId;

    @Column(name = "CreatedTime", updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    @Column(name = "ObjID")
    private UUID objId;

    @Column(name = "IsUpdate", columnDefinition = "int")
    private Integer isUpdate;

    @Column(name = "LastUpdate")
    private LocalDateTime lastUpdate;

    @Column(name = "IsDieuchinh", columnDefinition = "int")
    private Integer isDieuchinh = 0;

    @Column(name = "PlanID", columnDefinition = "numeric")
    private Long planId;

    @Column(name = "UserCreate", columnDefinition = "numeric")
    private Long userCreate;  // ← đổi từ String sang Long

    @Column(name = "UserUpdate", columnDefinition = "numeric")
    private Long userUpdate;  // ← đổi từ String sang Long

    @PrePersist
    protected void onCreate() {
        createdTime = LocalDateTime.now();
        modifiedTime = LocalDateTime.now();

        if (this.objId == null)       this.objId = UUID.randomUUID();
        if (this.sectionId == null)   this.sectionId = 0L;
        if (this.channelId == null)   this.channelId = 0L;
        if (this.tapeId == null)      this.tapeId = 0L;
        if (this.status == null)      this.status = 0;
        if (this.spotCount == null)   this.spotCount = 0;
        if (this.creatorId == null)   this.creatorId = 1L;
        if (this.isUpdate == null)    this.isUpdate = 0;
        if (this.isDieuchinh == null) this.isDieuchinh = 0;
        if (this.planId == null)      this.planId = 0L;
        if (this.userCreate == null)  this.userCreate = 1L;  // ID của admin
        if (this.userUpdate == null)  this.userUpdate = 1L;

        if (this.code == null || this.code.isBlank())
            this.code = "BOOK-" + System.currentTimeMillis();
        if (this.customerCode == null || this.customerCode.isBlank())
            this.customerCode = "CUST-" + System.currentTimeMillis();
        if (this.description == null) this.description = "";

        if (this.bookDate == null)  this.bookDate = LocalDateTime.now();
        if (this.startDate == null) this.startDate = LocalDateTime.now();
        if (this.endDate == null)   this.endDate = LocalDateTime.now().plusMonths(1);
        if (this.lastUpdate == null) this.lastUpdate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedTime = LocalDateTime.now();
        lastUpdate = LocalDateTime.now();
    }
}