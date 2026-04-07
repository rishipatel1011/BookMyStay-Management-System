import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App ---");

        List<Room> roomInventory = new ArrayList<>();
        // Adding rooms in non-sequential order to test sorting
        roomInventory.add(new Room(301, "Suite"));
        roomInventory.add(new Room(101, "Standard"));
        roomInventory.add(new Room(201, "Deluxe"));
        roomInventory.add(new Room(102, "Standard"));

        System.out.println("\nInventory Before Sorting:");
        for (Room r : roomInventory) System.out.println(r);

        // UC7: Sorting Logic using Comparator
        roomInventory.sort(Comparator.comparingInt(Room::getRoomNumber));

        System.out.println("\nInventory After Sorting (By Room Number):");
        for (Room r : roomInventory) {
            System.out.println(r);
        }
    }
}