package dev.ruben.swap_styles_social_network.wardrobe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.clothingItem.ClothingItem;
import dev.ruben.swap_styles_social_network.user.User;

public class WardrobeTest {
    private Wardrobe testWardrobe;
    private User user;
    
    @BeforeEach
    public void init() {
        this.testWardrobe = new Wardrobe();
    }

    @Test
    public void testWardrobeConstructor() {
        
        Long wardrobeId = 1L;
        User testUser = new User(2L, "USER", "Test User", "testuser@email.com", "Profile Image");
        String wardrobeName = "My Wardrobe";
        List<ClothingItem> clothingItems = new ArrayList<ClothingItem>();

        Wardrobe testWardrobe = new Wardrobe(wardrobeId, testUser, wardrobeName, clothingItems);

        assertNotNull(testWardrobe);
        assertEquals(wardrobeId, testWardrobe.getWardrobeId());
        assertEquals(testUser, testWardrobe.getUser());
        assertEquals(wardrobeName, testWardrobe.getWardrobeName());
        assertEquals(clothingItems, testWardrobe.getClothingItems());
    }

    @Test
    void testSetAndGetWardrobeId() {
        testWardrobe.setWardrobeId(3L);
        Long result=testWardrobe.getWardrobeId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetUser() {
        User testUser = new User(2L, "USER", "Test User", "testuser@email.com", "Profile Image");
        testWardrobe.setUser(testUser);
        User result=testWardrobe.getUser();

        assertEquals(testUser, result);
    }

    @Test
    void testSetAndGetWardrobeName() {
        testWardrobe.setWardrobeName("Test Wardrobe");
        String result=testWardrobe.getWardrobeName();

        assertEquals("Test Wardrobe", result);
    }

    @Test
    void testSetAndGetClothingItems() {
        List<ClothingItem> clothingItems = new ArrayList<ClothingItem>();
        testWardrobe.setClothingItems(clothingItems);
        List<ClothingItem> result=testWardrobe.getClothingItems();

        assertEquals(clothingItems, result);
    }
}
