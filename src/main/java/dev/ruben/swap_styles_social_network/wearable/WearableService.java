package dev.ruben.swap_styles_social_network.wearable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;
import dev.ruben.swap_styles_social_network.wardrobe.WardrobeRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class WearableService {
    private WearableRepository wearableRepository;
    private WardrobeRepository wardrobeRepository;

    public WearableService(WearableRepository wearableRepository, WardrobeRepository wardrobeRepository) {
        this.wearableRepository = wearableRepository;
        this.wardrobeRepository = wardrobeRepository;
    }

    public WearableDTO createWearable(WearableDTO wearableDTO) {
        if (wearableDTO.getWearableId() != null && !String.valueOf(wearableDTO.getWearableId()).isEmpty()) {
            throw new IllegalArgumentException("Id cannot be auto assigned.");
        }
        
        Wardrobe wardrobe = wardrobeRepository.findById(wearableDTO.getWardrobeId()).orElse(null);
        Wearable wearable = new Wearable(wearableDTO.getWearableId(), wardrobe, wearableDTO.getWearableType(), wearableDTO.getWearableName(), wearableDTO.getWearableDescription(), wearableDTO.isVisibility(), wearableDTO.getPhotosList());
            return new WearableDTO(wearableRepository.save(wearable));
    }

    public List<WearableDTO> getAllWearables(){
        return wearableRepository.findAll().stream().map(x -> new WearableDTO(x)).toList();
    }
    
    public WearableDTO getWearableById(Long wearableId) {
        return wearableRepository.findById(wearableId).map(WearableDTO::new).orElse(null);
    }

    public List<WearableDTO> getAllWearablesByUserId(Long userId) {
        List<Wearable> wearables = wearableRepository.findAll();
        List<WearableDTO> result = new ArrayList<>();

        for (Wearable wearable : wearables) {
            if (wearable.getWardrobe().getUser().getUserId() == userId){
                result.add(wearable.toDTO());
            }
        }
        return result;
    }

    public List<WearableDTO> getVisibleWearablesByUserId(Long userId) {
        List<Wearable> wearables = wearableRepository.findAll();
        List<WearableDTO> result = new ArrayList<>();

        for (Wearable wearable : wearables) {
            if (wearable.getWardrobe().getUser().getUserId() == userId && wearable.isVisibility()==true){
                result.add(wearable.toDTO());
            }
        }
        return result;
    }

    public WearableDTO modifyWearableById(Long wearableId, WearableDTO wearableDTO) {
        Wearable existingWearable = wearableRepository.findById(wearableId).orElse(null);
        if (existingWearable != null) {
            existingWearable.setWearableType(wearableDTO.getWearableType());
            existingWearable.setWearableName(wearableDTO.getWearableName());
            existingWearable.setWearableDescription(wearableDTO.getWearableDescription());
            existingWearable.setVisibility(wearableDTO.isVisibility());
            existingWearable.setPhotosList(wearableDTO.getPhotosList());
            return new WearableDTO(wearableRepository.save(existingWearable));
        } else {
            throw new EntityNotFoundException("Wearable not found with ID: " + wearableId);
        }
    }

    public void deleteWearableById(Long wearableId){
        Wearable wearable = wearableRepository.findById(wearableId).orElse(null);
        if(wearable!=null){
            wearableRepository.deleteById(wearableId);
        }else{
            throw new RuntimeException("Wearable not found with wearableId: " + wearableId + ". Status: " + HttpStatus.NOT_FOUND);
        }
    }
}
