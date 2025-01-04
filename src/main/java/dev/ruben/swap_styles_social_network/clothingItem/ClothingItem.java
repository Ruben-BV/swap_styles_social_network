package dev.ruben.swap_styles_social_network.clothingItem;

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
@Table(name = "clothingItems")
public class ClothingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clothingItemId;
    @Column(nullable = false)
    private ClothingItemType clothingItemType;
    
    @Column(nullable = false)
    private String clothingItemName;
    @Column(nullable = false)
    private String clothingItemDescription;
    @Column(nullable = false)
    private boolean visibility;
    @Column(nullable = false)
    private List<String> photosList;


    
    @ManyToOne (cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "wardrobe_id")
    private Wardrobe wardrobe;
    



    public ClothingItem(Long clothingItemId, Wardrobe wardrobe, ClothingItemType clothingItemType, String clothingItemName, String clothingItemDescription,
            boolean visibility, List<String> photosList) {
        this.clothingItemId = clothingItemId;
        this.wardrobe = wardrobe;
        this.clothingItemType = clothingItemType;
        this.clothingItemName = clothingItemName;
        this.clothingItemDescription = clothingItemDescription;
        this.visibility = visibility;
        this.photosList = photosList;
    }

    public ClothingItem() {
    }

    public ClothingItemDTO toDTO() {
        return new ClothingItemDTO(this);
    }

    public Long getClothingItemId() {
        return clothingItemId;
    }


    public void setClothingItemId(Long clothingItemId) {
        this.clothingItemId = clothingItemId;
    }


    public ClothingItemType getClothingItemType() {
        return clothingItemType;
    }


    public void setClothingItemType(ClothingItemType clothingItemType) {
        this.clothingItemType = clothingItemType;
    }


    public String getClothingItemName() {
        return clothingItemName;
    }


    public void setClothingItemName(String clothingItemName) {
        this.clothingItemName = clothingItemName;
    }


    public String getClothingItemDescription() {
        return clothingItemDescription;
    }


    public void setClothingItemDescription(String clothingItemDescription) {
        this.clothingItemDescription = clothingItemDescription;
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

enum ClothingItemType {
    ACCESSORIES (0),
    FOOTWEAR (1),
    COAT (2),
    JACKET (3),
    SWEATER (4),
    T_SHIRT (5),
    SKIRT (6),
    PANTS (7),
    DRESS (8),
    COSTUME (9);
    private int value;

    ClothingItemType(int value) {
        this.value = value;
    }

    
}
