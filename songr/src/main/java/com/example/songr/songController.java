package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class songController {

    @Autowired
    SongRepository songrepo;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getSongs(Model model){
        model.addAttribute("songs",songrepo.findAll());
        return "songs.html";
    }

    @PostMapping("/addNewSong")
    public RedirectView addNewSong(@RequestParam("title") String title ,
                                    @RequestParam("trackNumber") int trackNumber,
                                    @RequestParam (value = "length") int length ,
                                    @RequestParam ("song_album_id") Long song_album_id){
        //System.out.println(title);
        Song newSong=new Song(title,trackNumber,length,albumRepository.findById(song_album_id).get());
        songrepo.save(newSong);

        return new RedirectView("/songs");
    }
    @PostMapping("/addNewSongto/{id}")
    public RedirectView addNewSongtoAlbum(@PathVariable("id") Long id,
                                          @RequestParam("title") String title ,
                                   @RequestParam("trackNumber") int trackNumber,
                                   @RequestParam (value = "length") int length)
                                  {
        //System.out.println(id);
        Song newSong=new Song(title,trackNumber,length,albumRepository.findById(id).get());
        songrepo.save(newSong);

        return new RedirectView("/albums");
    }



}
