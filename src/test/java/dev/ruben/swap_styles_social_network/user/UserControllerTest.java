package dev.ruben.swap_styles_social_network.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.springframework.http.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;


public class UserControllerTest {
    
    private MockMvc mockMvc;

    @Mock
    private UserService userService;
    
    @InjectMocks
    private UserController userController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setUserId(1L);
        user.setUserType("USER");
        user.setUserName("Mario");
        user.setEmailAddress("mario@email.com");
        user.setProfileImage("Profile Image");
        
        User savedUser = new User();
        savedUser.setUserId(1L);
        savedUser.setUserType("USER");
        savedUser.setUserName("Mario");
        savedUser.setEmailAddress("mario@email.com");
        savedUser.setProfileImage("Profile Image");

        when(userService.createUser(any(User.class))).thenReturn(savedUser);
        mockMvc.perform(post("/user/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").value(1L))
                .andExpect(jsonPath("$.userName").value("Mario"));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUserType("USER");
        user1.setUserName("Mario");
        user1.setEmailAddress("mario@email.com");
        user1.setProfileImage("Profile Image");
        
        User user2 = new User();
        user2.setUserId(2L);
        user2.setUserType("USER");
        user2.setUserName("Lisa");
        user2.setEmailAddress("lisa@email.com");
        user2.setProfileImage("Profile Image");
        
        List<User> users = Arrays.asList(user1, user2);
        when(userService.getAllUsers()).thenReturn(users);

        List<User> response = userController.getAllUsers();

        assertEquals(2, response.size());
    }

    @Test
    void testGetUserById() throws Exception {
        
        Long idToFind = 2L;
        User mockUser = new User();
        mockUser.setUserId(2L);
        mockUser.setUserType("USER");
        mockUser.setUserName("Mario");
        mockUser.setEmailAddress("mario@email.com");
        mockUser.setProfileImage("Profile Image");

        when(userService.getUserById(idToFind)).thenReturn(mockUser);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/findUserById/{userId}", idToFind))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userType").value("USER"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("Mario"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profileImage").value("Profile Image"));
    }

    @Test
    void testGetUserByEmail() throws Exception {
        
        String emailToFind = "mario@email.com";
        User mockUser = new User();
        mockUser.setUserId(2L);
        mockUser.setUserType("USER");
        mockUser.setUserName("Mario");
        mockUser.setEmailAddress("mario@email.com");
        mockUser.setProfileImage("Profile Image");

        when(userService.getUserByEmail(emailToFind)).thenReturn(mockUser);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/findUserByEmail/{userId}", emailToFind))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userType").value("USER"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("Mario"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profileImage").value("Profile Image"));
    }

    @Test
    public void testUpdateUserById_userFound() throws Exception {
        User existingUser = new User();
        existingUser.setUserId(2L);
        existingUser.setUserType("USER");
        existingUser.setUserName("Mario");
        existingUser.setEmailAddress("mario@email.com");
        existingUser.setProfileImage("Profile Image");

        User updatedUser = new User();
        updatedUser.setUserName("Mario Ways");
        updatedUser.setEmailAddress("mario_ways@email.com");
        updatedUser.setProfileImage("Profile Image");

        when(userService.getUserById(2L)).thenReturn(existingUser);
        when(userService.updateUser(any(User.class))).thenReturn(existingUser);

        mockMvc.perform(put("/user/updateUser/{userId}", 2L)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(updatedUser)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userType").value("USER"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("Mario Ways"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.emailAddress").value("mario_ways@email.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profileImage").value("Profile Image"));
    }

    @Test
    public void testUpdateUserById_UserNotFound() throws Exception {
        User existingUser = new User();
        existingUser.setUserId(2L);
        existingUser.setUserType("USER");
        existingUser.setUserName("Mario");
        existingUser.setEmailAddress("mario@email.com");
        existingUser.setProfileImage("Profile Image");

        User updatedUser = new User();
        updatedUser.setUserName("Mario Ways");
        updatedUser.setEmailAddress("mario_ways@email.com");
        updatedUser.setProfileImage("Profile Image");

        when(userService.getUserById(1L)).thenReturn(null);

        
        mockMvc.perform(put("/user/updateUser/{userId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedUser)))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).getUserById(1L);
        verify(userService, never()).updateUser(any(User.class));
    }
    
    @Test
    public void testDeleteUserById() throws Exception {
        doNothing().when(userService).deleteUserById(anyLong());
        mockMvc.perform(delete("/user/delete/{userId}", 1L))
                .andExpect(status().isNoContent());

    }

}
