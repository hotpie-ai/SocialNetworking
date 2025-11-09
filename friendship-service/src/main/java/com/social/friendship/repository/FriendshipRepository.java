package com.social.friendship.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.social.friendship.model.Friendship;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    List<Friendship> findByRequesterIdOrReceiverId(Long requesterId, Long receiverId);
}

