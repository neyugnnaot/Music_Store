package com.darksideoftherainbow.repository;

import com.darksideoftherainbow.model.ApplicationUser;

/**
 * Created by Toan on 4/15/2017.
 */
public interface ApplicationUserRepository {

    void createApplicationUser(ApplicationUser applicationUser);
    ApplicationUser findByUserName(String username);

}
