package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Spot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SpotID")
    private Integer spotId;

    @Column(name = "BookID", nullable = false)
    private Integer bookId;

    @Column(name = "SlotID")
    private Integer slotId;

    @Column(name = "Position", length = 50)
    private String position;

    @Column(name = "Date")
    private LocalDateTime date;

    @Column(name = "Ord")
    private Integer ord = 0;

    @Column(name = "Policy")
    private Integer policy = 0;

    @Column(name = "Priority")
    private Integer priority = 0;

    @Column(name = "Amount")
    private Double amount = 0.0;

    @Column(name = "PriorityAmount")
    private Double priorityAmount = 0.0;

    @Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "CreatorID")
    private Integer creatorId;

    @Column(name = "CreatedTime", updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    @Column(name = "ObjID")          // ← bỏ length = 50
    private UUID objId;              // ← đổi từ String sang UUID

    @Column(name = "ScheduleTime")
    private LocalDateTime scheduleTime;

    @Column(name = "BroadcastTime")
    private LocalDateTime broadcastTime;

    @Column(name = "isBroadcast")
    private Integer isBroadcast = 0;

    @Column(name = "NoteError", columnDefinition = "NVARCHAR(MAX)")
    private String noteError;

    @Column(name = "IdSpotCancel")
    private Integer idSpotCancel = 0;

    @Column(name = "IsStatus")
    private Integer isStatus = 0;

    @PrePersist
    protected void onCreate() {
        createdTime = LocalDateTime.now();
        modifiedTime = LocalDateTime.now();

        if (this.objId == null) this.objId = UUID.randomUUID(); // ← thêm dòng này

        if (creatorId == null)      creatorId = 1;
        if (policy == null)         policy = 0;
        if (priority == null)       priority = 0;
        if (amount == null)         amount = 0.0;
        if (priorityAmount == null) priorityAmount = 0.0;
        if (isBroadcast == null)    isBroadcast = 0;
        if (idSpotCancel == null)   idSpotCancel = 0;
        if (isStatus == null)       isStatus = 0;
        if (ord == null)            ord = 0;
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedTime = LocalDateTime.now();
    }
}