package vn.htv.ams_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UserChannel")
public class UserChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserChanelID")
    private Integer userChannelId;

    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "ChannelID")
    private Integer channelId;

    @Column(name = "UserCreated")
    private Integer userCreated;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "UserUpdated")
    private Integer userUpdated;

    @Column(name = "DateUpdated")
    private LocalDateTime dateUpdated;

    // --- GETTER AND SETTER ---
    public Integer getUserChannelId() { return userChannelId; }
    public void setUserChannelId(Integer userChannelId) { this.userChannelId = userChannelId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getChannelId() { return channelId; }
    public void setChannelId(Integer channelId) { this.channelId = channelId; }

    public Integer getUserCreated() { return userCreated; }
    public void setUserCreated(Integer userCreated) { this.userCreated = userCreated; }

    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }

    public Integer getUserUpdated() { return userUpdated; }
    public void setUserUpdated(Integer userUpdated) { this.userUpdated = userUpdated; }

    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }
}