package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PaymentTerm")
public class PaymentTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TermID")
    private Integer termId;

    @Column(name = "ContractID") private Integer contractId;
    @Column(name = "SectionID") private Integer sectionId;

    @Column(name = "PaymentDate") private LocalDateTime paymentDate;
    @Column(name = "Amount") private Double amount = 0.0;
    @Column(name = "Currency") private Integer currency = 0; // 0: Đồng, 1: USD

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "CreatedTime") private LocalDateTime createdTime;
    @Column(name = "ModifiedTime") private LocalDateTime modifiedTime;
    @Column(name = "ObjID", updatable = false) private String objId;
    @Column(name = "ModifiedID") private Integer modifiedId;


}