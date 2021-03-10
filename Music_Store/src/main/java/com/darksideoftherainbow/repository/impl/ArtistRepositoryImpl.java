package com.darksideoftherainbow.repository.impl;

import com.darksideoftherainbow.jpa.ArtistCrudRepository;
import com.darksideoftherainbow.model.Artist;
import com.darksideoftherainbow.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Toan on 5/2/2017.
 */
@Repository
public class ArtistRepositoryImpl implements ArtistRepository {

    @Autowired
    private ArtistCrudRepository artistCrudRepository;

    @Override
    public List<Artist> findAll() {
        List<Artist> artistList = new ArrayList<>();
        artistCrudRepository.findAll().forEach(artistList::add);
        return artistList;
    }

    @Override
    public Artist findOne(Integer artistID) {
        return artistCrudRepository.findOne(artistID);
    }

    @Override
    public List<Artist> findByName(String artistName) {
        List<Artist> artistList = new ArrayList<>();
        artistCrudRepository.findAll().forEach(artistList::add);
        return artistList.stream()
                .filter(artist -> artist.getArtistName().toLowerCase().contains(artistName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Artist create(Artist artist) {
        return artistCrudRepository.save(artist);
    }

    @Override
    public Artist edit(Integer artistID, String artistName, Integer members) {
        Artist artist = artistCrudRepository.findOne(artistID);
        if (artist != null) {
            artist.setArtistName(artistName);
            artist.setMembers(members);
            return artistCrudRepository.save(artist);
        }
        return artist;
    }

    @Override
    public Boolean delete(Integer artistID) {
        artistCrudRepository.delete(artistID);
        return Boolean.TRUE;
    }
}
