public class IncomingPhoneCall extends PhoneCall {
    private final static double RATE = 0.02;

    public IncomingPhoneCall(String phoneNumber) {
        super(phoneNumber);
        super.setPrice(RATE);
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
                "\nRate: " + RATE +
                "\nPrice: " + getPrice());
    }
}
