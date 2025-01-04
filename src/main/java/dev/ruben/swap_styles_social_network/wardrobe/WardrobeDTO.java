package dev.ruben.swap_styles_social_network.wardrobe;

import java.util.List;

import dev.ruben.swap_styles_social_network.clothingItem.ClothingItem;

public class WardrobeDTO {
    private Long wardrobeId;
    private Long userId;
    private String wardrobeName;
    private List<ClothingItem> clothingItems;

    public WardrobeDTO(Wardrobe wardrobe){
        this.wardrobeId = wardrobe.getWardrobeId();
        this.userId = wardrobe.getUser().getUserId();
        this.wardrobeName = wardrobe.getWardrobeName();
        this.clothingItems = wardrobe.getClothingItems();
    }
    
    public WardrobeDTO() {
    }

    public Long getWardrobeId() {
        return wardrobeId;
    }

    public void setWardrobeId(Long wardrobeId) {
        this.wardrobeId = wardrobeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWardrobeName() {
        return wardrobeName;
    }

    public void setWardrobeName(String wardrobeName) {
        this.wardrobeName = wardrobeName;
    }

    public List<ClothingItem> getClothingItems() {
        return clothingItems;
    }

    public void setClothingItems(List<ClothingItem> clothingItems) {
        this.clothingItems = clothingItems;
    }
}
