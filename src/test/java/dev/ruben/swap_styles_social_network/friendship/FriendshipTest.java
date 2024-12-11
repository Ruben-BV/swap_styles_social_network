package dev.ruben.swap_styles_social_network.friendship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.user.User;

public class FriendshipTest {
    private Friendship testFriendship;
    private User user1;
    private User user2;
    
    @BeforeEach
    public void init() {
        this.testFriendship = new Friendship();
    }

    @Test
    public void testWardrobeConstructor() {
        
        Long friendshipId = 1L;
        user1 = new User(2L, "USER", "Test User1", "testuser1@email.com", "Profile Image1");
        user2 = new User(3L, "USER", "Test User2", "testuser2@email.com", "Profile Image2");
        FriendshipStatus friendshipStatus = FriendshipStatus.ACCEPTED;

        Friendship testFriendship = new Friendship(friendshipId, user1, user2, friendshipStatus);

        assertNotNull(testFriendship);
        assertEquals(friendshipId, testFriendship.getFriendshipId());
        assertEquals(user1, testFriendship.getUser1());
        assertEquals(user2, testFriendship.getUser2());
        assertEquals(friendshipStatus, testFriendship.getFriendshipStatus());
    }

    @Test
    void testSetAndGetFriendshipId() {
        testFriendship.setFriendshipId(3L);
        Long result=testFriendship.getFriendshipId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetUser1() {
        testFriendship.setUser1(user1);
        User result=testFriendship.getUser1();

        assertEquals(user1, result);
    }

    @Test
    void testSetAndGetUser2() {
        testFriendship.setUser2(user1);
        User result=testFriendship.getUser2();

        assertEquals(user2, result);
    }

    @Test
    void testSetAndGetFriendshipStatus() {
        testFriendship.setFriendshipStatus(FriendshipStatus.PENDING);
        FriendshipStatus result=testFriendship.getFriendshipStatus();

        assertEquals(FriendshipStatus.PENDING, result);
    }
}
