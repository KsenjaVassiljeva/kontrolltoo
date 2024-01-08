/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Medicine;
import entity.Customer;
import entity.Sale;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import tools.InputProtection;

public class SaleManager {

    private final Scanner scanner;
    private final MedicineManager medicineManager;
    private final CustomerManager customerManager;

    public SaleManager(Scanner scanner, CustomerManager customerManager, MedicineManager medicineManager) {
        this.scanner = scanner;
        this.customerManager = customerManager;
        this.medicineManager = medicineManager;
    }

    public Sale makeSale(List<Medicine> medicines, List<Customer> customers) {
    Sale sale = new Sale();
    medicineManager.printListMedicines(medicines);
    System.out.print("Enter the number of the medicine to sell: ");
    int medicineNumber = InputProtection.intInput(1, medicines.size());
    Medicine selectedMedicine = medicines.get(medicineNumber - 1);

    customerManager.printListCustomers(customers);
    System.out.print("Enter the number of the customer: ");
    int customerNumber = InputProtection.intInput(1, customers.size());
    Customer selectedCustomer = customers.get(customerNumber - 1);

    sale.setMedicine(selectedMedicine);
    sale.setCustomer(selectedCustomer);

     System.out.print("Enter the number of units sold: ");
    int unitsSold = InputProtection.intInput(1, Integer.MAX_VALUE);
    sale.setUnitsSold(unitsSold);

    sale.setSaleDate(new GregorianCalendar().getTime());

    selectedMedicine.setStock(selectedMedicine.getStock() - unitsSold);

    return sale;
}


    public void printListSales(List<Sale> sales) {
        System.out.println("----- List sales -----");
        for (int i = 0; i < sales.size(); i++) {
            System.out.printf("%d. %s sold to %s %s on %s%n",
                    i + 1,
                    sales.get(i).getMedicine().getName(),
                    sales.get(i).getCustomer().getFirstname(),
                    sales.get(i).getCustomer().getLastname(),
                    sales.get(i).getSaleDate()
            );
        }
    }

    public void printTotalSalesByMedicine(List<Sale> sales) {
        Map<Medicine, Integer> totalSalesMap = new HashMap<>();
        for (Sale sale : sales) {
            if (totalSalesMap.containsKey(sale.getMedicine())) {
                totalSalesMap.put(sale.getMedicine(), totalSalesMap.get(sale.getMedicine()) + 1);
            } else {
                totalSalesMap.put(sale.getMedicine(), 1);
            }
        }

        Map<Medicine, Integer> sortedTotalSalesMap = totalSalesMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        int n = 1;
        for (Map.Entry<Medicine, Integer> entry : sortedTotalSalesMap.entrySet()) {
            System.out.printf("%d. %s: %d sales%n",
                    n,
                    entry.getKey().getName(),
                    entry.getValue()
            );
            n++;
        }
    }

    public void medicineRating(List<Sale> sales) {
    Map<Medicine, Integer> medicineRatingMap = new HashMap<>();

    for (Sale sale : sales) {
        Medicine medicine = sale.getMedicine();
        int unitsSold = sale.getUnitsSold();
        medicineRatingMap.put(medicine, medicineRatingMap.getOrDefault(medicine, 0) + unitsSold);
    }

    Map<Medicine, Integer> sortedMedicineRatingMap = medicineRatingMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
            ));

    int n = 1;
    for (Map.Entry<Medicine, Integer> entry : sortedMedicineRatingMap.entrySet()) {
        System.out.printf("%d. %s: %d sales%n",
                n,
                entry.getKey().getName(),
                entry.getValue()
        );
        n++;
    }
    }


    public Sale sellMedicine(List<Medicine> medicines, List<Customer> customers) {
    Sale sale = makeSale(medicines, customers);
    return sale;
    }


    public void printListSoldMedicines(List<Sale> sales) {
    System.out.println("----- List sold medicines -----");
    for (int i = 0; i < sales.size(); i++) {
        System.out.printf("%d. %s: %d units%n",
                i + 1,
                sales.get(i).getMedicine().getName(),
                sales.get(i).getUnitsSold()
        );
    }
}
    public void productSalesRating(List<Medicine> medicines, List<Sale> sales) {
        System.out.println("----- Product Sales Rating -----");
        medicineManager.printListMedicines(medicines);

        System.out.print("Enter the number of the medicine to view sales rating: ");
        int choice = InputProtection.intInput(1, medicines.size()) - 1;
        Medicine selectedMedicine = medicines.get(choice);

        double totalSales = 0;
        double totalRating = 0;

        for (Sale sale : sales) {
            if (sale.getMedicine().equals(selectedMedicine)) {
                totalSales += sale.getQuantity();
                totalRating += sale.getMedicine().getSalesRating() * sale.getQuantity();
            }
        }

        double averageRating = (totalSales > 0) ? totalRating / totalSales : 0;

        System.out.printf("Product: %s%nTotal Sales: %.2f%nAverage Sales Rating: %.2f%n",
                selectedMedicine.getName(), totalSales, averageRating);
    }


    public void returnMedicine(List<Sale> sales) {
        printListSoldMedicines(sales);
        System.out.print("Enter the number of the sold medicine to return: ");
        int medicineNumber = InputProtection.intInput(1, sales.size());
        System.out.print("Enter the number of units to return: ");
        int unitsToReturn = InputProtection.intInput(1, Integer.MAX_VALUE);
        Sale sale = sales.get(medicineNumber - 1);
        sale.getMedicine().setStock(sale.getMedicine().getStock() + unitsToReturn);
    }
}
