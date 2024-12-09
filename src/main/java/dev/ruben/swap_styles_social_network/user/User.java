package dev.ruben.swap_styles_social_network.user;


import java.util.List;

import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String userType;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String emailAddress;
    @Column(nullable = false)
    private String profileImage;

    @OneToMany
    (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wardrobe> wardrobes;
    
    
    public User(Long userId, String userType, String userName, String emailAddress, String profileImage) {
        this.userId = userId;
        this.userType = userType;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.profileImage = profileImage;
    }


    public User() {
    }


    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getUserType() {
        return userType;
    }


    public void setUserType(String userType) {
        this.userType = userType;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmailAddress() {
        return emailAddress;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getProfileImage() {
        return profileImage;
    }


    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    
}
