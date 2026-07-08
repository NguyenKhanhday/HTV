package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EpisodeNotAirs")
public class EpisodeNotAir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EpisodeID")
    private Integer episodeId;

    @Column(name = "BlockNameID") private Integer blockNameId;
    @Column(name = "ContentID") private Integer contentId;

    @Column(name = "DateNoteAir") private LocalDateTime dateNoteAir;
    @Column(name = "Episode") private String episode; // Dùng String để lỡ gõ "Tập 5-6"

    @Column(name = "TypesAir") private Integer typesAir = 0; // 0: Không phát, 1: Phát lại

    @Column(name = "UserCreated") private String userCreated;
    @Column(name = "UserUpdated") private String userUpdated;
    @Column(name = "DateCreated") private LocalDateTime dateCreated;
    @Column(name = "DateUpdated") private LocalDateTime dateUpdated;

    // --- GETTERS & SETTERS ---
    public Integer getEpisodeId() { return episodeId; }
    public void setEpisodeId(Integer episodeId) { this.episodeId = episodeId; }
    public Integer getBlockNameId() { return blockNameId; }
    public void setBlockNameId(Integer blockNameId) { this.blockNameId = blockNameId; }
    public Integer getContentId() { return contentId; }
    public void setContentId(Integer contentId) { this.contentId = contentId; }
    public LocalDateTime getDateNoteAir() { return dateNoteAir; }
    public void setDateNoteAir(LocalDateTime dateNoteAir) { this.dateNoteAir = dateNoteAir; }
    public String getEpisode() { return episode; }
    public void setEpisode(String episode) { this.episode = episode; }
    public Integer getTypesAir() { return typesAir; }
    public void setTypesAir(Integer typesAir) { this.typesAir = typesAir; }
    public String getUserCreated() { return userCreated; }
    public void setUserCreated(String userCreated) { this.userCreated = userCreated; }
    public String getUserUpdated() { return userUpdated; }
    public void setUserUpdated(String userUpdated) { this.userUpdated = userUpdated; }
    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }
}