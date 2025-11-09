package com.social.profile.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;        // Reference to user-service user
    private String fullName;
    private String bio;
    private String location;
    private String profileImageUrl;
}

