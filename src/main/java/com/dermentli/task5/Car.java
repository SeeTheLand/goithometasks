package com.dermentli.task5;

import java.util.Arrays;
import java.util.Scanner;

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

    public Car(String productionDate) {
        this.productionDate = productionDate;
    }

    public Car() {
        this.productionDate = null;
    }

    public Car(String productionDate, String engineType, int maxSpeed, int toHundred, int capacity, int passengers, int currentSpeed) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.toHundred = toHundred;
        this.capacity = capacity;
        this.passengers = passengers;
        this.currentSpeed = currentSpeed;
    }

    public void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Какое действие и с какими параметрами вы хотите выполнить:");
            System.out.println("     1. Изменить скорость автомобиля.");
            System.out.println("     2. Добавить 1 пассажира.");
            System.out.println("     3. Высадить пассажира.");
            System.out.println("     4. Высадить всех пассажиров.");
            System.out.println("     5. Получить дверь по индексу.");
            System.out.println("     6. Получить колесо по индексу.");
            System.out.println("     7. Снять все колеса с машины.");
            System.out.println("     8. Установить на машину X новых колес.");
            System.out.println("     9. Вычислить текущую возможную максимальную скорость.");
            System.out.println("     10. Вывести в консоль данные об объекте Car.");
            System.out.println("     11. Сменить шину на новую.");
            System.out.println("     12. Стереть шину на X%.");
            System.out.println("     13. Получить состояние шины.");
            System.out.println("     14. Вывести в консоль данные об объекте CarWheel.");
            System.out.println("     15. Открыть дверь.");
            System.out.println("     16. Закрыть дверь.");
            System.out.println("     17. Открыть/закрыть дверь.");
            System.out.println("     18. Открыть окно.");
            System.out.println("     19. Закрыть окно.");
            System.out.println("     20. Открыть/закрыть окно.");
            System.out.println("     21. Вывести в консоль данные об объекте.");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 21);
        System.out.println();

        switch (choice) {
            case 1:
                System.out.println("Введите скорость авто");
                this.changeCurrentSpeed(scanner.nextInt());
                break;
            case 2:
                this.addPassenger();
                break;
            case 3:
                this.removePassenger();
                break;
            case 4:
                this.removeAllPassengers();
                break;
            case 5:
                System.out.println("Введите номер двери от 1 до 4");
                System.out.println(this.indexDoor(scanner.nextInt()));
                break;
            case 6:
                System.out.println("Введите номер колеса от 1 до 4");
                System.out.println(this.indexWheel(scanner.nextInt()));
                break;
            case 7:
                this.removeAllWheels();
                break;
            case 8:
                System.out.println("Введите кол-во колес для установки");
                this.addWheels(scanner.nextInt());
                break;
            case 9:
                this.maxSpeedCalculation();
                break;
            case 10:
                this.showCarData();
                break;
            case 11:
                System.out.println("Введите номер шины, которую сменить на новую");
                this.wheels[(scanner.nextInt()-1)].switchTyre();
                break;
            case 12:
                System.out.println("Введите номер шины которую следуюет стереть");
                int i = scanner.nextInt();
                System.out.println("Введите % на сколько ее стереть");
                int percent = scanner.nextInt();
                this.wheels[i].burnTyre(percent);
                break;
            case 13:
                System.out.println("Вывожу на экран состояние всех шин:");
                for (int j = 0; j < wheels.length; j++) {
                    System.out.println("Состояние шины " + (j+1) + "равняется " + this.wheels[j].getTyreWear() + " %.");
                }
                break;
            case 14:
                System.out.println("Введите номер шины по которой необходимо вывести данные.");
                this.wheels[scanner.nextInt()].showStatus();
                break;
            case 15:
                System.out.println("Введите номер двери, которую следует открыть");
                this.doors[scanner.nextInt()].openDoor();
                break;
            case 16:
                System.out.println("Введите номер двери, которую следует закрыть");
                this.doors[scanner.nextInt()].closeDoor();
                break;
            case 17:
                System.out.println("Введите номер двери, у которой необходимо изменить статус");
                this.doors[scanner.nextInt()].switchDoor();
                break;
            case 18:
                System.out.println("Введите номер двери, окно которой следует открыть");
                this.doors[scanner.nextInt()].openWindow();
                break;
            case 19:
                System.out.println("Введите номер двери, окно которой следует закрыть");
                this.doors[scanner.nextInt()].closeWindow();
                break;
            case 20:
                System.out.println("Введите номер двери, окно у которой необходимо изменить статус");
                this.doors[scanner.nextInt()].switchWindow();
                break;
            case 21:
                System.out.println("Введите номер двери, статус по которой вы хотите узнать");
                this.doors[scanner.nextInt()].showStatus();
                break;
        }
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
        System.out.println(this.productionDate);
        System.out.println(this.engineType);
        System.out.println(this.maxSpeed);
        System.out.println(this.toHundred);
        System.out.println(this.capacity);
        System.out.println(this.passengers);
        System.out.println(this.currentSpeed);
        System.out.println(Arrays.toString(this.wheels));
        System.out.println(Arrays.toString(this.doors));
        System.out.println(maxSpeedCalculation());
    }




}
