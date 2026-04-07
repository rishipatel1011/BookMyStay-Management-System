import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingApp {
    private static final String FILE_NAME = "inventory.dat";

    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App [Persistence Mode] ---");

        List<Room> roomInventory;

        // 1. Attempt to Recovery Data from File
        roomInventory = loadData();

        // 2. If no data exists, initialize fresh data
        if (roomInventory.isEmpty()) {
            System.out.println("No saved state found. Initializing fresh inventory...");
            roomInventory.add(new Room(101, "Standard"));
            roomInventory.add(new Room(201, "Deluxe"));
            roomInventory.get(0).setAvailable(false); // Manually occupy one for testing
        } else {
            System.out.println("System Recovery Successful!");
        }

        // 3. Display Current State
        System.out.println("\n--- Current Room Inventory ---");
        for (Room r : roomInventory) System.out.println(r);

        // 4. Save State before Exit
        saveData(roomInventory);
        System.out.println("\nSystem state persisted to " + FILE_NAME + ". exiting...");
    }

    private static void saveData(List<Room> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Room> loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Room>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Recovery failed: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}