package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Contract")
@Data

public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContractID")
    private Integer contractId;

    @Column(name = "CustomerID") private Integer customerId;
    @Column(name = "CTypeID") private Integer cTypeId;

    @Column(name = "Code", unique = true) private String code;

    @Column(name = "SignDate") private LocalDateTime signDate;
    @Column(name = "StartDate") private LocalDateTime startDate;
    @Column(name = "EndDate") private LocalDateTime endDate;

    @Column(name = "SignSource") private Integer signSource = 0; // 0: TT Dịch vụ, 1: Đài TH
    @Column(name = "Status") private Integer status = 0; // 0: Đang thực hiện, 1: Kết thúc

    @Column(name = "[Content]") private String content; // Bọc ngoặc vuông chống lỗi từ khóa SQL
    @Column(name = "Description") private String description;
    @Column(name = "ManageEmployee") private Integer manageEmployee;

    @Column(name = "BlockID") private Integer blockId;
    @Column(name = "CountCT") private Integer countCt = 0;

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "CreatedTime") private LocalDateTime createdTime;
    @Column(name = "ModifiedTime") private LocalDateTime modifiedTime;
    @Column(name = "ObjID", updatable = false) private String objId;


}