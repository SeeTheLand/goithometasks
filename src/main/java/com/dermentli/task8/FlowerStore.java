package com.dermentli.task8;

public class FlowerStore {
    public int purse;

    public Flower[] sell (int roseNumber, int camomileNumber, int tulipNumber) {
        int totalFlowers = roseNumber + camomileNumber + tulipNumber;
        purse += roseNumber * 100 + camomileNumber * 70 + tulipNumber * 45;
        Flower[] consBuket = new Flower[totalFlowers];
        for (int i = 0; i < roseNumber; i++) {
            consBuket[i] = new Rose();
        }
        for (int i = 0; i < camomileNumber; i++) {
            consBuket[roseNumber+i] = new Camomile();
        }
        for (int i = 0; i < tulipNumber; i++) {
            consBuket[roseNumber+camomileNumber+i] = new Tulip();
        }
        return consBuket;
    }

    public Flower[] sellSequence (int roseNumber, int camomileNumber, int tulipNumber) {
        int totalFlowers = roseNumber + camomileNumber + tulipNumber;
        purse += roseNumber * 100 + camomileNumber * 70 + tulipNumber * 45;
        Flower[] mixBuket = new Flower[totalFlowers];
        for (int i = 0; i < totalFlowers;) {
            if (roseNumber > 0) {
                mixBuket[i] = new Rose();
                i++;
                roseNumber--;
            }
            if (camomileNumber > 0) {
                mixBuket[i] = new Camomile();
                i++;
                camomileNumber--;
            }
            if (tulipNumber > 0) {
                mixBuket[i] = new Tulip();
                i++;
                tulipNumber--;
            }

        }
        return mixBuket;
    }

    public void printBuket (Flower[] buket) {
        for (int i = 0; i < buket.length; i++) {
            if (i == buket.length-1) {
                System.out.println(buket[i].getClass().getSimpleName());
            } else {
                System.out.print(buket[i].getClass().getSimpleName() + ", ");
            }
        }
    }

}
