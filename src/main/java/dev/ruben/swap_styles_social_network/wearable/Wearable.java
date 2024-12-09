package dev.ruben.swap_styles_social_network.wearable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "wearables")
public class Wearable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wearableId;
    @Column(nullable = false)
    private WearableType wearableType;
    
    @Column(nullable = false)
    private String wearableName;
    @Column(nullable = false)
    private String wearableDescription;
    @Column(nullable = false)
    private boolean visibility;
    @Column(nullable = false)
    private List<String> photosList;


    
    @ManyToOne (cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "wardrobe_id")
    private Wardrobe wardrobe;
    



    public Wearable(Long wearableId, Wardrobe wardrobe, WearableType wearableType, String wearableName, String wearableDescription,
            boolean visibility, List<String> photosList) {
        this.wearableId = wearableId;
        this.wardrobe = wardrobe;
        this.wearableType = wearableType;
        this.wearableName = wearableName;
        this.wearableDescription = wearableDescription;
        this.visibility = visibility;
        this.photosList = photosList;
    }

    public Wearable() {
    }

    public WearableDTO toDTO() {
        return new WearableDTO(this);
    }

    public Long getWearableId() {
        return wearableId;
    }


    public void setWearableId(Long wearableId) {
        this.wearableId = wearableId;
    }


    public WearableType getWearableType() {
        return wearableType;
    }


    public void setWearableType(WearableType wearableType) {
        this.wearableType = wearableType;
    }


    public String getWearableName() {
        return wearableName;
    }


    public void setWearableName(String wearableName) {
        this.wearableName = wearableName;
    }


    public String getWearableDescription() {
        return wearableDescription;
    }


    public void setWearableDescription(String wearableDescription) {
        this.wearableDescription = wearableDescription;
    }


    public boolean isVisibility() {
        return visibility;
    }


    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }


    public List<String> getPhotosList() {
        return photosList;
    }


    public void setPhotosList(List<String> photosList) {
        this.photosList = photosList;
    }


    public Wardrobe getWardrobe() {
        return wardrobe;
    }


    public void setWardrobe(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    
}

enum WearableType {
    ACCESSORIES,
    FOOTWEAR,
    COAT,
    JACKET,
    SWEATER,
    T_SHIRT,
    SKIRT,
    PANTS,
    DRESS,
    COSTUME;
}
