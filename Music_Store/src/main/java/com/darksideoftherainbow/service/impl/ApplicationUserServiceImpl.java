package com.darksideoftherainbow.service.impl;

import com.darksideoftherainbow.model.ApplicationUser;
import com.darksideoftherainbow.repository.ApplicationUserRepository;
import com.darksideoftherainbow.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Toan on 4/15/2017.
 */

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public void createApplicationUser(ApplicationUser applicationUser) {
        applicationUserRepository.createApplicationUser(applicationUser);
    }

    @Override
    public ApplicationUser findByUserName(String username) {
        return applicationUserRepository.findByUserName(username);
    }
}
