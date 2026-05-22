package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "CustomerGroupID") // Có thể null nếu không chọn nhóm
    private Integer customerGroupId;

    @Column(name = "Code", nullable = false, unique = true)
    private String code;

    @Column(name = "DisplayName")
    private String displayName;

    @Column(name = "PrintedName")
    private String printedName;

    @Column(name = "Tel")
    private String tel;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Tax")
    private String tax;

    @Column(name = "AccountNo")
    private String accountNo;

    @Column(name = "AccountBank")
    private String accountBank;

    @Column(name = "Status") // 1: Sử dụng, 0: Ngừng sử dụng
    private Integer status;

    @Column(name = "Type") // Mặc định là 1
    private Integer type;

    @Column(name = "Address")
    private String address;

    @Column(name = "Description")
    private String description;

    @Column(name = "TypeCaculator") // 0: Để nguyên, 1: Tròn lên, 2: Tròn xuống
    private Integer typeCaculator;

    @Column(name = "NumberGround")
    private Integer numberGround;

    @Column(name = "PercentUpDow")
    private Double percentUpDow;

    // --- CÁC TRƯỜNG HỆ THỐNG ---
    @Column(name = "CreatorID")
    private Integer creatorId;

    @Column(name = "CreatedTime")
    private LocalDateTime createdTime;

    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    @Column(name = "ObjID")
    private String objId;

    @Column(name = "UserId") // Mặc định để null theo tài liệu thiết kế
    private Integer userId;

    // ================= GETTER & SETTER =================
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getCustomerGroupId() { return customerGroupId; }
    public void setCustomerGroupId(Integer customerGroupId) { this.customerGroupId = customerGroupId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getPrintedName() { return printedName; }
    public void setPrintedName(String printedName) { this.printedName = printedName; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public String getFax() { return fax; }
    public void setFax(String fax) { this.fax = fax; } // Sửa lại thành thế này nhé

public String getTax() { return tax; }
public void setTax(String tax) { this.tax = tax; }

public String getAccountNo() { return accountNo; }
public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

public String getAccountBank() { return accountBank; }
public void setAccountBank(String accountBank) { this.accountBank = accountBank; }

public Integer getStatus() { return status; }
public void setStatus(Integer status) { this.status = status; }

public Integer getType() { return type; }
public void setType(Integer type) { this.type = type; }

public String getAddress() { return address; }
public void setAddress(String address) { this.address = address; }

public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }

public Integer getTypeCaculator() { return typeCaculator; }
public void setTypeCaculator(Integer typeCaculator) { this.typeCaculator = typeCaculator; }

public Integer getNumberGround() { return numberGround; }
public void setNumberGround(Integer numberGround) { this.numberGround = numberGround; }

public Double getPercentUpDow() { return percentUpDow; }
public void setPercentUpDow(Double percentUpDow) { this.percentUpDow = percentUpDow; }

public Integer getCreatorId() { return creatorId; }
public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }

public LocalDateTime getCreatedTime() { return createdTime; }
public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }

public LocalDateTime getModifiedTime() { return modifiedTime; }
public void setModifiedTime(LocalDateTime modifiedTime) { this.modifiedTime = modifiedTime; }

public String getObjId() { return objId; }
public void setObjId(String objId) { this.objId = objId; }

public Integer getUserId() { return userId; }
public void setUserId(Integer userId) { this.userId = userId; }
}