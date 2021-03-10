package com.darksideoftherainbow.bootstrap;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.model.ApplicationUser;
import com.darksideoftherainbow.model.Artist;
import com.darksideoftherainbow.repository.AlbumRepository;
import com.darksideoftherainbow.repository.ApplicationUserRepository;
import com.darksideoftherainbow.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by Toan on 4/10/2017.
 */

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //Adding Albums
        Album memes = new Album("dank memes","pepe", new Date()
                , Album.Genre.MEMES, 5, 4.99);
        albumRepository.create(memes);
        Album perfect = new Album("wow", "doge", new Date()
                , Album.Genre.DUBSTEP,9, 4.99);
        albumRepository.create(perfect);
        Album overdrive = new Album("Overdrive", "easy modo", new Date()
                , Album.Genre.INDIE, 4, 3.99);
        albumRepository.create(overdrive);

        //Adding artists
        Artist pepe = new Artist("pepe", 1);
        artistRepository.create(pepe);
        Artist doge = new Artist("doge", 1);
        artistRepository.create(doge);
        Artist easy = new Artist("easy modo", 2);
        artistRepository.create(easy);

        //Adding Users
        ApplicationUser admin = new ApplicationUser("admin", "123456", Boolean.TRUE);
        applicationUserRepository.createApplicationUser(admin);
        ApplicationUser toan = new ApplicationUser("Toan", "123456", Boolean.FALSE);
        applicationUserRepository.createApplicationUser(toan);
    }
}
