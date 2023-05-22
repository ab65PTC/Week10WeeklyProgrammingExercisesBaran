public class ElectricBlanket extends Blanket {
    private int heatSettings;
    private boolean hasAutoShutoff;

    public ElectricBlanket() {
        super(); // invoke the default constructor of parent class
        heatSettings = 1;
        hasAutoShutoff = false;
    }

    public int getHeatSettings() {
        return heatSettings;
    }

    public void setHeatSettings(int heatSettings) {
        if (heatSettings >= 1 && heatSettings <= 5) {
            this.heatSettings = heatSettings;
        } else {
            System.out.println("Invalid heat setting. Using default value of 1.");
        }
    }

    public boolean hasAutoShutoff() {
        return hasAutoShutoff;
    }

    public void setAutoShutoff(boolean hasAutoShutoff) {
        this.hasAutoShutoff = hasAutoShutoff;
    }

    @Override
    public double getPrice(double price) {
        price = super.getPrice(price); // invoke getPrice() method of parent class
        if (hasAutoShutoff) {
            price += 5.75;
        }
        return price;
    }

    @Override
    public String toString() {
        String desc = super.toString(); // invoke toString() method of parent class
        desc += "\nHeat Settings: " + heatSettings;
        desc += "\nAuto Shutoff: " + (hasAutoShutoff ? "Yes" : "No");
        return desc;
    }
}
