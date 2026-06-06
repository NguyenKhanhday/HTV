package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Contents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContentID")
    private Integer contentID;

    @Column(name = "Code", length = 50)
    private String code;

    @Column(name = "OriginalTitle", length = 500)
    private String originalTitle;

    @Column(name = "VietNamTitle", length = 500)
    private String vietNamTitle;

    @Column(name = "OriginalEpisode")
    private Integer originalEpisode;

    @Column(name = "OriginalDuration")
    private Integer originalDuration;

    // Tạm thời không nhập
    @Column(name = "CategoryID")
    private Integer categoryID;

    // Tạm thời không nhập
    @Column(name = "CountryID")
    private Integer countryID;

    @Column(name = "TargetID")
    private Integer targetID;

    @Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    // PR Materials
    @Column(name = "PRImages", columnDefinition = "NVARCHAR(MAX)")
    private String prImages;

    @Column(name = "PROST", columnDefinition = "NVARCHAR(MAX)")
    private String prost;

    @Column(name = "PRBehindTheSing", columnDefinition = "NVARCHAR(MAX)")
    private String prBehindTheSing;

    @Column(name = "PROther", columnDefinition = "NVARCHAR(MAX)")
    private String prOther;

    // Scripts
    @Column(name = "ScriptEnglish", columnDefinition = "NVARCHAR(MAX)")
    private String scriptEnglish;

    @Column(name = "ScriptVietNam", columnDefinition = "NVARCHAR(MAX)")
    private String scriptVietNam;

    @Column(name = "ScriptChina", columnDefinition = "NVARCHAR(MAX)")
    private String scriptChina;

    @Column(name = "ScriptJapan", columnDefinition = "NVARCHAR(MAX)")
    private String scriptJapan;

    @Column(name = "ScriptOther", columnDefinition = "NVARCHAR(MAX)")
    private String scriptOther;

    @Column(name = "UserCreated", length = 100)
    private String userCreated;

    @Column(name = "UserUpdated", length = 100)
    private String userUpdated;

    @CreationTimestamp
    @Column(name = "DateCreated", updatable = false)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "DateUpdated")
    private LocalDateTime dateUpdated;
}