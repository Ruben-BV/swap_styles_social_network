package dev.ruben.swap_styles_social_network.friendship;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.user.UserRepository;

@ExtendWith(MockitoExtension.class)
public class FriendshipServiceTest {
    @Mock
    private FriendshipRepository friendshipRepository;
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    FriendshipService friendshipService;
    @Mock
    private Friendship mockFriendship;
    private FriendshipDTO friendshipDTO;
    private User user1;
    private User user2;
    
    @BeforeEach
    void setUp() {
        user1 = new User(2L, "USER", "Test User1", "testuser1@email.com", "Profile Image1");
        user2 = new User(3L, "USER", "Test User2", "testuser2@email.com", "Profile Image2");
        mockFriendship = new Friendship(1L, user1, user2, FriendshipStatus.ACCEPTED);
        friendshipDTO = new FriendshipDTO();
            friendshipDTO.setFriendshipId(2L);
            friendshipDTO.setUser1Id(1L);
            friendshipDTO.setUser2Id(2L);
            friendshipDTO.setFriendshipStatus(FriendshipStatus.ACCEPTED);
    }

    @Test
    public void testGetAllFriendships() {
        
        List<Friendship> mockFriendships = new ArrayList<>();
        mockFriendships.add(mockFriendship);
        
        when(friendshipRepository.findAll()).thenReturn(mockFriendships);
        
        List<FriendshipDTO> result = friendshipService.getAllFriendships();
        
        assertEquals(1, result.size());
    }

    @Test
    void testDeleteFriendshipById_Success() {
        when(friendshipRepository.findById(1L)).thenReturn(Optional.of(mockFriendship));

        friendshipService.deleteFriendshipById(1L);

        verify(friendshipRepository, times(1)).deleteById(1L);
    }
}
