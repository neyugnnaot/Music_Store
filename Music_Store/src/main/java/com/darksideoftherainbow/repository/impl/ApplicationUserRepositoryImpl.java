package com.darksideoftherainbow.repository.impl;

import com.darksideoftherainbow.jpa.ApplicationUserCrudRepository;
import com.darksideoftherainbow.model.ApplicationUser;
import com.darksideoftherainbow.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toan on 4/15/2017.
 */

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    @Autowired
    private ApplicationUserCrudRepository applicationUserCrudRepository;

    @Override
    public void createApplicationUser(ApplicationUser applicationUser) {
        applicationUserCrudRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser findByUserName(String username) {

        List<ApplicationUser> userList = applicationUserCrudRepository.findByUsernameAllIgnoreCase(username);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }
}
