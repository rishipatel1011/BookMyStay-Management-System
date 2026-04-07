
public class Room {
    private int roomNumber;
    private String category;
    private boolean isAvailable;

    // Constructor to initialize a new room
    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true; // By default, rooms are ready for guests
    }

    // Accessor Methods (Getters)
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Mutator Method (Setter)
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Overriding toString to provide a readable description of the room
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Occupied";
        return "Room #" + roomNumber + " [" + category + "] - Status: " + status;
    }
}