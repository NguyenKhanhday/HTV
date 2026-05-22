package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CustomerGroups")
public class CustomerGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerGroupID")
    private Integer customerGroupId;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    // --- CÁC TRƯỜNG HỆ THỐNG CỦA BẢNG NÀY ---
    @Column(name = "ObjID")
    private String objId;

    @Column(name = "UserCreated")
    private String userCreated;

    @Column(name = "UserUpdated")
    private String userUpdated;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "DateUpdated")
    private LocalDateTime dateUpdated;

    // ================= GETTER & SETTER =================
    public Integer getCustomerGroupId() { return customerGroupId; }
    public void setCustomerGroupId(Integer customerGroupId) { this.customerGroupId = customerGroupId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getObjId() { return objId; }
    public void setObjId(String objId) { this.objId = objId; }

    public String getUserCreated() { return userCreated; }
    public void setUserCreated(String userCreated) { this.userCreated = userCreated; }

    public String getUserUpdated() { return userUpdated; }
    public void setUserUpdated(String userUpdated) { this.userUpdated = userUpdated; }

    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }

    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }
}