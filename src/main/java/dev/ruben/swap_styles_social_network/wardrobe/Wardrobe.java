package dev.ruben.swap_styles_social_network.wardrobe;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.wearable.Wearable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

class Views {
    public static class Summary {}
    public static class Detailed extends Summary {}
}

@Entity
@Table(name = "wardrobes")
public class Wardrobe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wardrobeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String wardrobeName;
    

    @OneToMany
    (mappedBy = "wardrobe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Wearable> wearables;

    public Wardrobe(Long wardrobeId, User user, String wardrobeName, List<Wearable> wearables) {
        this.wardrobeId = wardrobeId;
        this.user = user;
        this.wardrobeName = wardrobeName;
        this.wearables = wearables;
    }

    public Wardrobe() {
    }

    public Long getWardrobeId() {
        return wardrobeId;
    }

    public void setWardrobeId(Long wardrobeId) {
        this.wardrobeId = wardrobeId;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getWardrobeName() {
        return wardrobeName;
    }

    public void setWardrobeName(String wardrobeName) {
        this.wardrobeName = wardrobeName;
    }


    public List<Wearable> getWearables() {
        return wearables;
    }

    public void setWearables(List<Wearable> wearables) {
        this.wearables = wearables;
    }

    
}