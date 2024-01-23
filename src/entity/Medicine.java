/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Medicine implements Serializable {
    private String name;
    private double price;
    private int quantity;
    private int stock;
    private Medicine medicine;
    private double salesRating;

    public Medicine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getStock() {
        return stock;
    }
    public void setStock(int i) {
        this.stock = stock;
    }
    
    public Medicine getMedicine() {
    return medicine;
    }
    
    public double getSalesRating() {
        return salesRating;
    }

    public void setSalesRating(double salesRating) {
        this.salesRating = salesRating;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 37 * hash + this.quantity;
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
        Medicine medicine = (Medicine) obj;
        return Double.compare(medicine.price, price) == 0
                && quantity == medicine.quantity
                && Objects.equals(name, medicine.name);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
