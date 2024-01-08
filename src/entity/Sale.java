/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Sale implements Serializable {
    private Medicine medicine;
    private Customer customer;
    private Date saleDate;
    private int unitsSold;
    private int quantity;

    public Sale() {
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.medicine);
        hash = 83 * hash + Objects.hashCode(this.customer);
        hash = 83 * hash + Objects.hashCode(this.saleDate);
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
        Sale other = (Sale) obj;
        return Objects.equals(this.medicine, other.medicine)
                && Objects.equals(this.customer, other.customer)
                && Objects.equals(this.saleDate, other.saleDate);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        return "Sale{" +
                "medicine=" + medicine.getName() +
                ", customer=" + customer.getFirstname() + " " + customer.getLastname() +
                ", saleDate=" + sdf.format(saleDate) +
                '}';
    }
    
}
