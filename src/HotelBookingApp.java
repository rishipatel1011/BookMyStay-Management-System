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

        // UC4: Booking Logic
        int targetRoom = 201;
        System.out.println("\nAttempting to book Room #" + targetRoom + "...");

        for (Room room : roomInventory) {
            if (room.getRoomNumber() == targetRoom) {
                if (room.isAvailable()) {
                    room.setAvailable(false);
                    System.out.println("Success: Room " + targetRoom + " has been booked.");
                } else {
                    System.out.println("Fail: Room " + targetRoom + " is already occupied.");
                }
            }
        }

        System.out.println("\n--- Final Status of Inventory ---");
        for (Room r : roomInventory) {
            System.out.println(r);
        }
    }
}