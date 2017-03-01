package w17oopassignment1;

import java.time.LocalDate;

/**
 * Created by Mykyta on 2/24/17.
 */
public class Student extends Person {

    private LocalDate enrollmentDate;
    private String major;
    private int studentNumber;
    private boolean isInGoodStanding = true;


    /**
     * The Constructor for Student object.
     */
    public Student(String firstName, String lastName, String streetAddress, String city, String province, String postalCode, LocalDate birthday, String major, int studentNumber, LocalDate enrollmentDate) {

        super(firstName, lastName, streetAddress, city, province, postalCode, birthday);

        this.enrollmentDate = enrollmentDate;
        setBirthday(birthday);
        setStudentNumber(studentNumber);
        this.major = major;
    }

    /**
     * Gets the year the student was enrolled
     * @return the year the student was enrolled
     */
    public int getYearEnrolled() {
        return enrollmentDate.getYear();
    }

    /**
     * Figures out how many years has student spent in college
     * @return the amount of years spent in college
     */
    public int getYearsAtCollege() {
        return (int) (LocalDate.now().toEpochDay() - enrollmentDate.toEpochDay()) / 365;
    }

    /**
     * Checks if the student is in good standing
     * @return whether the student is in good standing
     */
    public boolean inGoodStanding() {
        return isInGoodStanding;
    }

    /**
     * If the student was previously suspended, they can be reinstated.
     */
    public void reinstateStudent() {
        this.isInGoodStanding = true;
    }

    /**
     * An Override of setBirthday() method in Person class. Checks to see if the person is in range of 14-90 years old.
     * Throws exceptions if the condition is not met.
     * @param birthday
     */
    @Override
    public void setBirthday(LocalDate birthday) {
        if (((LocalDate.now().toEpochDay() - birthday.toEpochDay()) / 365) >= 14) {

            if (((LocalDate.now().toEpochDay() - birthday.toEpochDay()) / 365) <= 90) {
                super.setBirthday(birthday);
            } else {
                throw new IllegalArgumentException("Too old! Cant be no older than 90 years old");
            }

        } else {
            throw new IllegalArgumentException("Too young! Cant be younger than 14 years old");
        }
    }

    /**
     * Checks to see if the student number is not 0 or not negative. If everything is alright it sets the instance variable.
     * @param studentNumber
     */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber > 0)
            this.studentNumber = studentNumber;
        else
            throw new IllegalArgumentException("Cannot be negative or 0");
    }

    /**
     * Sets the good standing variable to false
     */
    public void suspendStudent() {
        this.isInGoodStanding = false;
    }

    /**
     * An Override of the toString() method from the Person class. Displays information about the student in the form of Name, Last name and student number.
     * @return description of the object in a string
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", student number is " + studentNumber;
    }


    /**
     * GETTERS / SETTERS (Autogenerated)
     */

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public boolean isInGoodStanding() {
        return isInGoodStanding;
    }

    public void setInGoodStanding(boolean inGoodStanding) {
        isInGoodStanding = inGoodStanding;
    }
}
