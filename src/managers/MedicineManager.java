package managers;

import entity.Medicine;
import entity.Manufacturer;
import entity.Sale;
import java.util.List;
import java.util.Scanner;
import tools.InputProtection;



public class MedicineManager {

    private final Scanner scanner;

    public MedicineManager(Scanner scanner) {
        this.scanner = scanner;
    }
    
    private static final String CURRENCY_SYMBOL = "€";

    public Medicine addMedicine() {
    System.out.println("----- Add Medicine -----");
    Medicine medicine = new Medicine();
    System.out.print("Enter name: ");
    medicine.setName(scanner.nextLine());
    System.out.print("Enter price in " + CURRENCY_SYMBOL + ": ");
    medicine.setPrice(InputProtection.doubleInput(0.01, Double.MAX_VALUE));
    System.out.print("Enter quantity: ");
    medicine.setQuantity(InputProtection.intInput(0, Integer.MAX_VALUE));
    System.out.print("Enter manufacturer: ");
    String manufacturerName = scanner.nextLine();
    medicine.setManufacturer(new Manufacturer(manufacturerName));
    
    return medicine;
   
}
    public void printListMedicines(List<Medicine> medicines) {
    System.out.println("----- List Medicines -----");
    for (int i = 0; i < medicines.size(); i++) {
        System.out.printf("%d. %s - Price: %s%.2f%n",
                i + 1,
                medicines.get(i).getName(),
                CURRENCY_SYMBOL,
                medicines.get(i).getPrice()
        );
    }
}
    public void setSalesRating(Medicine medicine, double rating) {
        medicine.setSalesRating(rating);
        System.out.println("Sales rating set successfully for " + medicine.getName() + ": " + rating);
    }

    public void editMedicine(List<Medicine> medicines) {
    System.out.println("----- Edit Medicine -----");
    printListMedicines(medicines);

    System.out.print("Enter the number of the medicine to edit: ");
    int choice = InputProtection.intInput(1, medicines.size()) - 1;
    Medicine medicineToEdit = medicines.get(choice);

    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    if (!newName.isEmpty()) {
        medicineToEdit.setName(newName);
    }

    System.out.print("Enter new price: ");
    double newPrice = InputProtection.doubleInput(-1, Double.MAX_VALUE);
    if (newPrice >= 0) {
        medicineToEdit.setPrice(newPrice);
    }

    System.out.print("Enter new quantity: ");
    int newQuantity = InputProtection.intInput(-1, Integer.MAX_VALUE);
    if (newQuantity >= 0) {
        medicineToEdit.setQuantity(newQuantity);
    }

    System.out.print("Enter new manufacturer: ");
    String newManufacturer = scanner.nextLine();
    if (!newManufacturer.isEmpty()) {
        medicineToEdit.setManufacturer(new Manufacturer(newManufacturer));
    }

    System.out.println("Medicine edited successfully: " + medicineToEdit.toString());
    printListMedicines(medicines);
    }
}