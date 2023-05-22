import java.util.Scanner;

public class DemoBlankets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Blanket blanket = new Blanket();
        ElectricBlanket electricBlanket = new ElectricBlanket();

        System.out.println("Starting values for Blanket: " + blanket);
        while (true) {
            System.out.print("Enter a material for the Blanket or q to quit: ");
            String material = input.nextLine();
            if (material.equalsIgnoreCase("q")) {
                break;
            }
            blanket.setMaterial(material);
            System.out.println("Values for Blanket after changing material: " + blanket);

            System.out.print("Enter a size for the Blanket or q to quit: ");
            String size = input.nextLine();
            if (size.equalsIgnoreCase("q")) {
                break;
            }
            blanket.setSize(size);
            System.out.println("Values for Blanket after changing size: " + blanket);
        }

        System.out.println("Starting values for ElectricBlanket: " + electricBlanket);
        while (true) {
            System.out.print("Enter a material for the ElectricBlanket or q to quit: ");
            String material = input.nextLine();
            if (material.equalsIgnoreCase("q")) {
                break;
            }
            electricBlanket.setMaterial(material);
            System.out.println("Values for ElectricBlanket after changing material: " + electricBlanket);

            System.out.print("Enter a size for the ElectricBlanket or q to quit: ");
            String size = input.nextLine();
            if (size.equalsIgnoreCase("q")) {
                break;
            }
            electricBlanket.setSize(size);
            System.out.println("Values for ElectricBlanket after changing size: " + electricBlanket);

            System.out.print("Enter number of heat settings (1-5): ");
            int numHeatSettings = input.nextInt();
            input.nextLine(); // consume newline character
            electricBlanket.setHeatSettings(numHeatSettings);

            System.out.print("Does the ElectricBlanket have automatic shutoff feature? (y/n): ");
            String hasAutoShutoff = input.nextLine();
            if (hasAutoShutoff.equalsIgnoreCase("y")) {
                electricBlanket.setAutoShutoff(true);
            } else {
                electricBlanket.setAutoShutoff(false);
            }
            System.out.println("Values for ElectricBlanket after changing settings: " + electricBlanket);
        }
    }
}
