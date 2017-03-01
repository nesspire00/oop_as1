package w17oopassignment1;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mykyta on 2/19/17.
 */
public class Person {

    private String firstName, lastName, streetAddress, city, province, postalCode;
    private LocalDate birthday;

    /**
     * The Constructor for Person object.
     */
    public Person(String firstName, String lastName, String streetAddress, String city, String province, String postalCode, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        setPostalCode(postalCode);
        this.birthday = birthday;
    }

    /**
     * Validates the inputted postal code to be 6 chars long
     * and also be in the LETTER-NUMBER-LETTER NUMBER-LETTER-NUMBER format.
     *
     * @param postalCode the postal code passed down to the constructor.
     */
    public void setPostalCode(String postalCode) {

        if (postalCode.length() == 6) {

            Pattern pattern = Pattern.compile("^[(a-z)](\\d)[(a-z)](\\d)[(a-z)](\\d)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(postalCode);

            if (matcher.find()) {
                this.postalCode = postalCode.toUpperCase();
            } else {
                throw new IllegalArgumentException("Postal code format incorrect!");
            }
        } else
            throw new IllegalArgumentException("Postal code should be 6 chars long");
    }

    /**
     * Takes the birthdate and gets the year.
     *
     * @return the year of birth
     */
    public int getYearBorn() {
        return birthday.getYear();
    }

    /**
     * An extremely complex and weird way to find out the exact age of the person.
     *
     * @return how old the person in question is
     */
    public int getAge() {
        return (int) ((LocalDate.now().toEpochDay() - birthday.toEpochDay()) / 365);
    }

    /**
     * Takes the address and puts it in a nice human-friendly form.
     *
     * @return persons address
     */
    public String getFullAddress() {
        return streetAddress + ", " + city + ", " + province + ", " + postalCode;
    }

    /**
     * Allows to change the persons address.
     *
     * @param street     new street
     * @param city       new city
     * @param province   new province
     * @param postalCode new postal code (gets revalidated)
     */
    public void changeAddress(String street, String city, String province, String postalCode) {
        this.streetAddress = street;
        this.city = city;
        this.province = province;
        setPostalCode(postalCode);
    }

    /**
     * An override of default toString() method. Shows the object as the name of the Person
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * Getters and Setters for each of the instance variables.
     * Courteously provided by the IDE (Yay!).
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}