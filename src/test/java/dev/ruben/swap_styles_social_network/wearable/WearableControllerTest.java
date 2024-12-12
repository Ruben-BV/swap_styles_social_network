package dev.ruben.swap_styles_social_network.wearable;

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

public class WearableControllerTest {
    private MockMvc mockMvc;

    @Mock
    private WearableService wearableService;
    
    @InjectMocks
    private WearableController wearableController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wearableController).build();
    }
    @Test
    public void testCreateWearable() throws Exception {
        Wearable wearable = new Wearable();
        
        WearableDTO savedWearableDTO = new WearableDTO();

        when(wearableService.createWearable(any(WearableDTO.class))).thenReturn(savedWearableDTO);
        mockMvc.perform(post("/wearable/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(wearable)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllWearables() throws Exception {
        
        WearableDTO wearable1 = new WearableDTO();
        wearable1.setWearableId(1L);
        wearable1.setWearableName("Wearable 1");

        WearableDTO wearable2 = new WearableDTO();
        wearable2.setWearableId(2L);
        wearable2.setWearableName("Wearable 2");

        List<WearableDTO> wearables = Arrays.asList(wearable1, wearable2);

        when(wearableService.getAllWearables()).thenReturn(wearables);

        mockMvc.perform(get("/admin/wearable/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].wearableId").value(1L))
                .andExpect(jsonPath("$[1].wearableName").value("Wearable 2"));
    }
}
