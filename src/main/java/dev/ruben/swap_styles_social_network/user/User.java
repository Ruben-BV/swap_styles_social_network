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
    private String name;
    @Column(nullable = false)
    private String emailAddress;
    @Column(nullable = false)
    private String profilImage;

    @OneToMany
    (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wardrobe> wardrobes;
    
    
    public User(Long userId, String userType, String name, String emailAddress, String profilImage) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.emailAddress = emailAddress;
        this.profilImage = profilImage;
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


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmailAddress() {
        return emailAddress;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getProfilImage() {
        return profilImage;
    }


    public void setProfilImage(String profilImage) {
        this.profilImage = profilImage;
    }

    
}
