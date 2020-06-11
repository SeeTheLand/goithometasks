package com.dermentli.task7;

public class AstellKern extends Player {
    //player 4
    private final Double price;

    public AstellKern(Double price) {
        this.price = price;
    }

    @Override
    public void playSong(String[] playlist) {
        System.out.println(playlist[playlist.length-1]);
    }
}
