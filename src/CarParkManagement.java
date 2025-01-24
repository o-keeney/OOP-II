import Models.Car;
import Models.Motorcycle;
import Models.Vehicle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarParkManagement
{
    private static final List<Vehicle> parkingLot = new CopyOnWriteArrayList<>();
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException
    {

    }

    private static void displayMenu() throws IOException, InterruptedException, ExecutionException
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("\nCar Park Management System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. List All Vehicles");
            System.out.println("3. Find Vehicle By Registration");
            System.out.println("4. Remove Vehicle By Registration");
            System.out.println("5. Analyse Parking Lot");
            System.out.println("6. Export Data to File");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1 -> addVehicle(scanner);
                //case 2 -> listVehicles();
                //case 3 -> findVehicle();
                //case 4 -> removeVehicle();
                //case 5 -> analyseParkingLot();
                //case 6 -> exportData();
                case 7 ->
                {
                    executor.shutdown();
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }

    private static void addVehicle(Scanner scanner)
    {
        System.out.println("Enter vehicle type (car/motorcycle): ");
        String type = scanner.nextLine().toLowerCase();

        System.out.println("Enter registration number: ");
        String registration = scanner.nextLine();

        System.out.println("Enter owner name: ");
        String owner = scanner.nextLine();

        Vehicle vehicle = switch (type) {
            case "car" -> new Car(registration, owner, LocalDateTime.now());
            case "motorcycle" -> new Motorcycle(registration, owner, LocalDateTime.now());
            default -> throw new IllegalArgumentException("Invalid vehicle type...");
        };

        parkingLot.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

}
