package com.dermentli.task7;

public class AppleIPod extends Player {
    //player 2
    private final Double price;

    public AppleIPod(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public void playSong() {
        System.out.println("error");
    }
}
