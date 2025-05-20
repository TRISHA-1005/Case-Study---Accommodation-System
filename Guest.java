public class Guest {
    private String name;
    private int numberOfGuests;

    public Guest(String name, int numberOfGuests) {
        this.name = name;
        this.numberOfGuests = numberOfGuests;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
}
