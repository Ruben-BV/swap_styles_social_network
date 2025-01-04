package dev.ruben.swap_styles_social_network.clothingItem;

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

import dev.ruben.swap_styles_social_network.clothingItem.ClothingItemDTO;
import dev.ruben.swap_styles_social_network.clothingItem.ClothingItemService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

public class ClothingItemControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ClothingItemService clothingItemService;
    
    @InjectMocks
    private ClothingItemController clothingItemController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clothingItemController).build();
    }
    @Test
    public void testCreateClothingItem() throws Exception {
        ClothingItem clothingItem = new ClothingItem();
        
        ClothingItemDTO savedClothingItemDTO = new ClothingItemDTO();

        when(clothingItemService.createClothingItem(any(ClothingItemDTO.class))).thenReturn(savedClothingItemDTO);
        mockMvc.perform(post("/clothingItem/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(clothingItem)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllClothingItems() throws Exception {
        
        ClothingItemDTO clothingItem1 = new ClothingItemDTO();
        clothingItem1.setClothingItemId(1L);
        clothingItem1.setClothingItemName("ClothingItem 1");

        ClothingItemDTO clothingItem2 = new ClothingItemDTO();
        clothingItem2.setClothingItemId(2L);
        clothingItem2.setClothingItemName("ClothingItem 2");

        List<ClothingItemDTO> clothingItems = Arrays.asList(clothingItem1, clothingItem2);

        when(clothingItemService.getAllClothingItems()).thenReturn(clothingItems);

        mockMvc.perform(get("/admin/clothingItem/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].clothingItemId").value(1L))
                .andExpect(jsonPath("$[1].clothingItemName").value("ClothingItem 2"));
    }
}
