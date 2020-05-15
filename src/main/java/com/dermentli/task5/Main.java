package com.dermentli.task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to car simulation, please enter car details.");
        System.out.println("Production year");
        String productionDate = scanner.next();
        System.out.println("Engine type");
        String engineType = scanner.next();
        System.out.println("Maximal speed");
        int maxSpeed = scanner.nextInt();
        System.out.println("Time to hundred");
        int toHundred = scanner.nextInt();
        System.out.println("Capacity");
        int capacity = scanner.nextInt();
        System.out.println("Number of passengers");
        int passengers = scanner.nextInt();
        System.out.println("Current speed");
        int currentSpeed = scanner.nextInt();
        Car userCar = new Car(productionDate, engineType, maxSpeed, toHundred, capacity, passengers, currentSpeed);
        String answer = "y";
        do {
            System.out.println("Please enter the necessary operations");
            userInterface(userCar);
            System.out.println("Press y if you would like to continue");
            answer = scanner.next();
        } while (answer.equals("y"));

    }

    public static void userInterface (Car someCar) {
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
            System.out.println("     11. Сменить шину по номеру на новую.");
            System.out.println("     12. Стереть шину на X%.");
            System.out.println("     13. Получить состояние шины.");
            System.out.println("     14. Вывести в консоль данные об объекте CarWheel.");
            System.out.println("     15. Открыть дверь.");
            System.out.println("     16. Закрыть дверь.");
            System.out.println("     17. Открыть/закрыть дверь.");
            System.out.println("     18. Открыть окно.");
            System.out.println("     19. Закрыть окно.");
            System.out.println("     20. Открыть/закрыть окно.");
            System.out.println("     21. Вывести в консоль данные об объекте CarDoor.");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 21);
        System.out.println();

        switch (choice) {
            case 1:
                System.out.println("Введите скорость авто");
                someCar.changeCurrentSpeed(scanner.nextInt());
                break;
            case 2:
                someCar.addPassenger();
                break;
            case 3:
                someCar.removePassenger();
                break;
            case 4:
                someCar.removeAllPassengers();
                break;
            case 5:
                System.out.println("Введите номер двери от 1 до 4");
                System.out.println(someCar.indexDoor(scanner.nextInt()));
                break;
            case 6:
                System.out.println("Введите номер колеса от 1 до 4");
                System.out.println(someCar.indexWheel(scanner.nextInt()));
                break;
            case 7:
                someCar.removeAllWheels();
                break;
            case 8:
                System.out.println("Введите кол-во колес для установки");
                someCar.addWheels(scanner.nextInt());
                break;
            case 9:
                someCar.maxSpeedCalculation();
                break;
            case 10:
                someCar.showCarData();
                break;
            case 11:
                System.out.println("Введите номер шины, которую сменить на новую");
                someCar.switchTyre((scanner.nextInt()-1));
                break;
            case 12:
                System.out.println("Введите номер шины которую следуюет стереть");
                int i = scanner.nextInt();
                System.out.println("Введите % на сколько ее стереть");
                int percent = scanner.nextInt();
                someCar.burnTyre(i, percent);
                break;
            case 13:
                System.out.println("Вывожу на экран состояние всех шин:");
                someCar.showTyreStatus();
                break;
            case 14:
                System.out.println("Введите номер шины по которой необходимо вывести данные.");
                someCar.showTyreStatus(scanner.nextInt());
                break;
            case 15:
                System.out.println("Введите номер двери, которую следует открыть");
                someCar.openDoor(scanner.nextInt());
                break;
            case 16:
                System.out.println("Введите номер двери, которую следует закрыть");
                someCar.closeDoor(scanner.nextInt());
                break;
            case 17:
                System.out.println("Введите номер двери, у которой необходимо изменить статус");
                someCar.switchDoor(scanner.nextInt());
                break;
            case 18:
                System.out.println("Введите номер двери, окно которой следует открыть");
                someCar.openWindow(scanner.nextInt());
                break;
            case 19:
                System.out.println("Введите номер двери, окно которой следует закрыть");
                someCar.closeWindow(scanner.nextInt());
                break;
            case 20:
                System.out.println("Введите номер двери, окно у которой необходимо изменить статус");
                someCar.switchWindow(scanner.nextInt());
                break;
            case 21:
                System.out.println("Введите номер двери, статус по которой вы хотите узнать");
                someCar.showDoorStatus(scanner.nextInt());
                break;
        }
    }

}
