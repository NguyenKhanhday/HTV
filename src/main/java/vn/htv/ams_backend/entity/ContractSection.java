package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data // Phép thuật của Lombok: Tự sinh Getter/Setter ngầm, code siêu gọn!
@Entity
@Table(name = "ContractSection")
public class ContractSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SectionID")
    private Integer sectionId;

    @Column(name = "ContractID") private Integer contractId;
    @Column(name = "CTypeID") private Integer cTypeId;

    @Column(name = "Code", unique = true) private String code;
    @Column(name = "Name") private String name;

    @Column(name = "StartDate") private LocalDateTime startDate;
    @Column(name = "EndDate") private LocalDateTime endDate;

    @Column(name = "Value") private Double value = 0.0;
    @Column(name = "ExcludeValue") private Double excludeValue = 0.0;
    @Column(name = "Currency") private Integer currency = 0; // 0: Đồng, 1: USD
    @Column(name = "Discount") private Double discount = 0.0;

    @Column(name = "BookPolicy") private Integer bookPolicy = 0;
    @Column(name = "IncomePolicy") private Integer incomePolicy = 0;
    @Column(name = "InvoicePolicy") private Integer invoicePolicy = 0;
    @Column(name = "PriorityPolicy") private Integer priorityPolicy = 0;

    @Column(name = "InvoiceDay") private Integer invoiceDay = 0;
    @Column(name = "PaymentDay") private Integer paymentDay = 0;

    @Column(name = "MaxPriorityValue") private Double maxPriorityValue = 0.0;
    @Column(name = "MaxPrioritySpot") private Integer maxPrioritySpot = 0;
    @Column(name = "MaxBookValue") private Double maxBookValue = 0.0;
    @Column(name = "MaxBookSpot") private Integer maxBookSpot = 0;

    @Column(name = "Status") private Integer status = 0; // 0: Đang thực hiện, 1: Kết thúc
    @Column(name = "Description") private String description;

    @Column(name = "Booked") private Double booked = 0.0;
    @Column(name = "PriorityID") private Integer priorityId;
    @Column(name = "DiscountAfterNet") private Double discountAfterNet = 0.0;
    @Column(name = "IsCPP") private Integer isCpp = 0;
    @Column(name = "AmuontCT") private Double amuontCT = 0.0; // Giữ nguyên tên gốc (kể cả lỗi chính tả của DB)
    @Column(name = "ValuesCommitment") private Double valuesCommitment = 0.0;

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "CreatedTime") private LocalDateTime createdTime;
    @Column(name = "ModifiedTime") private LocalDateTime modifiedTime;
    @Column(name = "ObjID", updatable = false) private String objId;
}