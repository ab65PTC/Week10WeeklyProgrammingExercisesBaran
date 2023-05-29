public class Course {
    private String department;
    private int courseNumber;
    private double credits;

    public Course(String department, int courseNumber, double credits) throws CourseException {
        if (!department.matches("[a-zA-Z]{3}")) {
            throw new CourseException("Invalid department: " + department);
        }
        if (courseNumber < 100 || courseNumber > 499) {
            throw new CourseException("Invalid course number: " + courseNumber);
        }
        if (credits < 0.5 || credits > 6.0) {
            throw new CourseException("Invalid credits: " + credits);
        }
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
    }

    public Course() {
    }

    public String toString() {
        return department + " " + courseNumber + " (" + credits + " credits)";
    }
}
