package dev.ruben.swap_styles_social_network.wardrobe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class WardrobeService {
    private WardrobeRepository wardrobeRepository;
    private UserRepository userRepository;

    public WardrobeService(WardrobeRepository wardrobeRepository, UserRepository userRepository) {
        this.wardrobeRepository = wardrobeRepository;
        this.userRepository = userRepository;
    }

    public WardrobeDTO createWardrobe(WardrobeDTO wardrobeDTO){
        User user = userRepository.findById(wardrobeDTO.getUserId()).orElse(null);
        if(user!=null){
            Wardrobe wardrobe = new Wardrobe(wardrobeDTO.getWardrobeId(), user, wardrobeDTO.getWardrobeName(), wardrobeDTO.getWearables());
            return new WardrobeDTO(wardrobeRepository.save(wardrobe));
        }else{
            throw new RuntimeException("User not found with wardrobeId: " + wardrobeDTO.getUserId() + ". Status: " + HttpStatus.NOT_FOUND);
        }
                
    }

    public List<WardrobeDTO> getAllWardrobes(){
        return wardrobeRepository.findAll().stream().map(x -> new WardrobeDTO(x)).toList();
    }

    public List<WardrobeDTO> getWardrobesByUserId(Long userId){
        List<WardrobeDTO> wardrobes = getAllWardrobes();
        List<WardrobeDTO> result = new ArrayList<>();

        for (WardrobeDTO wardrobeDTO : wardrobes) {
            if (wardrobeDTO.getUserId() == userId){
                result.add(wardrobeDTO);
            }
        }
        return result;
    }

    public Optional<WardrobeDTO> getWardrobeById(Long wardrobeId){
        return wardrobeRepository.findById(wardrobeId).map(x -> new WardrobeDTO(x));
    }

    public WardrobeDTO modifyWardrobeById(Long wardrobeId, WardrobeDTO wardrobeDTO) {
        Wardrobe existingWardrobe = wardrobeRepository.findById(wardrobeId).orElse(null);
        if (existingWardrobe != null) {
            existingWardrobe.setWardrobeName(wardrobeDTO.getWardrobeName());
            return new WardrobeDTO(wardrobeRepository.save(existingWardrobe));
        } else {
            throw new EntityNotFoundException("Wardrobe not found with ID: " + wardrobeId);
        }
    }

    public void deleteWardrobeById(Long wardrobeId){
        Wardrobe device = wardrobeRepository.findById(wardrobeId).orElse(null);
        if(device!=null){
            wardrobeRepository.deleteById(wardrobeId);
        }else{
            throw new RuntimeException("Wardrobe not found with wardrobeId: " + wardrobeId + ". Status: " + HttpStatus.NOT_FOUND);
        }
    }
}