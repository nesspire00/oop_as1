package w17oopassignment1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Mykyta on 2/24/17.
 */
public class Instructor extends Person {

    private int employeeNum;
    private LocalDate hireDate;
    private ArrayList<String> courses;

    /**
     * The Constructor for Instructor object.
     */

    public Instructor(String firstName, String lastName, String streetAddress, String city, String province, String postalCode,
                      LocalDate birthday, int employeeNum, LocalDate hireDate) {
        super(firstName, lastName, streetAddress, city, province, postalCode, birthday);

        this.employeeNum = employeeNum;
        this.hireDate = hireDate;
        this.courses = new ArrayList<>();
    }

    /**
     * Adds a course to the instructor`s list of courses they can teach
     * @param courseCode
     */
    public void addTeachableCourse(String courseCode) {
        courses.add(courseCode.toUpperCase());
    }

    /**
     * Checks if the instructor is able to teach a particular course. Looks through the list of teachable courses.
     * @param courseCode
     * @return whether the instructor can teach a particular course
     */
    public boolean canTeach(String courseCode) {
        if (courses.contains(courseCode.toUpperCase()))
            return true;
        else
            return false;
    }

    /**
     * Figures out how many years has the instructor spent in college
     * @return the amount of years spent in college
     */
    public int getYearsAtCollege() {
        return (int) (LocalDate.now().toEpochDay() - hireDate.toEpochDay()) / 365;
    }

    /**
     * Lists all courses the instructor can teach
     * @return string with subjects the instructor can teach
     */
    public String listOfSubjectsCertifiedToTeach() {
        StringBuilder sb = new StringBuilder();
        for (String course : courses) {
            sb.append(course + ", ");
        }
        return sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(" ") + 1).toString();
    }

    /**
     * Tests the inputted hired date and if it is in the future or more than 80 years old, throws exceptions
     * (In an extremely weird manner)
     * @param hireDate
     */
    public void setHireDate(LocalDate hireDate) {
        if (((LocalDate.now().toEpochDay() - hireDate.toEpochDay()) / 365) <= 80) {

            if (((LocalDate.now().toEpochDay() - hireDate.toEpochDay()) / 365) <= 0) {
                throw new IllegalArgumentException("Is negative");
            } else {
                this.hireDate = hireDate;
            }

        } else {
            throw new IllegalArgumentException("Too young");
        }
    }

    /**
     * An override of setBirthday() method in Person class. Checks if the instructor is in the range of 18-100 years old.
     * If the date doesnt match it throws an exception.
     * @param birthday
     */
    @Override
    public void setBirthday(LocalDate birthday) {
        if (((LocalDate.now().toEpochDay() - birthday.toEpochDay()) / 365) >= 18) {

            if (((LocalDate.now().toEpochDay() - birthday.toEpochDay()) / 365) <= 100) {
                super.setBirthday(birthday);
            } else {
                throw new IllegalArgumentException("Too old! Need to be less than 100 years old");
            }

        } else {
            throw new IllegalArgumentException("Too young! Need to be at least 18 years old");
        }
    }

    /**
     * An override of toString() method from the Person class. Displays info about instructor: Name, Last name and employee number
     * @return description of the object in a string
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + employeeNum;
    }

    /**
     * GETTERS AND SETTERS
     */

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public ArrayList<String> getTeachableCourses() {
        return courses;
    }

}
