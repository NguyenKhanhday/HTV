package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PriceTapeCustomers")
public class PriceTapeCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PriceTapeID")
    private Integer priceTapeId;

    @Column(name = "TapeID")
    private Integer tapeId;

    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "PriceAmount")
    private Double priceAmount;

    @Column(name = "PriorityAmount")
    private Double priorityAmount;

    @Column(name = "DateStart")
    private LocalDateTime dateStart;

    @Column(name = "DateEnd")
    private LocalDateTime dateEnd;

    @Column(name = "Description")
    private String description;

    @Column(name = "UserCreated")
    private Integer userCreated;

    @Column(name = "UserUpdated")
    private Integer userUpdated;

    @Column(name = "DateUpdated")
    private LocalDateTime dateUpdated;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    // ================= GETTER & SETTER =================
    public Integer getPriceTapeId() { return priceTapeId; }
    public void setPriceTapeId(Integer priceTapeId) { this.priceTapeId = priceTapeId; }

    public Integer getTapeId() { return tapeId; }
    public void setTapeId(Integer tapeId) { this.tapeId = tapeId; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Double getPriceAmount() { return priceAmount; }
    public void setPriceAmount(Double priceAmount) { this.priceAmount = priceAmount; }

    public Double getPriorityAmount() { return priorityAmount; }
    public void setPriorityAmount(Double priorityAmount) { this.priorityAmount = priorityAmount; }

    public LocalDateTime getDateStart() { return dateStart; }
    public void setDateStart(LocalDateTime dateStart) { this.dateStart = dateStart; }

    public LocalDateTime getDateEnd() { return dateEnd; }
    public void setDateEnd(LocalDateTime dateEnd) { this.dateEnd = dateEnd; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getUserCreated() { return userCreated; }
    public void setUserCreated(Integer userCreated) { this.userCreated = userCreated; }

    public Integer getUserUpdated() { return userUpdated; }
    public void setUserUpdated(Integer userUpdated) { this.userUpdated = userUpdated; }

    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }

    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
}