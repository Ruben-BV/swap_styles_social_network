package dev.ruben.swap_styles_social_network.friendship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ruben.swap_styles_social_network.user.User;

public class FriendshipDTOTest {
    private FriendshipDTO testFriendshipDTO;
    private User user1;
    private User user2;
    
    @BeforeEach
    public void init() {
        this.testFriendshipDTO = new FriendshipDTO();
    }
    @Test
    public void testFriendshipDTOConstructor() {
        
        Long friendshipId = 1L;
        user1 = new User(2L, "USER", "Test User1", "testuser1@email.com", "Profile Image1");
        user2 = new User(3L, "USER", "Test User2", "testuser2@email.com", "Profile Image2");
        FriendshipStatus friendshipStatus = FriendshipStatus.ACCEPTED;
        
        
        Friendship testFriendship = new Friendship(friendshipId, user1, user2, friendshipStatus);
        FriendshipDTO testFriendshipDTO = new FriendshipDTO(testFriendship);

        assertNotNull(testFriendshipDTO);
        assertEquals(friendshipId, testFriendshipDTO.getFriendshipId());
        assertEquals(user1.getUserId(), testFriendshipDTO.getUser1Id());
        assertEquals(user2.getUserId(), testFriendshipDTO.getUser2Id());
        assertEquals(friendshipStatus, testFriendshipDTO.getFriendshipStatus());
    }

    @Test
    void testSetAndGetClothingItemId() {
        testFriendshipDTO.setFriendshipId(3L);
        Long result=testFriendshipDTO.getFriendshipId();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetUser1() {
        testFriendshipDTO.setUser1Id(3L);
        Long result=testFriendshipDTO.getUser1Id();

        assertEquals(3, result);
    }

    @Test
    void testSetAndGetUser2() {
        testFriendshipDTO.setUser2Id(4L);
        Long result=testFriendshipDTO.getUser2Id();

        assertEquals(4, result);
    }

    @Test
    void testSetAndGetFriendshipStatus() {
        testFriendshipDTO.setFriendshipStatus(FriendshipStatus.ACCEPTED);
        FriendshipStatus result=testFriendshipDTO.getFriendshipStatus();

        assertEquals(FriendshipStatus.ACCEPTED, result);
    }
}
