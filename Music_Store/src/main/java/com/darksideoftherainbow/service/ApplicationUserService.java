package com.darksideoftherainbow.service;

import com.darksideoftherainbow.model.ApplicationUser;

/**
 * Created by Toan on 4/15/2017.
 */
public interface ApplicationUserService {

    void createApplicationUser(ApplicationUser applicationUser);
    ApplicationUser findByUserName(String username);
}
