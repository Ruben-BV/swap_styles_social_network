package dev.ruben.swap_styles_social_network.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    
    private User testUser;
    
    @BeforeEach
    public void init() {
        this.testUser = new User();
    }

    @Test
    public void testUserConstructor() {
        
        Long userId = 1L;
        String userType = "ADMIN";
        String name = "Lisa";
        String emailAddress = "lisa@mail.com";
        String profileImage = "Profile Image";

        User user = new User(userId, userType, name, emailAddress, profileImage);

        assertNotNull(user);
        assertEquals(userId, user.getUserId());
        assertEquals(userType, user.getUserType());
        assertEquals(name, user.getUserName());
        assertEquals(emailAddress, user.getEmailAddress());
        assertEquals(profileImage, user.getProfileImage());
    }
    
    @Test
    void testEmptyConstructor() {
        User user = new User();
        
        assertNull(user.getUserId());
        assertNull(user.getUserType());
        assertNull(user.getUserName());
        assertNull(user.getEmailAddress());
        assertNull(user.getProfileImage());
    }

    @Test
    void testSetAndGetUserId() {
        testUser.setUserId(2L);
        Long result=testUser.getUserId();

        assertEquals(2, result);
    }
    
    @Test
    void testSetAndGetUserType() {
        testUser.setUserType("USER");
        String result = testUser.getUserType();

        assertEquals("USER", result);
    }

    @Test
    void testSetAndGetUserName() {
        testUser.setUserName("Jhon");
        String result = testUser.getUserName();

        assertEquals("Jhon", result);
    }

    @Test
    void testSetAndGetEmailAddress() {
        testUser.setEmailAddress("jhon@email.com");
        String result = testUser.getEmailAddress();

        assertEquals("jhon@email.com", result);
    }

    @Test
    void testSetAndGetProfilImage() {
        testUser.setProfileImage("Profile Image");
        String result = testUser.getProfileImage();

        assertEquals("Profile Image", result);
    }
}
