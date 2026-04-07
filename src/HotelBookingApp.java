import java.util.ArrayList;
import java.util.List;

/**
 * UC11: Concurrent Booking Simulation (Thread Safety)
 * Concept: Synchronization to prevent Race Conditions in multi-threaded environments.
 */
public class HotelBookingApp {
    private static List<Room> roomInventory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App [Multi-Threaded] ---");

        // Initialize Inventory
        roomInventory.add(new Room(101, "Standard"));
        roomInventory.add(new Room(102, "Standard"));

        // Simulate two guests trying to book the SAME room (101) at the same time
        Runnable guest1 = () -> bookRoom(101, "Guest A");
        Runnable guest2 = () -> bookRoom(101, "Guest B");

        Thread thread1 = new Thread(guest1);
        Thread thread2 = new Thread(guest2);

        System.out.println("Starting concurrent booking requests...");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Final System State ---");
        for (Room r : roomInventory) {
            System.out.println(r);
        }
    }

    /**
     * The 'synchronized' keyword ensures only one thread enters this block at a time.
     * This prevents "Double Booking" (Race Condition).
     */
    public static synchronized void bookRoom(int roomNumber, String guestName) {
        for (Room room : roomInventory) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isAvailable()) {
                    // Simulate processing time
                    try { Thread.sleep(100); } catch (InterruptedException e) {}

                    room.setAvailable(false);
                    System.out.println(guestName + " successfully booked Room " + roomNumber);
                } else {
                    System.out.println(guestName + " failed: Room " + roomNumber + " is already occupied.");
                }
            }
        }
    }
}