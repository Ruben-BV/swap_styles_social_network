package dev.ruben.swap_styles_social_network.wardrobe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.wearable.Wearable;

public class WardrobeDTOTest {
    private WardrobeDTO testWardrobeDTO;
    private User user;
    
    @BeforeEach
    public void init() {
        this.testWardrobeDTO = new WardrobeDTO();
    }

    @Test
    public void testWardrobeDTOConstructor() {
        
        Long wardrobeId = 1L;
        User testUser = new User(2L, "USER", "Test User", "testuser@email.com", "Profile Image");
        String wardrobeName = "My Wardrobe";
        List<Wearable> wearables = new ArrayList<Wearable>();

        Wardrobe testWardrobe = new Wardrobe(wardrobeId, testUser, wardrobeName, wearables);
        WardrobeDTO testWardrobeDTO = new WardrobeDTO(testWardrobe);
        assertNotNull(testWardrobeDTO);
        assertEquals(wardrobeId, testWardrobeDTO.getWardrobeId());
        assertEquals(testUser.getUserId(), testWardrobeDTO.getUserId());
        assertEquals(wardrobeName, testWardrobeDTO.getWardrobeName());
        assertEquals(wearables, testWardrobeDTO.getWearables());
    }

    @Test
    void testSetAndGetWearables() {
        List<Wearable> wearables = new ArrayList<Wearable>();
        testWardrobeDTO.setWearables(wearables);
        Long result=testWardrobeDTO.getWardrobeId();

        assertEquals(null, result);
    }

    @Test
    void testSetAndGetUserId() {
        testWardrobeDTO.setUserId(3L);
        Long result=testWardrobeDTO.getUserId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetWardrobeName() {
        testWardrobeDTO.setWardrobeName("Test Wardrobe");
        String result=testWardrobeDTO.getWardrobeName();

        assertEquals("Test Wardrobe", result);
    }

    @Test
    void testSetAndGetWardrobeId() {
        testWardrobeDTO.setWardrobeId(3L);
        Long result=testWardrobeDTO.getWardrobeId();

        assertEquals(3, result);
    }
}
