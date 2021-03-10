package com.darksideoftherainbow.repository.impl;

import com.darksideoftherainbow.jpa.AlbumCrudRepository;
import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Toan on 4/10/2017.
 */

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    @Autowired
    private AlbumCrudRepository albumCrudRepository;

    @Override
    public List<Album> findAll() {
        List<Album> albumList = new ArrayList<>();
        albumCrudRepository.findAll().forEach(albumList::add);
        return albumList;
    }

    @Override
    public Album findOne(Integer albumID) {
        return albumCrudRepository.findOne(albumID);
    }

    @Override
    public List<Album> findByTitle(String albumTitle) {
        List<Album> albumList = new ArrayList<>();
        albumCrudRepository.findAll().forEach(albumList::add);
        return albumList.stream()
                .filter(album -> album.getTitle().toLowerCase().contains(albumTitle.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Album create(Album album) {
        return albumCrudRepository.save(album);
    }

    @Override
    public Album edit(Integer albumID, String title, String artist, Album.Genre genre, Integer numOfTracks, String price) {
        Album foundAlbum = albumCrudRepository.findOne(albumID);
        if (foundAlbum != null) {
            foundAlbum.setTitle(title);
            foundAlbum.setArtist(artist);
            foundAlbum.setGenre(genre);
            foundAlbum.setNumOfTracks(numOfTracks);
            foundAlbum.setPrice(Double.parseDouble(price));
            return albumCrudRepository.save(foundAlbum);
        }
        return foundAlbum;
    }

    @Override
    public Boolean delete(Integer albumID) {
        albumCrudRepository.delete(albumID);
        return Boolean.TRUE;
    }
}
