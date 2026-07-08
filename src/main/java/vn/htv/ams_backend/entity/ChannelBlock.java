package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChannelBlock")
public class ChannelBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChannelBlockID")
    private Integer channelBlockId;

    @Column(name = "BlockID") private Integer blockId;
    @Column(name = "ChannelID") private Integer channelId;

    @Column(name = "CreatorID") private Integer creatorId;
    @Column(name = "DateCreated") private LocalDateTime dateCreated;
    @Column(name = "UserUpdated") private String userUpdated;
    @Column(name = "DateUpdated") private LocalDateTime dateUpdated;

    // Getters & Setters
    public Integer getChannelBlockId() { return channelBlockId; }
    public void setChannelBlockId(Integer channelBlockId) { this.channelBlockId = channelBlockId; }
    public Integer getBlockId() { return blockId; }
    public void setBlockId(Integer blockId) { this.blockId = blockId; }
    public Integer getChannelId() { return channelId; }
    public void setChannelId(Integer channelId) { this.channelId = channelId; }
    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }
    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
    public String getUserUpdated() { return userUpdated; }
    public void setUserUpdated(String userUpdated) { this.userUpdated = userUpdated; }
    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }
}