package sptv22pharmatseft;

import managers.SaveManager;
import managers.SaleManager;
import managers.CustomerManager;
import managers.MedicineManager;
import entity.Medicine;
import entity.Sale;
import entity.Customer;
import java.util.List;
import java.util.Scanner;
import tools.InputProtection;

public class App {
    private final Scanner scanner; 
    private List<Medicine> medicines;
    private List<Customer> customers;
    private List<Sale> sales;
    private final MedicineManager medicineManager;
    private final CustomerManager customerManager;
    private final SaleManager saleManager;
    private final SaveManager saveManager;

    public App() {
        this.scanner = new Scanner(System.in);
        this.saveManager = new SaveManager();
        this.medicines = saveManager.loadMedicines();
        this.customers = saveManager.loadCustomers();
        this.sales = saveManager.loadSales();
        this.medicineManager = new MedicineManager(scanner);
        this.customerManager = new CustomerManager(scanner);
        this.saleManager = new SaleManager(scanner, customerManager, medicineManager);
    }

    public void run() {
        boolean repeat = true;
        System.out.println("------- Pharmacy -------");
        do {
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new medicine");
            System.out.println("2. Print list medicines");
            System.out.println("3. Add new customer");
            System.out.println("4. Print list customers");
            System.out.println("5. Sell medicine");
            System.out.println("6. Print list sold medicines");
            System.out.println("7. Medicine rating");
            System.out.println("8. Editing a medicine");
            System.out.println("9. Editing a user");
            
            System.out.println("Invalid task number:");
            
            int task = InputProtection.intInput(0,10); 
            System.out.printf("You select task %d, for exit press \"0\", to continue press \"1\": ",task);
            int toContinue = InputProtection.intInput(0,1);
            if(toContinue == 0) continue;
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    this.medicines.add(medicineManager.addMedicine());
                    saveManager.saveMedicines(this.medicines);
                    break;
                case 2:
                    medicineManager.printListMedicines(medicines);
                    break;
                case 3:
                    this.customers.add(customerManager.addCustomer());
                    saveManager.saveCustomers(customers);
                    break;
                case 4:
                    customerManager.printListCustomers(customers);
                    break;
                case 5:
                    this.sales.add(saleManager.sellMedicine(medicines, customers));
                    saveManager.saveSales(sales);
                    break;
                case 6:
                    saleManager.printListSoldMedicines(sales);
                    break;
                case 7:
                    saleManager.medicineRating(this.sales);
                    break;
                case 8:
                    medicineManager.editMedicine(medicines);
                    saveManager.saveMedicines(medicines);
                    break;
                case 9:
                    customerManager.editCustomer(customers);
                    saveManager.saveCustomers(customers); // Обязательное чтобы сохранилось
                    break;
                default:
                    System.out.println("Invalid task number.Please select from the list of tasks.");
            }
            System.out.println("-----------------------");
        }
        while (repeat);
        System.out.println("Bye-bye!");
    }
}
