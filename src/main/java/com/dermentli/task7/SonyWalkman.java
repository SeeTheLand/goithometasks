package com.dermentli.task7;

import java.util.Random;

public class SonyWalkman extends Player {
    //player 6
    private final Double price;

    public SonyWalkman(Double price) {
        this.price = price;
    }

    public void shuffle(String[] playlist) {
        Random random = new Random();

        for (int i = 0; i < playlist.length; i++) {
            int randomPosition = random.nextInt(playlist.length);
            String temporary = playlist[i];
            playlist[i] = playlist[randomPosition];
            playlist[randomPosition] = temporary;
        }
    }


}
