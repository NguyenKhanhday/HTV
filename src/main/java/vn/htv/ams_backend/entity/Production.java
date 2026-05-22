package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Producitons")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductionID")
    private Integer productionId;

    @Column(name = "ProductionCode")
    private String productionCode;

    @Column(name = "ProductionName")
    private String productionName;

    @Column(name = "ProductionAddress")
    private String productionAddress;

    @Column(name = "ProductionDescription")
    private String productionDescription;

    // ĐÃ ĐỔI TỪ STRING SANG INTEGER
    @Column(name = "UserCreated")
    private Integer userCreated;

    // ĐÃ ĐỔI TỪ STRING SANG INTEGER
    @Column(name = "UserUpdated")
    private Integer userUpdated;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "DateUpdated")
    private LocalDateTime dateUpdated;

    // ================= GETTER & SETTER =================
    public Integer getProductionId() { return productionId; }
    public void setProductionId(Integer productionId) { this.productionId = productionId; }

    public String getProductionCode() { return productionCode; }
    public void setProductionCode(String productionCode) { this.productionCode = productionCode; }

    public String getProductionName() { return productionName; }
    public void setProductionName(String productionName) { this.productionName = productionName; }

    public String getProductionAddress() { return productionAddress; }
    public void setProductionAddress(String productionAddress) { this.productionAddress = productionAddress; }

    public String getProductionDescription() { return productionDescription; }
    public void setProductionDescription(String productionDescription) { this.productionDescription = productionDescription; }

    public Integer getUserCreated() { return userCreated; }
    public void setUserCreated(Integer userCreated) { this.userCreated = userCreated; }

    public Integer getUserUpdated() { return userUpdated; }
    public void setUserUpdated(Integer userUpdated) { this.userUpdated = userUpdated; }

    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }

    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }
}