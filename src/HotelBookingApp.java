public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Book My Stay App ---");

        // UC1: Manual Verification
        Room room1 = new Room(101, "Deluxe");

        System.out.println("System Check: Initializing Room Data...");
        System.out.println(room1);
    }
}