package dev.ruben.swap_styles_social_network.friendship;

public class FriendshipDTO {
    private Long friendshipId;
    private Long user1Id;
    private Long user2Id;
    private FriendshipStatus friendshipStatus;

    public FriendshipDTO(Friendship friendship){
        this.friendshipId = friendship.getFriendshipId();
        this.user1Id = friendship.getUser1().getUserId();
        this.user2Id = friendship.getUser2().getUserId();
        this.friendshipStatus = friendship.getFriendshipStatus();
    }

    public FriendshipDTO() {
    }

    public Long getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Long friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Long getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Long user1Id) {
        this.user1Id = user1Id;
    }

    public Long getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Long user2Id) {
        this.user2Id = user2Id;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }

}
