package com.darksideoftherainbow.repository;

import com.darksideoftherainbow.model.Album;

import java.util.List;

/**
 * Created by Toan on 4/10/2017.
 */
public interface AlbumRepository {

    List<Album> findAll();
    Album findOne(Integer albumID);
    List<Album> findByTitle(String albumTitle);
    Album create(Album album);
    Album edit(Integer albumID, String title, String artist, Album.Genre genre, Integer numOfTracks, String price);
    Boolean delete(Integer albumID);

}
