import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReservationSystemUI {
    private ReservationSystem reservationSystem = new ReservationSystem();
    private List<User> users = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    
    public ReservationSystemUI() {
        
        users.add(new User("user1", "123456"));
        users.add(new User("user2", "123123"));
    }

    public User authenticateUser() {
        
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void start() {
        User authenticatedUser = null;
        while (authenticatedUser == null) {
            authenticatedUser = authenticateUser();
            if (authenticatedUser == null) {
                System.out.println("Invalid User ID or Password. Please try again.");
            }
        }

        System.out.println("Welcome, " + authenticatedUser.getUserId() + "!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. View all reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Date: ");
                    String date = scanner.nextLine();
                    System.out.print("Number of guests: ");
                    int numberOfGuests = scanner.nextInt();
                    scanner.nextLine();

                    Reservation reservation = reservationSystem.makeReservation(name, date, numberOfGuests);
                    System.out.println("Reservation made with ID " + reservation.getId());
                    break;
                case 2:
                    System.out.println("Reservations:");
                    for (Reservation r : reservationSystem.getReservations()) {
                        System.out.println("Reservation ID => " + r.getId());
                        System.out.println("Name Of the customer => " + r.getName());
                        System.out.println("Number Of Guests => " + r.getNumberOfGuests());
                        System.out.println("Date =>  " + r.getDate());
                    }
                    break;
                case 3:
                    System.out.print("Reservation ID to cancel: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (reservationSystem.cancelReservation(id)) {
                        System.out.println("Reservation canceled");
                    } else {
                        System.out.println("Reservation not found");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        ReservationSystemUI obj = new ReservationSystemUI();
        obj.start();
    }
}
