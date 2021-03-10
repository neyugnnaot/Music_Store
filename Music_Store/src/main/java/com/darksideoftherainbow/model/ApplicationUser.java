package com.darksideoftherainbow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Toan on 4/15/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ApplicationUser {

    //Instance Data
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_user_id_seq")
    @SequenceGenerator(name = "application_user_id_seq", sequenceName = "application_user_id_seq", allocationSize = 100)
    private Integer id;

    private String username;
    private String password;
    private Boolean isAdmin;

    public ApplicationUser(String username, String password, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}


