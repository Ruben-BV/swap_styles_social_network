package dev.ruben.swap_styles_social_network.clothingItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClothingItemController {

    @Autowired
    ClothingItemService clothingItemService;

    @PostMapping(path = "/clothingItem/create")
    public ResponseEntity<ClothingItemDTO> createClothingItem(@RequestBody ClothingItemDTO clothingItemDTO){
        return new ResponseEntity<>(clothingItemService.createClothingItem(clothingItemDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/admin/clothingItem/getAll")
    public ResponseEntity<List<ClothingItemDTO>> getAllClothingItems() {
        return new ResponseEntity<>(clothingItemService.getAllClothingItems(), HttpStatus.OK);
    }

    @GetMapping(path = "/clothingItem/getClothingItemById/{clothingItemId}")
    public ClothingItemDTO getClothingItemById(@PathVariable Long clothingItemId) {
        return clothingItemService.getClothingItemById(clothingItemId);
    }

    @GetMapping(path = "/clothingItem/getAllClothingItemsByUserId/{userId}")
    public List<ClothingItemDTO> getAllCLothingItemsByUserId(@PathVariable Long userId) {
        return clothingItemService.getAllClothingItemsByUserId(userId);
    }

    @GetMapping(path = "/clothingItem/getVisibleClothingItemsByUserId/{userId}")
    public List<ClothingItemDTO> getVisibleCLothingItemsByUserId(@PathVariable Long userId) {
        return clothingItemService.getVisibleClothingItemsByUserId(userId);
    }

    @PutMapping(path = "/clothingItem/modifyClothingItemById/{clothingItemId}")
    public ClothingItemDTO modifyCLothingItemById(@PathVariable Long clothingItemId, @RequestBody ClothingItemDTO clothingItemDTO) {
        return clothingItemService.modifyClothingItemById(clothingItemId, clothingItemDTO);
    }

    @DeleteMapping(path = "/clothingItem/delete/{clothingItemId}")
    public ResponseEntity<Void> deleteClothingItemById(@PathVariable Long clothingItemId) {
        clothingItemService.deleteClothingItemById(clothingItemId);
        return ResponseEntity.noContent().build();
    }
}
