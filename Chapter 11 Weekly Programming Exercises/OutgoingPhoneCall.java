public class OutgoingPhoneCall extends PhoneCall {
    private final static double RATE = 0.04;
    private int minutes;

    public OutgoingPhoneCall(String phoneNumber, int minutes) {
        super(phoneNumber);
        this.minutes = minutes;
        super.setPrice(RATE * minutes);
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String getPhoneNumber() {
        return super.phoneNumber;
    }

    @Override
    public double getPrice() {
        return super.price;
    }

    @Override
    public void displayCallInformation() {
        System.out.println("Phone number: " + getPhoneNumber() +
                "\nRate per minute: " + RATE +
                "\nNumber of minutes: " + minutes +
                "\nTotal price: " + getPrice());
    }
}
