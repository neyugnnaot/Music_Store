package com.darksideoftherainbow.service.impl;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.repository.AlbumRepository;
import com.darksideoftherainbow.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Toan on 4/10/2017.
 */

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findOne(Integer albumID) {
        return albumRepository.findOne(albumID);
    }

    @Override
    public List<Album> findByTitle(String albumTitle) {
        return albumRepository.findByTitle(albumTitle);
    }

    @Override
    public Album create(Album album) {
        return albumRepository.create(album);
    }

    @Override
    public Album edit(Integer albumID, String title, String artist, Album.Genre genre, Integer numOfTracks, String price) {
        return albumRepository.edit(albumID, title, artist, genre, numOfTracks, price);
    }

    @Override
    public Boolean delete(Integer albumID) {
        return albumRepository.delete(albumID);
    }
}
