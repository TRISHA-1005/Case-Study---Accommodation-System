import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueReservation;

        do {
            System.out.println("Would you like to make a reservation? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Thank you. Goodbye!");
                break;
            }

            // Guest Info
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of guests: ");
            int guests = sc.nextInt(); sc.nextLine(); // consume newline

            Guest guest = new Guest(name, guests);

            // Reservation Info
            System.out.print("Enter check-in date (e.g., 2025-06-01): ");
            String checkInDate = sc.nextLine();

            System.out.print("Enter number of nights: ");
            int nights = sc.nextInt(); sc.nextLine();

            // Accommodation
            System.out.println("Available accommodations: Standard, Deluxe, Suite");
            System.out.print("Choose accommodation: ");
            String accommodation = sc.nextLine();

            // Simple availability check
            List<String> available = Arrays.asList("Standard", "Deluxe", "Suite");
            if (!available.contains(accommodation)) {
                System.out.println("Accommodation not available.");
                continue;
            }

            Reservation reservation = new Reservation(guest, checkInDate, nights, accommodation);
            double pricePerNight = accommodation.equals("Standard") ? 1000 :
                                   accommodation.equals("Deluxe") ? 2000 : 3000;

            reservation.computeTotalCost(pricePerNight);
            System.out.println("Total cost: PHP " + reservation.getTotalCost());

            // Payment
            System.out.print("Enter amount to pay: PHP ");
            double amountPaid = sc.nextDouble(); sc.nextLine();

            Payment payment = new Payment(amountPaid, reservation.getTotalCost());

            if (payment.isFullPayment()) {
                System.out.println("Payment accepted. Change: PHP " + payment.getChange());
                System.out.println("Reservation saved. Printing receipt...");
                System.out.println("Receipt: Guest " + guest.getName() + ", Total: PHP " + reservation.getTotalCost());
            } else {
                System.out.println("Insufficient payment. Reservation marked as pending.");
            }

            System.out.print("Would you like to make another reservation? (yes/no): ");
            continueReservation = sc.nextLine();

        } while (continueReservation.equalsIgnoreCase("yes"));

        sc.close();
        System.out.println("Transaction complete. Thank you!");
    }
}
