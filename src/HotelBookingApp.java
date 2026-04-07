import java.util.ArrayList;
import java.util.List;


public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App ---");

        // 1. Initialize the Room Inventory using ArrayList
        // This allows us to store multiple Room objects dynamically
        List<Room> roomInventory = new ArrayList<>();

        // 2. Add multiple Room objects to the inventory
        roomInventory.add(new Room(101, "Standard"));
        roomInventory.add(new Room(102, "Standard"));
        roomInventory.add(new Room(201, "Deluxe"));
        roomInventory.add(new Room(301, "Suite"));

        // 3. Display the total number of rooms registered
        System.out.println("System Update: Inventory Initialized.");
        System.out.println("Total Rooms in System: " + roomInventory.size());

        // 4. Iterate through the list to display all room details
        System.out.println("\n--- Current Room Inventory ---");
        for (Room room : roomInventory) {
            System.out.println(room);
        }
    }
}