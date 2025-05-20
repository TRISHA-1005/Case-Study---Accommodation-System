public class Reservation {
    private Guest guest;
    private String checkInDate;
    private int nights;
    private String accommodation;
    private double totalCost;

    public Reservation(Guest guest, String checkInDate, int nights, String accommodation) {
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.nights = nights;
        this.accommodation = accommodation;
    }

    public void computeTotalCost(double pricePerNight) {
        this.totalCost = nights * pricePerNight;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getAccommodation() {
        return accommodation;
    }
}
