package com.example.songr;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class HelloController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/")
    public String getHome(){
        return "index.html";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String getHello(){
        return "Hello world";
    }


    @GetMapping("/capitalize/{word}")
    //@ResponseBody
    public String capitalize( @PathVariable ("word") String word,Model model){
    model.addAttribute("word",word.toUpperCase());
    return "capitalize.html";
    }




    @GetMapping("/albums")
    public String getAlbums(Model model){
      model.addAttribute("albums",albumRepository.findAll());
      model.addAttribute("songs",songRepository.findAll());
        return "albums.html";
    }

    @PostMapping("/addNewAlbum")
    public RedirectView addNewAlbum(@RequestParam("title") String title ,
                                    @RequestParam("artist") String artist,
                                     @RequestParam(value ="songCount") int songCount ,
                                    @RequestParam (value = "length") int length ,
                                    @RequestParam ("imageUrl") String imageUrl){
        //System.out.println(title);
        Album newAlbum=new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(newAlbum);

        return new RedirectView("/albums");
    }

    //initial data
    @GetMapping("/addAlbum")
    public RedirectView addAlbum(){


       Album a1=new Album("Hanenak Haneni","George wassouf",8,5000,"https://i.ytimg.com/vi/H7EQujTRZ0s/maxresdefault.jpg");
        Song s1 =new Song("Hanenak Haneni",4000,1,a1);
        albumRepository.save(a1);
        songRepository.save(s1);
        Album a2=new Album("A Night at the Opera ","Queen",12,6000,"https://images2.minutemediacdn.com/image/upload/c_crop,h_359,w_640,x_0,y_18/f_auto,q_auto,w_1100/v1555379274/shape/mentalfloss/queen_primary.jpg");
        albumRepository.save(a2);
        Album a3 =new Album("Yawman Ma","Julia Boutros",10,4000,"https://i.scdn.co/image/ab67616d0000b2731498fa6f113fbde265d39880");
        albumRepository.save(a3);
        return new RedirectView("/albums");
    }



}
