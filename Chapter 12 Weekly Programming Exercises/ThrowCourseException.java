import java.util.Scanner;

public class ThrowCourseException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] departments = new String[6];
        int[] courseNumbers = new int[6];
        double[] credits = new double[6];
        
        // prompt user for values for each field
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter department name: ");
            departments[i] = input.nextLine();
            
            boolean validCourseNum = false;
            while (!validCourseNum) {
                try {
                    System.out.print("Enter course number: ");
                    courseNumbers[i] = Integer.parseInt(input.nextLine());
                    if (courseNumbers[i] < 100 || courseNumbers[i] > 499) {
                        throw new CourseException("Course number must be between 100 and 499");
                    }
                    validCourseNum = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                } catch (CourseException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            boolean validCredits = false;
            while (!validCredits) {
                try {
                    System.out.print("Enter credits: ");
                    credits[i] = Double.parseDouble(input.nextLine());
                    if (credits[i] < 0.5 || credits[i] > 6.0) {
                        throw new CourseException("Credits must be between 0.5 and 6.0");
                    }
                    validCredits = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                } catch (CourseException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
        Course[] courses = new Course[6];
        
        // try to construct Course objects, catch CourseException if thrown
        for (int i = 0; i < 6; i++) {
            try {
                courses[i] = new Course(departments[i], courseNumbers[i], credits[i]);
            } catch (CourseException e) {
                courses[i] = new Course();
                System.out.println(e.getMessage());
            }
        }
        
        // display all stored Course values
        for (int i = 0; i < 6; i++) {
            System.out.println(courses[i].toString());
        }
    }
}
