import java.util.ArrayList;
import java.util.List;

public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App ---");

        List<Room> roomInventory = new ArrayList<>();
        roomInventory.add(new Room(101, "Standard"));
        roomInventory.add(new Room(102, "Standard"));
        roomInventory.add(new Room(201, "Deluxe"));
        roomInventory.add(new Room(301, "Suite"));

        // Pre-condition: Occupy some rooms to test filtering
        roomInventory.get(0).setAvailable(false); // Room 101 occupied
        roomInventory.get(2).setAvailable(false); // Room 201 occupied

        // UC6: Capacity Check (Show only Available Rooms)
        System.out.println("\nChecking System Capacity...");
        int availableCount = 0;

        System.out.println("--- Available Rooms List ---");
        for (Room room : roomInventory) {
            if (room.isAvailable()) {
                System.out.println(room);
                availableCount++;
            }
        }

        System.out.println("\nSummary: " + availableCount + " out of " +
                roomInventory.size() + " rooms are currently available.");
    }
}