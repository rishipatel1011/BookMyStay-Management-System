import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * UC10: Booking Cancellation & Inventory Rollback
 * Concept: Stack Data Structure (LIFO) for undoing operations.
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App ---");

        List<Room> roomInventory = new ArrayList<>();
        roomInventory.add(new Room(101, "Standard"));
        roomInventory.add(new Room(102, "Standard"));
        roomInventory.add(new Room(201, "Deluxe"));

        // Stack to keep track of booking history for rollback
        Stack<Integer> bookingRollbackStack = new Stack<>();

        // 1. Simulate a series of bookings
        System.out.println("\n--- Processing Bookings ---");
        int[] roomsToBook = {101, 102, 201};

        for (int roomNum : roomsToBook) {
            for (Room r : roomInventory) {
                if (r.getRoomNumber() == roomNum && r.isAvailable()) {
                    r.setAvailable(false);
                    bookingRollbackStack.push(roomNum); // Record for rollback
                    System.out.println("Booked: Room " + roomNum);
                }
            }
        }

        // 2. UC10: Rollback Logic (Undo the last booking)
        System.out.println("\n--- Initiating Cancellation Rollback (LIFO) ---");
        if (!bookingRollbackStack.isEmpty()) {
            int lastBookedRoom = bookingRollbackStack.pop();
            System.out.println("Rolling back last transaction: Room " + lastBookedRoom);

            for (Room r : roomInventory) {
                if (r.getRoomNumber() == lastBookedRoom) {
                    r.setAvailable(true); // Restore inventory
                    System.out.println("Status: Room " + lastBookedRoom + " is now Available again.");
                }
            }
        }

        // Final Inventory Check
        System.out.println("\n--- Final System State ---");
        for (Room r : roomInventory) {
            System.out.println(r);
        }
    }
}