package dev.ruben.swap_styles_social_network.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Mock
    private User mockUser;
    private User user;
    private User existingUser;
    
    @BeforeEach
    void setUp() {
        
        mockUser = new User(1L, "USER", "Lisa", "lisa@mail.com", "Profile Image");
        user = new User(2L, "USER", "User", "user@mail.com", "Profile Image");
        existingUser = new User(3L, "USER", "Existing User", "existinguser@mail.com", "Profile Image");
        
    }

    @Test
    void testCreateUserEMailExists() {
        
        User mockUser2 = new User(1L, "USER", "Lisa Maria", "lisa@mail.com", "Profile Image");

        when(userRepository.findAll()).thenReturn(Arrays.asList(mockUser2));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(mockUser);
        });
        assertEquals("Incorrect email address.", thrown.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void testGetUserByEmail_UserNotFound() {
    
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        User foundUser = userService.getUserByEmail("nonexistent@email.com");

        assertNull(foundUser);
    }

    @Test
    void testGetAllUseres() {
        
        List<User> mockUsers = new ArrayList<>();
        
        mockUsers.add(mockUser);
        
        when(userRepository.findAll()).thenReturn(mockUsers);
        
        List<User> result = userService.getAllUsers();
        assertTrue(result.equals(mockUsers));
    }

    @Test
    public void testGetUserByIdWhenUserExists() {
        
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        assertEquals("USER", result.getUserType());
        assertEquals("Lisa", result.getUserName());
        assertEquals("lisa@mail.com", result.getEmailAddress());
        assertEquals("Profile Image", result.getProfileImage());

    }

    @Test
    public void testGetUserByIdWhenUserDoesNotExist() {
        
        when(userRepository.findById(10L)).thenReturn(Optional.empty());

        User result = userService.getUserById(10L);

        assertNull(result);
        
    }

    @Test
    public void testGetUserByEmailWhenEmailAddressDoesNotExist() {
    }
    
    @Test
    public void testGetUserByEmailWhenEmailAddressExists() {
        List<User> userList = new ArrayList<>();
        userList.add(mockUser);
    
        when(userRepository.findAll()).thenReturn(userList);
    
        User result = userService.getUserByEmail("lisa@mail.com");
        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        assertEquals("USER", result.getUserType());
        assertEquals("Lisa", result.getUserName());
        assertEquals("lisa@mail.com", result.getEmailAddress());
        assertEquals("Profile Image", result.getProfileImage());
        
    }

    @Test
    public void testUpdateUserSuccess() {
        List<User> users = new ArrayList<User>();
        users.add(existingUser);
        
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findAll()).thenReturn(users);

        User updatedUser = userService.updateUser(user);

        assertNotNull(updatedUser);
        assertEquals("user@mail.com", updatedUser.getEmailAddress());
    }

    @Test
    public void testUpdateUser_SameEmail_Success() {
        User existingUser = new User(1L, "USER", "Lisa Maria", "lisa@mail.com", "Profile Image");

        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findAll()).thenReturn(Arrays.asList(user, existingUser));

        User updatedUser = userService.updateUser(user);

        assertEquals("user@mail.com", updatedUser.getEmailAddress());
    }

}

