package vn.htv.ams_backend.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productID;

    @Column(name = "CatID")
    private Integer catID;

    @Column(name = "Code", unique = true, nullable = false, length = 50)
    private String code;

    @Column(name = "Name", nullable = false, length = 255)
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    // 1 = còn sử dụng, 0 = hết sử dụng
    @Column(name = "Status", nullable = false)
    private Integer status = 1;

    @Column(name = "CreatorID")
    private Integer creatorID;

    @CreationTimestamp
    @Column(name = "CreatedTime", updatable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "ModifiedTime")
    private LocalDateTime modifiedTime;

    // ObjID: tự sinh ra bởi DB, không cần quản lý

    @Column(name = "BrandName", length = 255)
    private String brandName;

    @Column(name = "ProductionID")
    private Integer productionID;
    @Column(name = "ObjID", updatable = false)
    private String objID;

    // Và thêm method này vào class:
    @PrePersist
    public void generateObjID() {
        if (this.objID == null) {
            this.objID = java.util.UUID.randomUUID().toString();
        }
    }
}