package com.dermentli.task7;

public class SanDisk extends Player {
    //player 5
    private final Double price;

    public SanDisk(Double price) {
        this.price = price;
    }

    @Override
    public void playAllSongs(String[] playlist) {
        for (int i = playlist.length-1; i >= 0; i--) {
            System.out.println(playlist[i]);
        }
    }
}
