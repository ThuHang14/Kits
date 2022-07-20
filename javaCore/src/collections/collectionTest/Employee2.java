/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.collectionTest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Hung
 */
public class Employee2 extends Object   {

    private String firstName;
    private String lastName;
    private Date joinDate;
    private String code;

    public Employee2(String firstName, String lastName, Date joinDate, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = joinDate;
        this.code = code;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return firstName + " " + lastName + " " + dateFormat.format(joinDate);
    }
    @Override
    public boolean equals(Object obj) {
        return ((Employee2)obj).firstName.equalsIgnoreCase(this.firstName);
    } 
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } 
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
