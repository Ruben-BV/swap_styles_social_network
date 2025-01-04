package dev.ruben.swap_styles_social_network.clothingItem;

import java.util.List;

public class ClothingItemDTO {
    private Long clothingItemId;
    private Long wardrobeId;
    private ClothingItemType clothingItemType;
    private String clothingItemName;
    private String clothingItemDescription;
    private boolean visibility;
    private List<String> photosList;

    public ClothingItemDTO(ClothingItem clothingItem){
        this.clothingItemId = clothingItem.getClothingItemId();
        this.wardrobeId = clothingItem.getWardrobe().getWardrobeId();
        this.clothingItemType = clothingItem.getClothingItemType();
        this.clothingItemName = clothingItem.getClothingItemName();
        this.clothingItemDescription = clothingItem.getClothingItemDescription();
        this.visibility = clothingItem.isVisibility();
        this.photosList = clothingItem.getPhotosList();
    }
    
    public ClothingItemDTO() {
    }

    public Long getClothingItemId() {
        return clothingItemId;
    }

    public void setClothingItemId(Long clothingItemId) {
        this.clothingItemId = clothingItemId;
    }

    public Long getWardrobeId() {
        return wardrobeId;
    }

    public void setWardrobeId(Long wardrobeId) {
        this.wardrobeId = wardrobeId;
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
}

