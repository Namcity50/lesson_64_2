package service;

import container.ComponentContainer;
import dto.Profile;
import enums.GeneralStatus;
import repository.ProfileRepository;

import java.util.List;

public class ProfileService {

    private ProfileRepository profileRepository;
    private CardService cardService;

    public void profileList() {
        List<Profile> profileList = profileRepository.getProfileList();
        for (Profile profile : profileList) {
            System.out.println(profile);
        }
    }

    public void changeProfileStatus(String phone) {
        Profile profile = profileRepository.getProfileByPhone(phone);
        if (profile == null) {
            System.out.println("Profile not found");
            return;
        }

        if (profile.getStatus().equals(GeneralStatus.ACTIVE)) {
            profileRepository.changeProfileStatus(phone, GeneralStatus.BLOCK);
        } else {
            profileRepository.changeProfileStatus(phone, GeneralStatus.ACTIVE);
        }
    }

    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }
}
