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
    private Object customers;

    public List<Medicine> loadMedicines() {
    List<Medicine> medicines = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MEDICINE_FILENAME))) {
        medicines = (List<Medicine>) ois.readObject();
    } catch (FileNotFoundException ex) {
        System.out.printf("File \"%s\" not found!%n", MEDICINE_FILENAME);
    } catch (IOException | ClassNotFoundException ex) {
        System.out.println("Error reading medicines!");
        logException(ex);
    }
    return medicines != null ? medicines : new ArrayList<>();
    }
    
    public void saveMedicines(List<Medicine> medicines) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MEDICINE_FILENAME))) {
        oos.writeObject(medicines);
        oos.flush();
    } catch (IOException ex) {
        System.out.println("Error saving medicines!");
        logException(ex);
        }
    }

    private void logException(Exception ex) {
        System.err.println("Exception details:");
        ex.printStackTrace();
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
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SALES_FILENAME))) {
        sales = (List<Sale>) ois.readObject();
    } catch (FileNotFoundException ex) {
        System.out.printf("File \"%s\" not found!%n", SALES_FILENAME);
    } catch (IOException | ClassNotFoundException ex) {
        System.out.println("Error reading sales!");
        ex.printStackTrace();
    }
    return sales;
    }
    public void saveSales(List<Sale> sales) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SALES_FILENAME))) {
        oos.writeObject(sales);
        oos.flush();
    } catch (IOException ex) {
        System.out.println("Error saving sales!");
        ex.printStackTrace(); 
    }
    }
}

