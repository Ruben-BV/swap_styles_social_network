package dev.ruben.swap_styles_social_network.friendship;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;
import dev.ruben.swap_styles_social_network.wardrobe.WardrobeController;
import dev.ruben.swap_styles_social_network.wardrobe.WardrobeDTO;
import dev.ruben.swap_styles_social_network.wardrobe.WardrobeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;

public class FriendshipControllerTest {
    private MockMvc mockMvc;

    @Mock
    private FriendshipService friendshipService;
    
    @InjectMocks
    private FriendshipController friendshipController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(friendshipController).build();
    }
    @Test
    public void testCreateFriendshipRequest() throws Exception {
        Friendship friendship = new Friendship();
        
        FriendshipDTO savedFriendshipDTO = new FriendshipDTO();

        when(friendshipService.createFriendshipRequest(any(FriendshipDTO.class))).thenReturn(savedFriendshipDTO);
        mockMvc.perform(post("/user/friendship/request")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(friendship)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllFriendships() throws Exception {
        
        FriendshipDTO friendship1 = new FriendshipDTO();
        friendship1.setFriendshipId(1L);
        friendship1.setFriendshipStatus(FriendshipStatus.ACCEPTED);

        FriendshipDTO friendship2 = new FriendshipDTO();
        friendship2.setFriendshipId(2L);
        friendship2.setFriendshipStatus(FriendshipStatus.ACCEPTED);

        List<FriendshipDTO> friendships = Arrays.asList(friendship1, friendship2);

        when(friendshipService.getAllFriendships()).thenReturn(friendships);

        mockMvc.perform(get("/admin/friendship/getAllFriendships"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].friendshipId").value(1L))
                .andExpect(jsonPath("$[1].friendshipId").value(2L));
    }

    @Test
    void testGetFriendshipById() throws Exception {
        
        Long friendshipId = 1L;
        User user1 = new User(2L, "USER", "Test User1", "testuser1@email.com", "Profile Image1");
        User user2 = new User(3L, "USER", "Test User2", "testuser2@email.com", "Profile Image2");
    
        FriendshipDTO friendshipDTO = new FriendshipDTO();
        friendshipDTO.setFriendshipId(friendshipId);
        friendshipDTO.setUser1Id(user1.getUserId());
        friendshipDTO.setUser2Id(user2.getUserId());
        friendshipDTO.setFriendshipStatus(FriendshipStatus.ACCEPTED);
        
        Optional<FriendshipDTO> friendshipOptional = Optional.of(friendshipDTO);

        when(friendshipService.getFriendshipById(friendshipId)).thenReturn(friendshipOptional);

        mockMvc.perform(get("/admin/friendship/getFriendshipById/{friendshipId}", friendshipId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.friendshipId").value(friendshipId))
                .andExpect(jsonPath("$.user1Id").value(user1.getUserId()))
                .andExpect(jsonPath("$.user2Id").value(user2.getUserId()));
    }

    @Test
    void testGetFriendshipByUserId() throws Exception {
        
        Long friendshipId = 1L;
        User user1 = new User(2L, "USER", "Test User1", "testuser1@email.com", "Profile Image1");
        User user2 = new User(3L, "USER", "Test User2", "testuser2@email.com", "Profile Image2");
    
        FriendshipDTO friendshipDTO = new FriendshipDTO();
        friendshipDTO.setFriendshipId(friendshipId);
        friendshipDTO.setUser1Id(user1.getUserId());
        friendshipDTO.setUser2Id(user2.getUserId());
        friendshipDTO.setFriendshipStatus(FriendshipStatus.ACCEPTED);

        List<FriendshipDTO> friendships = new ArrayList<>();
        friendships.add(friendshipDTO);

        when(friendshipService.getFriendshipsByUserId(2L)).thenReturn(friendships);

        mockMvc.perform(get("/user/wardrobe/getFriendshipsByUserId/{userId}", user1.getUserId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                
    }

    @Test
    public void testDeleteFriendshipById() throws Exception {
        doNothing().when(friendshipService).deleteFriendshipById(anyLong());
        mockMvc.perform(delete("/user/friendship/delete/{friendshipId}", 1L))
                .andExpect(status().isNoContent());

    }
}
