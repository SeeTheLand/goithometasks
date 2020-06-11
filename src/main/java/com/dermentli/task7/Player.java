package com.dermentli.task7;

public class Player {
    private String song;

    public void playAllSongs(String[] playlist) {
        for (int i = 0; i < playlist.length; i++) {
            System.out.println(playlist[i]);
        }
    }

    public void playSong() {
        System.out.println(song);
    }

    public void playSong(String[] playlist) {
        System.out.println(playlist[0]);
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

}
