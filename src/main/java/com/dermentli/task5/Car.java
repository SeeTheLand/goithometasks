package com.dermentli.task5;

import java.util.Arrays;

public class Car {

    final String productionDate;
    private String engineType;
    private int maxSpeed;
    private int toHundred;
    private int capacity;
    private int passengers;
    private int currentSpeed;
    private CarWheel[] wheels = {new CarWheel(), new CarWheel(), new CarWheel(), new CarWheel()};
    private CarDoor[] doors = {new CarDoor("close", "close"), new CarDoor("close", "close"), new CarDoor("close", "close"), new CarDoor("close", "close")};

    Car(String productionDate) {
        this.productionDate = productionDate;
    }

    Car(String productionDate, String engineType, int maxSpeed, int toHundred, int capacity, int passengers, int currentSpeed) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.toHundred = toHundred;
        this.capacity = capacity;
        this.passengers = passengers;
        this.currentSpeed = currentSpeed;
    }

    public void changeCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public void addPassenger() {
        this.passengers++;
    }
    public void removePassenger() {
        this.passengers--;
    }
    public void removeAllPassengers() {
        this.passengers = 0;
    }
    public CarDoor indexDoor(int i) {
        return this.doors[i];
    }
    public CarWheel indexWheel(int i) {
        return this.wheels[i];
    }
    public void removeAllWheels() {
        for (int i = 0; i < 4; i++) {
            this.wheels[i] = null;
        }
    }
    public void addWheels(int x) {
        int initialLength = this.wheels.length;
        this.wheels = Arrays.copyOf(this.wheels, (initialLength + x));
        for (int i = 0; i < x; i++) {
            this.wheels[(initialLength+i)] = new CarWheel();
        }

    }
    public int maxSpeedCalculation() {
        double worstWheel = Double.MAX_VALUE;
        for (CarWheel i : this.wheels) {
            if (i.getTyreWear() < worstWheel) {
                worstWheel = i.getTyreWear();
            }
        }
        return (int) ((double) this.maxSpeed * worstWheel) * this.passengers;
    }
    public void showCarData() {
        System.out.println("productionDate " + this.productionDate);
        System.out.println("engineType " + this.engineType);
        System.out.println("maxSpeed " + this.maxSpeed);
        System.out.println("toHundred " + this.toHundred);
        System.out.println("capacity " + this.capacity);
        System.out.println("passengers " + this.passengers);
        System.out.println("currentSpeed " + this.currentSpeed);
        for (int i = 0; i < this.wheels.length; i++) {
            System.out.print("Wheel " + (i+1) + " status wear: ");this.wheels[i].showStatus();
        }
        for (int i = 0; i < this.doors.length; i++) {
            System.out.print("Door " + (i+1) + " status: ");this.doors[i].showStatus();
        }
        System.out.println(maxSpeedCalculation());
    }
    public void switchTyre(int tyreNumber) {
        this.wheels[tyreNumber].switchTyre();
    }
    public void burnTyre(int tyreNumber, int percent) {
        this.wheels[tyreNumber].burnTyre(percent);
    }
    public void showTyreStatus() {
        for (int j = 0; j < wheels.length; j++) {
            System.out.println("Состояние шины " + (j+1) + "равняется " + this.wheels[j].getTyreWear() + " %.");
        }
    }
    public void showTyreStatus(int i) {
        this.wheels[i].showStatus();
    }
    public void openDoor(int i) {
        this.doors[i].openDoor();
    }
    public void closeDoor(int i) {
        this.doors[i].closeDoor();
    }
    public void switchDoor(int i) {
        this.doors[i].switchDoor();
    }
    public void openWindow(int i) {
        this.doors[i].openWindow();
    }
    public void closeWindow(int i) {
        this.doors[i].closeWindow();
    }
    public void switchWindow(int i) {
        this.doors[i].switchWindow();
    }
    public void showDoorStatus(int i) {
        System.out.print("Door " + i + " status ");
        this.doors[i].showStatus();
    }

}
