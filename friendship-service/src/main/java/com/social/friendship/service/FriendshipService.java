package com.social.friendship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.friendship.model.Friendship;
import com.social.friendship.repository.FriendshipRepository;

import java.util.List;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    public Friendship sendRequest(Friendship friendship) {
        friendship.setStatus(Friendship.Status.PENDING);
        return friendshipRepository.save(friendship);
    }

    public Friendship acceptRequest(Long id) {
        Friendship friendship = friendshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friendship not found"));
        friendship.setStatus(Friendship.Status.ACCEPTED);
        return friendshipRepository.save(friendship);
    }

    public List<Friendship> getUserFriendships(Long userId) {
        return friendshipRepository.findByRequesterIdOrReceiverId(userId, userId);
    }
}
