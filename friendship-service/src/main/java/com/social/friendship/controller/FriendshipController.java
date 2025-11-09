package com.social.friendship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.social.friendship.model.Friendship;
import com.social.friendship.service.FriendshipService;

import java.util.List;

@RestController
@RequestMapping("/api/friendship")
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @PostMapping("/send")
    public Friendship sendRequest(@RequestBody Friendship friendship) {
        return friendshipService.sendRequest(friendship);
    }

    @PostMapping("/accept/{id}")
    public Friendship acceptRequest(@PathVariable Long id) {
        return friendshipService.acceptRequest(id);
    }

    @GetMapping("/{userId}")
    public List<Friendship> getFriendships(@PathVariable Long userId) {
        return friendshipService.getUserFriendships(userId);
    }
}
