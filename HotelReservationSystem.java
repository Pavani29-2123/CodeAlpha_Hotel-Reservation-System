import java.util.ArrayList;
import java.util.Scanner;

class Room {

    private int roomNumber;
    private String category;
    private double price;
    private boolean booked;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.booked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void bookRoom() {
        booked = true;
    }

    public void cancelRoom() {
        booked = false;
    }
}

class Hotel {

    private ArrayList<Room> rooms = new ArrayList<>();

    public Hotel() {
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));
        rooms.add(new Room(301, "Suite", 5000));
    }

    public void showAvailableRooms() {

        System.out.println("\nAvailable Rooms");

        for (Room room : rooms) {

            if (!room.isBooked()) {

                System.out.println(
                        room.getRoomNumber() +
                        " | " +
                        room.getCategory() +
                        " | ₹" +
                        room.getPrice());

            }
        }
    }

    public Room findRoom(int number) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == number)
                return room;

        }

        return null;
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        int choice;

        do {

            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    hotel.showAvailableRooms();
                    break;

                case 2:

                    hotel.showAvailableRooms();

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    Room room = hotel.findRoom(roomNo);

                    if (room != null && !room.isBooked()) {

                        System.out.print("Enter Customer Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();

                        System.out.println("Payment Successful!");
                        room.bookRoom();

                        System.out.println("Booking Confirmed for " + name);

                    } else {

                        System.out.println("Room Not Available.");

                    }

                    break;

                case 3:

                    System.out.print("Enter Room Number: ");
                    int cancelRoom = sc.nextInt();

                    Room cancel = hotel.findRoom(cancelRoom);

                    if (cancel != null && cancel.isBooked()) {

                        cancel.cancelRoom();

                        System.out.println("Booking Cancelled.");

                    } else {

                        System.out.println("Invalid Room Number.");

                    }

                    break;

                case 4:

                    System.out.println("\nBooked Rooms");

                    boolean found = false;

                    for (int i = 101; i <= 301; i++) {

                        Room r = hotel.findRoom(i);

                        if (r != null && r.isBooked()) {

                            System.out.println(
                                    "Room " +
                                    r.getRoomNumber() +
                                    " (" +
                                    r.getCategory() +
                                    ")");

                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("No Bookings.");

                    break;

                case 5:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}