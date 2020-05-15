package com.dermentli.task5;

public class CarWheel extends Car {
    private double tyreWear;

    public CarWheel() {
        this.tyreWear = 1.0;
    }

    public void switchTyre() {
        this.tyreWear = 1.0;
    }

    public void burnTyre(int percent) {
        this.tyreWear *= (1.0 - (double) percent /100);
    }

    public double getTyreWear() {
        return (this.tyreWear*100);
    }

    public void showStatus() {
        System.out.println(this.tyreWear);
    }

}
