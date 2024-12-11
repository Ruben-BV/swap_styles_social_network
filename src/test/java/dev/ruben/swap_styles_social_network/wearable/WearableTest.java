package dev.ruben.swap_styles_social_network.wearable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.user.User;
import dev.ruben.swap_styles_social_network.wardrobe.Wardrobe;

public class WearableTest {
    private Wearable testWearable;
    private Wardrobe wardrobe;
    
    @BeforeEach
    public void init() {
        this.testWearable = new Wearable();
    }

    @Test
    public void testWearableConstructor() {
        
        Long wearableId = 1L;
        Wardrobe testWardrobe = new Wardrobe(2L, new User(), "My Wardrobe", new ArrayList<Wearable> ());
        WearableType wearableType = WearableType.COSTUME;
        String wearableName = "My Wearable";
        String wearableDescription = "My favourite wearable.";
        boolean visibility = true;
        List<String> photosList = new ArrayList<String>();

        testWearable = new Wearable(wearableId, testWardrobe, wearableType, wearableName, wearableDescription, visibility, photosList);

        assertNotNull(testWearable);
        assertEquals(wearableId, testWearable.getWearableId());
        assertEquals(testWardrobe, testWearable.getWardrobe());
        assertEquals(wearableType, testWearable.getWearableType());
        assertEquals(wearableName, testWearable.getWearableName());
        assertEquals(wearableDescription, testWearable.getWearableDescription());
        assertEquals(visibility, testWearable.isVisibility());
        assertEquals(photosList, testWearable.getPhotosList());
        
    }

    @Test
    void testSetAndGetWearableId() {
        testWearable.setWearableId(3L);
        Long result=testWearable.getWearableId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetWardrobe() {
        Wardrobe setWardrobe = new Wardrobe();
        testWearable.setWardrobe(setWardrobe);
        Wardrobe result=testWearable.getWardrobe();

        assertEquals(setWardrobe, result);
    }

    @Test
    void testSetAndGetWearableType() {
        testWearable.setWearableType(WearableType.ACCESSORIES);
        WearableType result=testWearable.getWearableType();

        assertEquals(WearableType.ACCESSORIES, result);
    }

    @Test
    void testSetAndGetWearableName() {
        testWearable.setWearableName("Test Name");
        String result=testWearable.getWearableName();

        assertEquals("Test Name", result);
    }

    @Test
    void testSetAndGetWearableDescription() {
        testWearable.setWearableDescription("Test Description");
        String result=testWearable.getWearableDescription();

        assertEquals("Test Description", result);
    }

    @Test
    void testSetAndGetWearableVisibility() {
        testWearable.setVisibility(true);
        Boolean result=testWearable.isVisibility();

        assertEquals(true, result);
    }

    @Test
    void testSetAndGetPhotosList() {
        List<String> testPhotosList = new ArrayList<String>();
        testWearable.setPhotosList(testPhotosList);
        List<String> result=testWearable.getPhotosList();

        assertEquals(testPhotosList, result);
    }
}
