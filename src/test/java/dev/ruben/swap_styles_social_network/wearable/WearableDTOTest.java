package dev.ruben.swap_styles_social_network.wearable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;

public class WearableDTOTest {
    private WearableDTO testWearableDTO;
    private Wardrobe wardrobe;
    
    @BeforeEach
    public void init() {
        this.testWearableDTO = new WearableDTO();
    }

    @Test
    public void testWearableDTOConstructor() {
        
        Long wearableId = 1L;
        Wardrobe testWardrobe = new Wardrobe(2L, new User(), "My Wardrobe", new ArrayList<Wearable> ());
        WearableType wearableType = WearableType.COSTUME;
        String wearableName = "My Wearable";
        String wearableDescription = "My favourite wearable.";
        boolean visibility = true;
        List<String> photosList = new ArrayList<String>();
        
        
        Wearable testWearable = new Wearable(wearableId, testWardrobe, wearableType, wearableName, wearableDescription, visibility, photosList);
        WearableDTO testWearableDTO = new WearableDTO(testWearable);

        assertNotNull(testWearableDTO);
        assertEquals(wearableId, testWearableDTO.getWearableId());
        assertEquals(testWardrobe.getWardrobeId(), testWearable.getWardrobe().getWardrobeId());
        assertEquals(wearableType, testWearableDTO.getWearableType());
        assertEquals(wearableName, testWearableDTO.getWearableName());
        assertEquals(wearableDescription, testWearableDTO.getWearableDescription());
        assertEquals(visibility, testWearableDTO.isVisibility());
        assertEquals(photosList, testWearableDTO.getPhotosList());

    }

    @Test
    void testSetAndGetWearableId() {
        testWearableDTO.setWearableId(3L);
        Long result=testWearableDTO.getWearableId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetWardrobeId() {
        testWearableDTO.setWardrobeId(3L);
        Long result=testWearableDTO.getWardrobeId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetWearableType() {
        testWearableDTO.setWearableType(WearableType.COAT);
        WearableType result=testWearableDTO.getWearableType();

        assertEquals(WearableType.COAT, result);
    }

    @Test
    void testSetAndGetWearableName() {
        testWearableDTO.setWearableName("Wearable Name");
        String result=testWearableDTO.getWearableName();

        assertEquals("Wearable Name", result);
    }

    @Test
    void testSetAndGetWearableDescription() {
        testWearableDTO.setWearableDescription("Wearable Description");
        String result=testWearableDTO.getWearableDescription();

        assertEquals("Wearable Description", result);
    }

    @Test
    void testSetAndGetWearableVisibility() {
        testWearableDTO.setVisibility(true);
        Boolean result=testWearableDTO.isVisibility();

        assertEquals(true, result);
    }

    @Test
    void testSetAndGetPhotosList() {
        List<String> testPhotosList = new ArrayList<String>();
        testWearableDTO.setPhotosList(testPhotosList);
        List<String> result=testWearableDTO.getPhotosList();

        assertEquals(testPhotosList, result);
    }


}
