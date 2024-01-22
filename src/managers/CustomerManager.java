/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Customer;
import entity.Medicine;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    private final Scanner scanner;

    public CustomerManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer addCustomer() {
        System.out.println("----- Add customer -----");
        System.out.print("Firstname: ");
        String firstName = scanner.nextLine();

        System.out.print("Lastname: ");
        String lastName = scanner.nextLine();

        System.out.print("Phone: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(firstName, lastName, phoneNumber);
        System.out.println("New customer added!");
        return customer;
    }

    public void printListCustomers(List<Customer> customers) {
        System.out.println("----- List customers -----");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.printf("%d. %s %s. (%s)%n",
                    i + 1,
                    customer.getFirstname(),
                    customer.getLastname(),
                    customer.getPhoneNumber()
            );
        }
    }


    public void editCustomer(List<Customer> customers) {
        System.out.println("----- Edit customer -----");
        printListCustomers(customers);

        System.out.print("Enter the number of the customer to edit: ");
        int customerIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Invalid customer selection.");
            return;
        }

        Customer customer = customers.get(customerIndex);

        System.out.print("New Firstname: ");
        String newFirstname = scanner.nextLine().trim();
        if (!newFirstname.isEmpty()) {
            customer.setFirstname(newFirstname);
        }

        System.out.print("New Lastname: ");
        String newLastname = scanner.nextLine().trim();
        if (!newLastname.isEmpty()) {
            customer.setLastname(newLastname);
        }

        System.out.print("New Phone: ");
        String newPhone = scanner.nextLine().trim();
        if (!newPhone.isEmpty()) {
            customer.setPhoneNumber(newPhone);
        }

        System.out.println("Customer updated!");
    }
    
}
