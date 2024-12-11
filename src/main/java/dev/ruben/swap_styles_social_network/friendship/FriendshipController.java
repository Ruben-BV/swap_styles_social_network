package dev.ruben.swap_styles_social_network.friendship;

import java.util.List;
import java.util.Optional;

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
public class FriendshipController {
    @Autowired
    FriendshipService friendshipService;

    @PostMapping(path = "user/friendship/request")
    public ResponseEntity<FriendshipDTO> createFriendshipRequest(@RequestBody FriendshipDTO friendshipDTO){
        return new ResponseEntity<>(friendshipService.createFriendshipRequest(friendshipDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "user/friendship/acceptFriendshipRequest/{friendshipId}")
    public ResponseEntity<FriendshipDTO> acceptFriendshipRequest(@PathVariable Long friendshipId){
        return ResponseEntity.ok(friendshipService.acceptFriendshipRequest(friendshipId));
    }

    @PutMapping(path = "user/friendship/rejectFriendshipRequest/{friendshipId}")
    public ResponseEntity<FriendshipDTO> rejectFriendshipRequest(@PathVariable Long friendshipId){
        return ResponseEntity.ok(friendshipService.rejectFriendshipRequest(friendshipId));
    }

    @GetMapping(path = "admin/friendship/getAllFriendships")
    public ResponseEntity<List<FriendshipDTO>> getAllFriendships() {
        return new ResponseEntity<>(friendshipService.getAllFriendships(), HttpStatus.OK);
    }

    @GetMapping(path = "admin/friendship/getFriendshipById/{friendshipId}")
    public Optional<FriendshipDTO> getFriendshipById(@PathVariable Long friendshipId) {
        return friendshipService.getFriendshipById(friendshipId);
    }

    @GetMapping(path = "user/wardrobe/getFriendshipsByUserId/{userId}")
    public List<FriendshipDTO> getWardorbesByUserId(@PathVariable Long userId) {
        return friendshipService.getFriendshipsByUserId(userId);
    }

    @DeleteMapping(path = "/user/friendship/delete/{friendshipId}")
    public ResponseEntity<Void> deleteFriendshipById(@PathVariable Long friendshipId) {
        friendshipService.deleteFriendshipById(friendshipId);
        return ResponseEntity.noContent().build();
    }
}
