package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Toan on 4/13/2017.
 */

@Controller
public class SiteController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/about")
    public String aboutPage() {
        return "about";
    }

    @RequestMapping(value = "/contact")
    public String contactPage() {
        return "contact";
    }

    @RequestMapping(value = "/careers")
    public String careersPage() {
        return "careers";
    }

    //Search has been moved to its own page
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPage(@RequestParam(value = "title") String title, Model model) {
        model.addAttribute("albums", albumService.findByTitle(title));
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchGo() {
        return "search";
    }

    //Requested by a friend to add
    @RequestMapping(value = "/lessons")
    public String lessonsPage() {
        return "lessons";
    }

}
