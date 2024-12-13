package dev.ruben.swap_styles_social_network.wardrobe;

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
import dev.ruben.swap_styles_social_network.wearable.Wearable;

@ExtendWith(MockitoExtension.class)
public class WardrobeServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private WardrobeRepository wardrobeRepository;
    
    @InjectMocks
    WardrobeService wardrobeService;
    @Mock
    private Wardrobe mockWardrobe;
    private WardrobeDTO wardrobeDTO;
    private User user;
    
    @BeforeEach
    void setUp() {
        mockWardrobe = new Wardrobe(1L, new User(2L, "USER", "Test User", "testuser@email.com", "Profile Image"), "My Wardrobe", new ArrayList<Wearable>());
        wardrobeDTO = new WardrobeDTO();
            wardrobeDTO.setUserId(2L);
            wardrobeDTO.setWardrobeId(1L);
            wardrobeDTO.setWardrobeName("Test Wardrobe");
        user = new User(2L, "USER", "Test User", "testuser@email.com", "Profile Image");
    
    }

    @Test
    public void testGetAllWardrobes() {
        Wardrobe mockWardrobe = new Wardrobe(1L, new User(), "Test Wardrobe", new ArrayList<>());
        
        List<Wardrobe> mockWardrobes = new ArrayList<>();
        mockWardrobes.add(mockWardrobe);
        
        when(wardrobeRepository.findAll()).thenReturn(mockWardrobes);
        
        List<WardrobeDTO> result = wardrobeService.getAllWardrobes();
        
        WardrobeDTO expectedDTO = new WardrobeDTO(mockWardrobe);
        
        assertEquals(1, result.size());
    }


    @Test
    public void testGetWardrobesByUserId() {
        User user = new User(2L, "USER", "Test User", "testuser@email.com", "Profile Image");
        
        Wardrobe mockWardrobe = new Wardrobe(1L, user, "Test Wardrobe", new ArrayList<>());
        
        List<Wardrobe> mockWardrobes = new ArrayList<>();
        mockWardrobes.add(mockWardrobe);
        
        when(wardrobeRepository.findAll()).thenReturn(mockWardrobes);
    
        WardrobeDTO expectedDTO = new WardrobeDTO(mockWardrobe);
    
        List<WardrobeDTO> result = wardrobeService.getWardrobesByUserId(2L);
    
        assertEquals(1, result.size());
    }

    @Test
    public void testGetWardrobeById() {
        User user = new User(2L, "USER", "Test User", "testuser@email.com", "Profile Image");
        Wardrobe mockWardrobe = new Wardrobe(1L, user, "Test Wardrobe", new ArrayList<>());
        WardrobeDTO expectedDTO = new WardrobeDTO(mockWardrobe);

        when(wardrobeRepository.findById(1L)).thenReturn(Optional.of(mockWardrobe));

        Optional<WardrobeDTO> result = wardrobeService.getWardrobeById(1L);

        assertTrue(result.isPresent());
    }

}
