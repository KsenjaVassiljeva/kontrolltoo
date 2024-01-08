/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;


import entity.Medicine;
import entity.Sale;
import entity.Customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    private final String MEDICINE_FILENAME = "medicines";
    private final String CUSTOMER_FILENAME = "customers";
    private final String SALES_FILENAME = "sales";

    public List<Medicine> loadMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(MEDICINE_FILENAME);
            ois = new ObjectInputStream(fis);
            medicines = (List<Medicine>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", MEDICINE_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n", MEDICINE_FILENAME);
        }
        return medicines;
    }

    public void saveMedicines(List<Medicine> medicines) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(MEDICINE_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(medicines);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", MEDICINE_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }

    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(CUSTOMER_FILENAME);
            ois = new ObjectInputStream(fis);
            customers = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", CUSTOMER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n", CUSTOMER_FILENAME);
        }
        return customers;
    }

    public void saveCustomers(List<Customer> customers) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(CUSTOMER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", CUSTOMER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }

    public List<Sale> loadSales() {
        List<Sale> sales = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(SALES_FILENAME);
            ois = new ObjectInputStream(fis);
            sales = (List<Sale>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", SALES_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n", SALES_FILENAME);
        }
        return sales;
    }

    public void saveSales(List<Sale> sales) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(SALES_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sales);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", SALES_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }
}
