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

        // Pre-condition: Room 201 is currently occupied (from UC4)
        roomInventory.get(2).setAvailable(false);
        System.out.println("Initial State: Room 201 is Occupied.");

        // UC5: Cancellation Logic
        int cancelRoom = 201;
        System.out.println("\nProcessing Cancellation for Room #" + cancelRoom + "...");

        for (Room room : roomInventory) {
            if (room.getRoomNumber() == cancelRoom) {
                if (!room.isAvailable()) {
                    room.setAvailable(true); // Reset status to Available
                    System.out.println("Success: Cancellation processed. Room " + cancelRoom + " is now available.");
                } else {
                    System.out.println("Alert: Room " + cancelRoom + " was already available.");
                }
            }
        }

        // Verification
        System.out.println("\n--- Current Status of Inventory ---");
        for (Room r : roomInventory) {
            System.out.println(r);
        }
    }
}