/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private double balance;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
     public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Added " + amount + " to the balance. New balance: " + balance);
        } else {
            System.out.println("Invalid amount. The amount should be greater than 0.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.firstname);
        hash = 89 * hash + Objects.hashCode(this.lastname);
        hash = 89 * hash + Objects.hashCode(this.phoneNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return Objects.equals(this.firstname, other.firstname)
                && Objects.equals(this.lastname, other.lastname)
                && Objects.equals(this.phoneNumber, other.phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}