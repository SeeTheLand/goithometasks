package com.dermentli.task5.carfunctions;

public class CarDoor extends Car {
    private String doorStatus;
    private String windowStatus;

    public CarDoor(String doorStatus, String windowStatus) {
        this.doorStatus = doorStatus;
        this.windowStatus = windowStatus;
    }

    public void openDoor() {
        this.doorStatus = "open";
    }

    public void closeDoor() {
        this.doorStatus = "close";
    }

    public void switchDoor() {
        this.doorStatus = this.doorStatus.equals("close") ? "open" : "close";
    }

    public void openWindow() {
        this.windowStatus = "open";
    }

    public void closeWindow() {
        this.windowStatus = "close";
    }

    public void switchWindow() {
        this.windowStatus = this.doorStatus.equals("close") ? "open" : "close";
    }

    public void showStatus() {
        System.out.println(this.doorStatus);
        System.out.println(this.windowStatus);
    }


}
