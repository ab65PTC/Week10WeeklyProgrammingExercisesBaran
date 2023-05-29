public class UsedCar {
    private String vin;
    private String make;
    private int year;
    private int mileage;
    private double price;
    
    public UsedCar(String vin, String make, int year, int mileage, double price) throws UsedCarException {
        if (vin.length() != 4) {
            throw new UsedCarException(vin);
        }
        if (!make.equals("Ford") && !make.equals("Honda") && !make.equals("Toyota") && !make.equals("Chrysler") && !make.equals("Other")) {
            throw new UsedCarException(vin);
        }
        if (year < 1997 || year > 2024) {
            throw new UsedCarException(vin);
        }
        if (mileage < 0 || price < 0) {
            throw new UsedCarException(vin);
        }
        this.vin = vin;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    
    public UsedCar(int vin2, String make2, int year2, int mileage2, double price2) {
    }

    public String getVin() {
        return vin;
    }
    
    public String getMake() {
        return make;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getMileage() {
        return mileage;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return String.format("VIN: %s, Make: %s, Year: %d, Mileage: %d, Price: %.2f", vin, make, year, mileage, price);
    }
}
