package com.darksideoftherainbow.jpa;

import com.darksideoftherainbow.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Toan on 4/28/2017.
 */
public interface ApplicationUserCrudRepository extends CrudRepository<ApplicationUser, Integer>{

    List<ApplicationUser> findByUsernameAllIgnoreCase(String username);
}
