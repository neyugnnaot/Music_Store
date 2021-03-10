package com.darksideoftherainbow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Toan on 4/10/2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {

    //Instance Data
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq")
    @SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 100)
    private Integer albumID;

    private String title;
    private String artist;
    private Date dateReleased;
    private Genre genre;
    private Integer numOfTracks;
    private Double price;

    public Album(String title, String artist, Date dateReleased, Genre genre, Integer numOfTracks, Double price) {
        this.title = title;
        this.artist = artist;
        this.dateReleased = dateReleased;
        this.genre = genre;
        this.numOfTracks = numOfTracks;
        this.price = price;
    }

    //enum for Genres
    public enum Genre {
        ROCK, ClASSICAL, POP, JAZZ, DUBSTEP, TECHNO, METAL, COUNTRY, INDIE, MEMES
    }

}
