package dev.ruben.swap_styles_social_network.wearable;

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
public class WearableController {

    @Autowired
    WearableService wearableService;

    @PostMapping(path = "user/wearable/create")
    public ResponseEntity<WearableDTO> createWearable(@RequestBody WearableDTO wearableDTO){
        return new ResponseEntity<>(wearableService.createWearable(wearableDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "admin/wearable/getAll")
    public ResponseEntity<List<WearableDTO>> getAllWeartables() {
        return new ResponseEntity<>(wearableService.getAllWearables(), HttpStatus.OK);
    }

    @GetMapping(path = "user/wearable/getWearableById/{wearableId}")
    public WearableDTO getWearableById(@PathVariable Long wearableId) {
        return wearableService.getWearableById(wearableId);
    }

    @GetMapping(path = "user/wearable/getAllWearablesByUserId/{userId}")
    public List<WearableDTO> getAllWearablesByUserId(@PathVariable Long userId) {
        return wearableService.getAllWearablesByUserId(userId);
    }

    @GetMapping(path = "user/wearable/getVisibleWearablesByUserId/{userId}")
    public List<WearableDTO> getVisibleWearablesByUserId(@PathVariable Long userId) {
        return wearableService.getVisibleWearablesByUserId(userId);
    }

    @PutMapping(path = "user/wearable/modifyWearableById/{wearableId}")
    public WearableDTO modifyWearableById(@PathVariable Long wearableId, @RequestBody WearableDTO wearableDTO) {
        return wearableService.modifyWearableById(wearableId, wearableDTO);
    }

    @DeleteMapping(path = "/user/wearable/delete/{wearableId}")
    public ResponseEntity<Void> deleteWearableById(@PathVariable Long wearableId) {
        wearableService.deleteWearableById(wearableId);
        return ResponseEntity.noContent().build();
    }
}
