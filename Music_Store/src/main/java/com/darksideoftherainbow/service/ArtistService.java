package com.darksideoftherainbow.service;

import com.darksideoftherainbow.model.Artist;

import java.util.List;

/**
 * Created by Toan on 5/2/2017.
 */
public interface ArtistService {
    List<Artist> findAll();
    Artist findOne(Integer artistID);
    List<Artist> findByName(String artistName);
    Artist create(Artist artist);
    Artist edit(Integer artistID, String artistName, Integer members);
    Boolean delete(Integer artistID);
}
