package dev.ruben.swap_styles_social_network.wardrobe;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

public class WardrobeControllerTest {
    private MockMvc mockMvc;

    @Mock
    private WardrobeService wardrobeService;
    
    @InjectMocks
    private WardrobeController wardrobeController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wardrobeController).build();
    }
    @Test
    public void testCreateWardrobe() throws Exception {
        Wardrobe wardrobe = new Wardrobe();
        
        WardrobeDTO savedWardrobeDTO = new WardrobeDTO();
        

        when(wardrobeService.createWardrobe(any(WardrobeDTO.class))).thenReturn(savedWardrobeDTO);
        mockMvc.perform(post("/wardrobe/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(wardrobe)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllWardrobes() throws Exception {
        
        WardrobeDTO wardrobe1 = new WardrobeDTO();
        wardrobe1.setWardrobeId(1L);
        wardrobe1.setWardrobeName("Wardrobe 1");

        WardrobeDTO wardrobe2 = new WardrobeDTO();
        wardrobe2.setWardrobeId(2L);
        wardrobe2.setWardrobeName("Wardrobe 2");

        List<WardrobeDTO> wardrobes = Arrays.asList(wardrobe1, wardrobe2);

        when(wardrobeService.getAllWardrobes()).thenReturn(wardrobes);

        mockMvc.perform(get("/admin/wardrobe/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].wardrobeId").value(1L))
                .andExpect(jsonPath("$[1].wardrobeName").value("Wardrobe 2"));
    }
}
