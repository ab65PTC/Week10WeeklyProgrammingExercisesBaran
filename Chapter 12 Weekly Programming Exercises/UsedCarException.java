public class UsedCarException extends Exception {
    public UsedCarException(String vin) {
        super("Invalid VIN: " + vin);
    }
}
