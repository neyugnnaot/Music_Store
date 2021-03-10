package com.darksideoftherainbow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Toan on 5/2/2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_id_seq")
    @SequenceGenerator(name = "artist_id_seq", sequenceName = "artist_id_seq", allocationSize = 100)
    private Integer artistID;

    private String artistName;
    private Integer members;

    public Artist(String artistName, Integer members) {
        this.artistName = artistName;
        this.members = members;
    }

}
