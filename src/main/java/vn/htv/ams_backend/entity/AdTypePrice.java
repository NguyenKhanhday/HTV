package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AdTypePrices")
public class AdTypePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdTypePriceID")
    private Integer adTypePriceId;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "AdTypeID")
    private Integer adTypeId;

    @Column(name = "PriceID")
    private Integer priceId;

    @Column(name = "Description")
    private String description;

    @Column(name = "UserCreated")
    private Integer userCreated;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    // ================= GETTER & SETTER =================
    public Integer getAdTypePriceId() { return adTypePriceId; }
    public void setAdTypePriceId(Integer adTypePriceId) { this.adTypePriceId = adTypePriceId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAdTypeId() { return adTypeId; }
    public void setAdTypeId(Integer adTypeId) { this.adTypeId = adTypeId; }

    public Integer getPriceId() { return priceId; }
    public void setPriceId(Integer priceId) { this.priceId = priceId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getUserCreated() { return userCreated; }
    public void setUserCreated(Integer userCreated) { this.userCreated = userCreated; }

    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
}