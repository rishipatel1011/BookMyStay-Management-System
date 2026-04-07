import java.util.ArrayList;
import java.util.List;

/**
 * UC2: Persistence Simulation
 * Concept: Maintaining a consistent state of data throughout the app lifecycle.
 */
public class HotelBookingApp {
    // Static list to simulate a database that persists while the app is running
    private static List<Room> roomDatabase = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App ---");

        // UC9: Initialize Persistence Store
        initializeDatabase();

        System.out.println("\nSystem Check: Loading Data from Persistence Store...");
        displayInventory();
    }

    private static void initializeDatabase() {
        roomDatabase.add(new Room(101, "Standard"));
        roomDatabase.add(new Room(102, "Standard"));
        roomDatabase.add(new Room(201, "Deluxe"));
        roomDatabase.add(new Room(301, "Suite"));
        System.out.println("Status: Data successfully persisted to local storage.");
    }

    private static void displayInventory() {
        System.out.println("--- Current System Inventory ---");
        for (Room room : roomDatabase) {
            System.out.println(room);
        }
    }
}