package ru.job4j.banktransfer;

/**
 * Class for creating users.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.01.2019
 * @version 1.0
 */
public class User implements Comparable<User> {

    /**
     * User's name.
     */
    private String name;

    /**
     * User's passport.
     */
    private String passport;

    /**
     * The constructor.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Returns user's name.
     * @return a name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns user's passport.
     * @return a passport
     */
    public String getPassport() {
        return this.passport;
    }

    /**
     * Overriding the "equals method" for User class.
     * @param anObject - a user to be compared
     * @return true - if users equal each other, false - otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        boolean result = false;
        if (anObject instanceof User) {
            User user = (User) anObject;
            if (this.getName().equals(user.getName()) && this.passport.equals(user.getPassport())) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Overriding the "hashCode method" for User class.
     * @return a hashCode
     */
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    /**
     * Overriding the "toString" method for User class.
     * @return String - user's information
     */
    @Override
    public String toString() {
        return "Name: " + this.getName() + " Passport: " + this.getPassport();
    }

    /**
     * Implementation of the compareTo method.
     * @param user - a user
     * @return the comparison result
     */
    public int compareTo(User user) {
        return this.getPassport().compareTo(user.getPassport());
    }
}