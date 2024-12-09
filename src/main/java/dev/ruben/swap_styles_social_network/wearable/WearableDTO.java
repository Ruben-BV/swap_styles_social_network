package dev.ruben.swap_styles_social_network.wearable;

import java.util.List;

public class WearableDTO {
    private Long wearableId;
    private Long wardrobeId;
    private WearableType wearableType;
    private String wearableName;
    private String wearableDescription;
    private boolean visibility;
    private List<String> photosList;

    public WearableDTO(Wearable wearable){
        this.wearableId = wearable.getWearableId();
        this.wardrobeId = wearable.getWardrobe().getWardrobeId();
        this.wearableType = wearable.getWearableType();
        this.wearableName = wearable.getWearableName();
        this.wearableDescription = wearable.getWearableDescription();
        this.visibility = wearable.isVisibility();
        this.photosList = wearable.getPhotosList();
    }
    
    public WearableDTO() {
    }

    public Long getWearableId() {
        return wearableId;
    }

    public void setWearableId(Long wearableId) {
        this.wearableId = wearableId;
    }

    public Long getWardrobeId() {
        return wardrobeId;
    }

    public void setWardrobeId(Long wardrobeId) {
        this.wardrobeId = wardrobeId;
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
}

