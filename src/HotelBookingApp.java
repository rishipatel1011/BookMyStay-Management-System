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

        // UC8: Advanced Filtering - Show only Premium Rooms
        System.out.println("\n--- Filtering Premium Rooms ---");

        for (Room room : roomInventory) {
            // Check if category is either Deluxe or Suite
            if (room.getCategory().equalsIgnoreCase("Deluxe") ||
                    room.getCategory().equalsIgnoreCase("Suite")) {
                System.out.println("[PREMIUM] " + room);
            }
        }
    }
}