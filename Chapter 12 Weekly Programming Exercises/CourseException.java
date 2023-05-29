public class CourseException extends Exception {
    public String department;
    public int courseNumber;
    public double credits;

    public CourseException(String department, int courseNumber, double credits) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
    }

    public CourseException(String string) {
    }

    public String toString() {
        return "Invalid course: " + department + " " + courseNumber + " (" + credits + " credits)";
    }
}
