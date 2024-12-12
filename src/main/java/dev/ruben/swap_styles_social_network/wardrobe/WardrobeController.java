package dev.ruben.swap_styles_social_network.wardrobe;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class WardrobeController {
    
    @Autowired
    WardrobeService wardrobeService;

    @PostMapping(path = "/wardrobe/create")
    public ResponseEntity<WardrobeDTO> createWardrobe(@RequestBody WardrobeDTO wardrobeDTO){
        return new ResponseEntity<>(wardrobeService.createWardrobe(wardrobeDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/admin/wardrobe/getAll")
    public ResponseEntity<List<WardrobeDTO>> getAllWardrobes() {
        return new ResponseEntity<>(wardrobeService.getAllWardrobes(), HttpStatus.OK);
    }

    @GetMapping(path = "/wardrobe/getAllFromUser/{userId}")
    public List<WardrobeDTO> getWardorbesByUserId(@PathVariable Long userId) {
        return wardrobeService.getWardrobesByUserId(userId);
    }
    
    @GetMapping(path = "/wardrobe/getById/{wardrobeId}")
    public ResponseEntity<Optional<WardrobeDTO>> getWardorbeById(@PathVariable Long wardrobeId) {
        return new ResponseEntity<>(wardrobeService.getWardrobeById(wardrobeId), HttpStatus.OK);
    }

    @PutMapping(path = "/wardrobe/updateById/{wardrobeId}")
    public ResponseEntity<WardrobeDTO> updateUserById(@PathVariable Long wardrobeId, @RequestBody WardrobeDTO updatedWardrobe) {
    
        Optional<WardrobeDTO> existingWardrobe = wardrobeService.getWardrobeById(wardrobeId);

        if (existingWardrobe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(wardrobeService.modifyWardrobeById(wardrobeId, updatedWardrobe));
    }

    @DeleteMapping(path = "/wardrobe/delete/{wardrobeId}")
    public ResponseEntity<Void> deleteWardrobeById(@PathVariable Long wardrobeId) {
        wardrobeService.deleteWardrobeById(wardrobeId);
        return ResponseEntity.noContent().build();
    }
}
