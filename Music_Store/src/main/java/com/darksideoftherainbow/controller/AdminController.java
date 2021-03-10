package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.model.Artist;
import com.darksideoftherainbow.service.AlbumService;
import com.darksideoftherainbow.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Toan on 4/13/2017.
 */

@Controller
public class AdminController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    //Add album modified to set everything but albumID
    @RequestMapping(value = "/admin/albums/add", method = RequestMethod.GET)

    public String addAlbumPage() {
        return "addalbum";
    }

    @RequestMapping(value = "/admin/albums/add", method = RequestMethod.POST)
    public String submitAlbumPage(@RequestParam("title") String title
            , @RequestParam("artist") String artist
            , @RequestParam("genre") Album.Genre genre
            , @RequestParam("numOfTracks") Integer numOfTracks
            , @RequestParam("price") String price) {
        Album album = new Album();
        album.setTitle(title);
        album.setArtist(artist);
        album.setDateReleased(new Date());
        album.setGenre(genre);
        album.setNumOfTracks(numOfTracks);
        album.setPrice(Double.parseDouble(price));
        albumService.create(album);
        return "redirect:/admin/albums/view";
    }

    //Edit modified to edit everything except for albumID and dateReleased
    @RequestMapping(value = "/admin/albums/edit/{albumID}", method = RequestMethod.GET)
    public String editAlbumForm(@PathVariable Integer albumID, Model model) {

        Album album = albumService.findOne(albumID);
        if (album != null){
            model.addAttribute("title", album.getTitle());
            model.addAttribute("artist", album.getArtist());
            model.addAttribute("genre", album.getGenre());
            model.addAttribute("numOfTracks", album.getNumOfTracks());
            model.addAttribute("price", album.getPrice());
            model.addAttribute("albumID", album.getAlbumID());
            return "editalbum";
        } else {
            return "index";
        }

    }

    @RequestMapping(value = "/admin/albums/edit", method = RequestMethod.POST)
    public String saveAlbumEdit(@RequestParam(value = "title") String title
            , @RequestParam(value = "artist") String artist
            , @RequestParam(value = "genre") Album.Genre genre
            , @RequestParam(value = "numOfTracks") Integer numOfTracks
            , @RequestParam(value = "price") String price
            , @RequestParam(value = "albumID") Integer albumID) {
        albumService.edit(albumID, title, artist, genre, numOfTracks, price);
        return "redirect:/admin/albums/view";
    }

    @RequestMapping(value = "/admin/albums/delete/{albumID}")
    public String deleteAlbum(@PathVariable Integer albumID) {
        albumService.delete(albumID);
        return "redirect:/admin/albums/view";
    }

    //View added because it was on the problem set as a requirement
    @RequestMapping(value = "/admin/albums/view", method = RequestMethod.GET)
    public String viewAll(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "view";
    }

    //View for artists
    @RequestMapping(value = "/admin/artists/view", method = RequestMethod.GET)
    public String viewArtists(Model model) {
        model.addAttribute("artists", artistService.findAll());
        return "viewartist";
    }

    //For adding artists
    @RequestMapping(value = "/admin/artists/add", method = RequestMethod.GET)
    public String addArtistPage(){
        return "addartist";
    }

    @RequestMapping(value = "/admin/artists/add", method = RequestMethod.POST)
    public String submitArtistPage(@RequestParam(value = "artistName") String artistName,
                                   @RequestParam(value = "members") Integer members) {
        Artist artist = new Artist(artistName, members);
        artistService.create(artist);
        return "redirect:/admin/artists/view";
    }

    //For editing artists
    @RequestMapping(value = "/admin/artists/edit/{artistID}", method = RequestMethod.GET)
    public String editArtistForm(@PathVariable Integer artistID, Model model) {
        Artist artist = artistService.findOne(artistID);
        if (artist != null) {
            model.addAttribute("artistName", artist.getArtistName());
            model.addAttribute("members", artist.getMembers());
            return "editartist";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/admin/artists/edit", method = RequestMethod.POST)
    public String saveArtistEdit(@RequestParam(value = "artistName") String artistName,
                                  @RequestParam(value = "members") Integer members,
                                  @RequestParam(value = "artistID") Integer artistID) {
        artistService.edit(artistID, artistName, members);
        return "redirect:/admin/artists/view";
    }

    //For deleting artists
    @RequestMapping(value = "/admin/artists/delete/{artistID}")
    public String deleteArtist(@PathVariable Integer artistID) {
        artistService.delete(artistID);
        return "redirect:/admin/artists/view";
    }
}
