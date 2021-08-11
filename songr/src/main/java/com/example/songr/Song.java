package com.example.songr;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    private Album songAlbum;

    public Song(){}

    public Song(String title, int trackNumber) {
        this.title = title;
        this.trackNumber = trackNumber;
    }

    public Song(String title, int length, int trackNumber, Album songAlbum) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.songAlbum = songAlbum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void setSongAlbum(Album songAlbum) {
        this.songAlbum = songAlbum;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getSongAlbum() {
        return songAlbum;
    }
}
