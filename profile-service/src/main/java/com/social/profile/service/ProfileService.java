package com.social.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.profile.model.Profile;
import com.social.profile.repository.ProfileRepository;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId);
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }
}
