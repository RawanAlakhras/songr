package com.example.songr;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class HelloController {
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
        List <Album>albums=new ArrayList<>();
        albums.add(new Album("A Night at the Opera ","Queen",12,6000,"https://images2.minutemediacdn.com/image/upload/c_crop,h_359,w_640,x_0,y_18/f_auto,q_auto,w_1100/v1555379274/shape/mentalfloss/queen_primary.jpg"));
        albums.add(new Album("Yawman Ma","Julia Boutros",10,4000,"https://i.scdn.co/image/ab67616d0000b2731498fa6f113fbde265d39880"));
        albums.add(new Album("Hanenak Haneni","George wassouf",8,5000,"https://i.ytimg.com/vi/H7EQujTRZ0s/maxresdefault.jpg"));
        model.addAttribute("albums",albums);
        return "albums.html";
    }
}
