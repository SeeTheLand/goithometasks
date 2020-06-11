package com.dermentli.task7;

public class Main {

    public static void main(String[] args) {
        String[] playlist;
        //player 1
        Onkyo onkyo = new Onkyo(780.00);
        onkyo.setSong("Rain On Me");
        onkyo.playSong();
        //player 2
        AppleIPod appleIPod = new AppleIPod(194.95);
        appleIPod.playSong();
        //player 3
        HiFiMan hiFiMan = new HiFiMan(110.25);
        playlist = new String[] {"Toosie Slide", "Don't Start Now", "Intentions"};
        hiFiMan.playSong(playlist);
        hiFiMan.playAllSongs(playlist);
        //player 4
        AstellKern astellKern = new AstellKern(209.00);
        playlist = new String[] {"Toosie Slide", "Don't Start Now", "Intentions"};
        astellKern.playSong(playlist);
        astellKern.playAllSongs(playlist);
        //player 5
        SanDisk sanDisk = new SanDisk(34.98);
        playlist = new String[] {"Toosie Slide", "Don't Start Now", "Intentions"};
        sanDisk.playSong(playlist);
        sanDisk.playAllSongs(playlist);
        //player 6
        SonyWalkman sonyWalkman = new SonyWalkman(158.89);
        playlist = new String[] {"Toosie Slide", "Don't Start Now", "Intentions"};
        sonyWalkman.playSong(playlist);
        sonyWalkman.playAllSongs(playlist);
        sonyWalkman.shuffle(playlist);
        sonyWalkman.playAllSongs(playlist);
    }



}
