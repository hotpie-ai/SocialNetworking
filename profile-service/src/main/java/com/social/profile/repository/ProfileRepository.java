package com.social.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.social.profile.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByUserId(Long userId);
}
