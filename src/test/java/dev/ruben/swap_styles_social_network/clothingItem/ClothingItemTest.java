package dev.ruben.swap_styles_social_network.clothingItem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;

public class ClothingItemTest {
    private ClothingItem testClothingItem;
    private Wardrobe wardrobe;
    
    @BeforeEach
    public void init() {
        this.testClothingItem = new ClothingItem();
    }

    @Test
    public void testClothingItemConstructor() {
        
        Long clothingItemId = 1L;
        Wardrobe testWardrobe = new Wardrobe(2L, new User(), "My Wardrobe", new ArrayList<ClothingItem> ());
        ClothingItemType clothingItemType = ClothingItemType.COSTUME;
        String clothingItemName = "My Clothing Item";
        String clothingItemDescription = "My favourite clothing item.";
        boolean visibility = true;
        List<String> photosList = new ArrayList<String>();

        testClothingItem = new ClothingItem(clothingItemId, testWardrobe, clothingItemType, clothingItemName, clothingItemDescription, visibility, photosList);

        assertNotNull(testClothingItem);
        assertEquals(clothingItemId, testClothingItem.getClothingItemId());
        assertEquals(testWardrobe, testClothingItem.getWardrobe());
        assertEquals(clothingItemType, testClothingItem.getClothingItemType());
        assertEquals(clothingItemName, testClothingItem.getClothingItemName());
        assertEquals(clothingItemDescription, testClothingItem.getClothingItemDescription());
        assertEquals(visibility, testClothingItem.isVisibility());
        assertEquals(photosList, testClothingItem.getPhotosList());
        
    }

    @Test
    void testSetAndGetClothingItemId() {
        testClothingItem.setClothingItemId(3L);
        Long result=testClothingItem.getClothingItemId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetWardrobe() {
        Wardrobe setWardrobe = new Wardrobe();
        testClothingItem.setWardrobe(setWardrobe);
        Wardrobe result=testClothingItem.getWardrobe();

        assertEquals(setWardrobe, result);
    }

    @Test
    void testSetAndGetClothingItemType() {
        testClothingItem.setClothingItemType(ClothingItemType.ACCESSORIES);
        ClothingItemType result=testClothingItem.getClothingItemType();

        assertEquals(ClothingItemType.ACCESSORIES, result);
    }

    @Test
    void testSetAndGetClothingItemName() {
        testClothingItem.setClothingItemName("Test Name");
        String result=testClothingItem.getClothingItemName();

        assertEquals("Test Name", result);
    }

    @Test
    void testSetAndGetClothingItemDescription() {
        testClothingItem.setClothingItemDescription("Test Description");
        String result=testClothingItem.getClothingItemDescription();

        assertEquals("Test Description", result);
    }

    @Test
    void testSetAndGetClothingItemVisibility() {
        testClothingItem.setVisibility(true);
        Boolean result=testClothingItem.isVisibility();

        assertEquals(true, result);
    }

    @Test
    void testSetAndGetPhotosList() {
        List<String> testPhotosList = new ArrayList<String>();
        testClothingItem.setPhotosList(testPhotosList);
        List<String> result=testClothingItem.getPhotosList();

        assertEquals(testPhotosList, result);
    }
}
