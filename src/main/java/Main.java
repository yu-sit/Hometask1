import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

        Race race = new Race();

        System.out.println("Welcome to Le-Man 24");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <3; i++) {
            System.out.println("Enter the name of the vehicle # " + (i+1));
            String name = scanner.next();

            int maxSpeed;
            do {
                try {
                    System.out.println("Enter the max speed of the vehicle " + name + " (1 - 250 km/h)");
                    maxSpeed = scanner.nextInt();
                    if (maxSpeed <= 0 || maxSpeed > 0) {
                        System.out.println("The speed must be within 1 - 250 km/h range");
                    }
                } catch(InputMismatchException j) {
                    System.out.println("Error. Enter the correct speed within 1 - 250 km/h");
                    scanner.next();
                    maxSpeed = 0;
                }


            }
            while (maxSpeed <= 0 || maxSpeed > 250);

            Vehicle vehicle = new Vehicle(name, maxSpeed);
            race.determineTheChampion(vehicle);
        }

        Vehicle theChampion = race.announceTheChampion();
        System.out.println(" The Champion of Le-Man 24 is " + theChampion.getName());
    }
}

// ваш код начнется здесь
// вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

class Vehicle {

    private String name;
    private int maxSpeed;

    public Vehicle(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {

        return name;
    }

    public int getMaxSpeed() {

        return maxSpeed;
    }

}


class Race {
    public Vehicle theChampion;

    public Race() {
        this.theChampion = null;
    }

    public void determineTheChampion(Vehicle vehicle) {

        int theLongestDistance = vehicle.getMaxSpeed() * 24;
        System.out.println("Vehicle " + vehicle.getName() + " runs " + theLongestDistance + " km for 24 hours");
        if (theChampion == null || vehicle.getMaxSpeed() > theChampion.getMaxSpeed()) {

            theChampion = vehicle;

        }

    }

    public Vehicle announceTheChampion() {
        return theChampion;
    }
}

