package com.dermentli.task8;

public class Main {
    public static void main(String[] args) {
        FlowerStore awesomeFlower = new FlowerStore();
        Flower[] consBuket = awesomeFlower.sell(2, 3, 4);
        awesomeFlower.printBuket(consBuket);
        Flower[] mixBuket = awesomeFlower.sellSequence(2, 3, 4);
        awesomeFlower.printBuket(mixBuket);
        System.out.println(awesomeFlower.purse);
    }
}
