package com.darksideoftherainbow.service.impl;

import com.darksideoftherainbow.model.Artist;
import com.darksideoftherainbow.repository.ArtistRepository;
import com.darksideoftherainbow.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Toan on 5/2/2017.
 */
@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findOne(Integer artistID) {
        return artistRepository.findOne(artistID);
    }

    @Override
    public List<Artist> findByName(String artistName) {
        return findByName(artistName);
    }

    @Override
    public Artist create(Artist artist) {
        return artistRepository.create(artist);
    }

    @Override
    public Artist edit(Integer artistID, String artistName, Integer members) {
        return artistRepository.edit(artistID, artistName, members);
    }

    @Override
    public Boolean delete(Integer artistID) {
        return artistRepository.delete(artistID);
    }
}
