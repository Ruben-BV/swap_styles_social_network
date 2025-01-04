package dev.ruben.swap_styles_social_network.clothingItem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.clothingItem.ClothingItemDTO;
import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;

public class ClothingItemDTOTest {
    private ClothingItemDTO testClothingItemDTO;
    private Wardrobe wardrobe;
    
    @BeforeEach
    public void init() {
        this.testClothingItemDTO = new ClothingItemDTO();
    }

    @Test
    public void testClothingItemDTOConstructor() {
        
        Long clothingItemId = 1L;
        Wardrobe testWardrobe = new Wardrobe(2L, new User(), "My Wardrobe", new ArrayList<ClothingItem> ());
        ClothingItemType clothingItemType = ClothingItemType.COSTUME;
        String clothingItemName = "My ClothingItem";
        String clothingItemDescription = "My favourite clothingItem.";
        boolean visibility = true;
        List<String> photosList = new ArrayList<String>();
        
        
        ClothingItem testClothingItem = new ClothingItem(clothingItemId, testWardrobe, clothingItemType, clothingItemName, clothingItemDescription, visibility, photosList);
        ClothingItemDTO testClothingItemDTO = new ClothingItemDTO(testClothingItem);

        assertNotNull(testClothingItemDTO);
        assertEquals(clothingItemId, testClothingItemDTO.getClothingItemId());
        assertEquals(testWardrobe.getWardrobeId(), testClothingItem.getWardrobe().getWardrobeId());
        assertEquals(clothingItemType, testClothingItemDTO.getClothingItemType());
        assertEquals(clothingItemName, testClothingItemDTO.getClothingItemName());
        assertEquals(clothingItemDescription, testClothingItemDTO.getClothingItemDescription());
        assertEquals(visibility, testClothingItemDTO.isVisibility());
        assertEquals(photosList, testClothingItemDTO.getPhotosList());

    }

    @Test
    void testSetAndGetClothingItemId() {
        testClothingItemDTO.setClothingItemId(3L);
        Long result=testClothingItemDTO.getClothingItemId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetWardrobeId() {
        testClothingItemDTO.setWardrobeId(3L);
        Long result=testClothingItemDTO.getWardrobeId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetClothingItemType() {
        testClothingItemDTO.setClothingItemType(ClothingItemType.COAT);
        ClothingItemType result=testClothingItemDTO.getClothingItemType();

        assertEquals(ClothingItemType.COAT, result);
    }

    @Test
    void testSetAndGetClothingItemName() {
        testClothingItemDTO.setClothingItemName("ClothingItem Name");
        String result=testClothingItemDTO.getClothingItemName();

        assertEquals("ClothingItem Name", result);
    }

    @Test
    void testSetAndGetClothingItemDescription() {
        testClothingItemDTO.setClothingItemDescription("ClothingItem Description");
        String result=testClothingItemDTO.getClothingItemDescription();

        assertEquals("ClothingItem Description", result);
    }

    @Test
    void testSetAndGetClothingItemVisibility() {
        testClothingItemDTO.setVisibility(true);
        Boolean result=testClothingItemDTO.isVisibility();

        assertEquals(true, result);
    }

    @Test
    void testSetAndGetPhotosList() {
        List<String> testPhotosList = new ArrayList<String>();
        testClothingItemDTO.setPhotosList(testPhotosList);
        List<String> result=testClothingItemDTO.getPhotosList();

        assertEquals(testPhotosList, result);
    }


}
