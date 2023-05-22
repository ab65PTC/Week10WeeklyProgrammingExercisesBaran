import java.util.Scanner;

public class DemoPhoneCalls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PhoneCall call;

        while (true) {
            System.out.print("Enter type of call (I for incoming, O for outgoing, or Q to quit): ");
            String type = input.next().toUpperCase();
            if (type.equals("Q")) {
                break;
            } else if (type.equals("I")) {
                System.out.print("Enter phone number: ");
                String number = input.next();
                call = new IncomingPhoneCall(number);
            } else if (type.equals("O")) {
                System.out.print("Enter phone number: ");
                String number = input.next();
                System.out.print("Enter call duration (in minutes): ");
                int minutes = input.nextInt();
                call = new OutgoingPhoneCall(number, minutes);
            } else {
                System.out.println("Invalid input.");
                continue;
            }

            System.out.println("Phone call information:");
            System.out.println("Phone number: " + call.getPhoneNumber());
            System.out.println("Price: $" + call.getPrice());
            call.displayCallInformation();
        }

        System.out.println("Program terminated.");
    }
}
