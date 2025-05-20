public class Payment {
    private double amountPaid;
    private double totalAmount;

    public Payment(double amountPaid, double totalAmount) {
        this.amountPaid = amountPaid;
        this.totalAmount = totalAmount;
    }

    public boolean isFullPayment() {
        return amountPaid >= totalAmount;
    }

    public double getChange() {
        return amountPaid - totalAmount;
    }
}
