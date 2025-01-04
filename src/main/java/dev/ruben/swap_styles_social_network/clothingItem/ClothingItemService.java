package dev.ruben.swap_styles_social_network.clothingItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;
import dev.ruben.swap_styles_social_network.wardrobe.WardrobeRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClothingItemService {
    private ClothingItemRepository clothingItemRepository;
    private WardrobeRepository wardrobeRepository;

    public ClothingItemService(ClothingItemRepository clothingItemRepository, WardrobeRepository wardrobeRepository) {
        this.clothingItemRepository = clothingItemRepository;
        this.wardrobeRepository = wardrobeRepository;
    }

    public ClothingItemDTO createClothingItem(ClothingItemDTO clothingItemDTO) {
        if (clothingItemDTO.getClothingItemId() != null && !String.valueOf(clothingItemDTO.getClothingItemId()).isEmpty()) {
            throw new IllegalArgumentException("Id cannot be auto assigned.");
        }
        
        Wardrobe wardrobe = wardrobeRepository.findById(clothingItemDTO.getWardrobeId()).orElse(null);
        ClothingItem clothingItem = new ClothingItem(clothingItemDTO.getClothingItemId(), wardrobe, clothingItemDTO.getClothingItemType(), clothingItemDTO.getClothingItemName(), clothingItemDTO.getClothingItemDescription(), clothingItemDTO.isVisibility(), clothingItemDTO.getPhotosList());
            return new ClothingItemDTO(clothingItemRepository.save(clothingItem));
    }

    public List<ClothingItemDTO> getAllClothingItems(){
        return clothingItemRepository.findAll().stream().map(x -> new ClothingItemDTO(x)).toList();
    }
    
    public ClothingItemDTO getClothingItemById(Long clothingItemId) {
        return clothingItemRepository.findById(clothingItemId).map(ClothingItemDTO::new).orElse(null);
    }

    public List<ClothingItemDTO> getAllClothingItemsByUserId(Long userId) {
        List<ClothingItem> clothingItems = clothingItemRepository.findAll();
        List<ClothingItemDTO> result = new ArrayList<>();

        for (ClothingItem clothingItem : clothingItems) {
            if (clothingItem.getWardrobe().getUser().getUserId() == userId){
                result.add(clothingItem.toDTO());
            }
        }
        return result;
    }

    public List<ClothingItemDTO> getVisibleClothingItemsByUserId(Long userId) {
        List<ClothingItem> clothingItems = clothingItemRepository.findAll();
        List<ClothingItemDTO> result = new ArrayList<>();

        for (ClothingItem clothingItem : clothingItems) {
            if (clothingItem.getWardrobe().getUser().getUserId() == userId && clothingItem.isVisibility()==true){
                result.add(clothingItem.toDTO());
            }
        }
        return result;
    }

    public ClothingItemDTO modifyClothingItemById(Long clothingItemId, ClothingItemDTO clothingItemDTO) {
        ClothingItem existingClothingItem = clothingItemRepository.findById(clothingItemId).orElse(null);
        if (existingClothingItem != null) {
            existingClothingItem.setClothingItemType(clothingItemDTO.getClothingItemType());
            existingClothingItem.setClothingItemName(clothingItemDTO.getClothingItemName());
            existingClothingItem.setClothingItemDescription(clothingItemDTO.getClothingItemDescription());
            existingClothingItem.setVisibility(clothingItemDTO.isVisibility());
            existingClothingItem.setPhotosList(clothingItemDTO.getPhotosList());
            return new ClothingItemDTO(clothingItemRepository.save(existingClothingItem));
        } else {
            throw new EntityNotFoundException("Clothing Item not found with ID: " + clothingItemId);
        }
    }

    public void deleteClothingItemById(Long clothingItemId){
        ClothingItem clothingItem = clothingItemRepository.findById(clothingItemId).orElse(null);
        if(clothingItem!=null){
            clothingItemRepository.deleteById(clothingItemId);
        }else{
            throw new RuntimeException("Clothing Item not found with clothingItemId: " + clothingItemId + ". Status: " + HttpStatus.NOT_FOUND);
        }
    }
}
