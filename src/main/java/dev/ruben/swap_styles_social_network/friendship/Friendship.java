package dev.ruben.swap_styles_social_network.friendship;

import dev.ruben.swap_styles_social_network.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "friendships")
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendshipId;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    @Column(nullable = false)
    private FriendshipStatus friendshipStatus;

    public Friendship(Long friendshipId, User user1, User user2, FriendshipStatus friendshipStatus) {
        this.friendshipId = friendshipId;
        this.user1 = user1;
        this.user2 = user2;
        this.friendshipStatus = friendshipStatus;
    }


    public Friendship() {
    }


    public Long getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Long friendshipId) {
        this.friendshipId = friendshipId;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }

    
}

enum FriendshipStatus {
    PENDING (0),
    ACCEPTED (1),
    REJECTED (2);
    
    private int value;

    FriendshipStatus(int value) {
        this.value = value;
    }
}
