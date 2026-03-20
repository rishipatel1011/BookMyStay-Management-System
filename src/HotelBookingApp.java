public static void main(String[] args) {
    System.out.println("--- Welcome to BookMyStay App ---");

    // FIX: Initialize the object here
    Room room1 = new Room(101, "Deluxe");

    System.out.println("System Check: Initializing Room Data...");
    System.out.println(room1); // This will now work!
}