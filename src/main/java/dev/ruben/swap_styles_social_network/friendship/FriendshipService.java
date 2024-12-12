package dev.ruben.swap_styles_social_network.friendship;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FriendshipService {
    private FriendshipRepository friendshipRepository;
    private UserRepository userRepository;

    public FriendshipService(FriendshipRepository friendshipRepository, UserRepository userRepository) {
        this.friendshipRepository = friendshipRepository;
        this.userRepository = userRepository;
    }

    public FriendshipDTO createFriendshipRequest(FriendshipDTO friendshipDTO){
        User user1 = userRepository.findById(friendshipDTO.getUser1Id()).orElse(null);
        User user2 = userRepository.findById(friendshipDTO.getUser2Id()).orElse(null);
        
        List<Friendship> friendships = friendshipRepository.findAll();

        for (Friendship testFriendship : friendships) {
            if (
                ((testFriendship.getUser1().getUserId() == friendshipDTO.getUser1Id())||(testFriendship.getUser1().getUserId() == friendshipDTO.getUser2Id()))
                &&
                ((testFriendship.getUser2().getUserId() == friendshipDTO.getUser1Id())||(testFriendship.getUser2().getUserId() == friendshipDTO.getUser2Id()))) {
                throw new IllegalArgumentException("Friendship already exists.");
            }
        }
        
        FriendshipStatus friendshipStatus = FriendshipStatus.PENDING;
        if(friendshipDTO.getFriendshipStatus()!= friendshipStatus) {
            throw new IllegalArgumentException("To create a new friendship request, the friendship status must be PENDING.");
        }
        
        Friendship friendship = new Friendship(friendshipDTO.getFriendshipId(), user1, user2,friendshipDTO.getFriendshipStatus());
        return new FriendshipDTO(friendshipRepository.save(friendship));
    }

    public FriendshipDTO acceptFriendshipRequest(Long friendshipId) {
        Friendship existingFriendship = friendshipRepository.findById(friendshipId).orElse(null);
        if (existingFriendship != null) {
            existingFriendship.setFriendshipStatus(FriendshipStatus.ACCEPTED);
            return new FriendshipDTO(friendshipRepository.save(existingFriendship));
        } else {
            throw new EntityNotFoundException("Friendship not found with ID: " + friendshipId);
        }
    }

    public FriendshipDTO rejectFriendshipRequest(Long friendshipId) {
        Friendship existingFriendship = friendshipRepository.findById(friendshipId).orElse(null);
        if (existingFriendship != null) {
            existingFriendship.setFriendshipStatus(FriendshipStatus.REJECTED);
            return new FriendshipDTO(friendshipRepository.save(existingFriendship));
        } else {
            throw new EntityNotFoundException("Friendship not found with ID: " + friendshipId);
        }
    }

    public List<FriendshipDTO> getAllFriendships(){
        return friendshipRepository.findAll().stream().map(x -> new FriendshipDTO(x)).toList();
    }

    public Optional<FriendshipDTO> getFriendshipById(Long friendshipId){
        return friendshipRepository.findById(friendshipId).map(x -> new FriendshipDTO(x));
    }

    public List<FriendshipDTO> getFriendshipsByUserId(Long userId){
        List<FriendshipDTO> friendships = getAllFriendships();
        List<FriendshipDTO> result = new ArrayList<>();

        for (FriendshipDTO friendshipDTO : friendships) {
            if ((friendshipDTO.getUser1Id() == userId) || (friendshipDTO.getUser2Id()==userId)){
                result.add(friendshipDTO);
            }
        }
        return result;
    }

    public void deleteFriendshipById(Long friendshipId){
        Friendship friendship = friendshipRepository.findById(friendshipId).orElse(null);
        if(friendship!=null){
            friendshipRepository.deleteById(friendshipId);
        }else{
            throw new RuntimeException("Friendship not found with friendshipId: " + friendshipId + ". Status: " + HttpStatus.NOT_FOUND);
        }
    }
}
