package printshop;

import printshop.model.*;
import printshop.service.PrintShop;

public class Main {
    public static void main(String[] args) {
        // --- Test 1: Paper price calculation ---
        Paper paper1 = new Paper(PaperType.NORMAL, PaperSize.A5, 0.10);
        System.out.printf("Paper (A5 NORMAL): %.2f%n", paper1.calculatePrice()); // Expect: 0.10

        Paper paper2 = new Paper(PaperType.GLOSSY, PaperSize.A3, 0.10);
        System.out.printf("Paper (A3 GLOSSY): %.2f%n", paper2.calculatePrice()); // Expect: ~0.19

        // --- Test 2: Publication revenue ---
        Publication pub = new Publication("Java Basics", 500, PaperSize.A3, PaperType.GLOSSY, 2.50, true);
        System.out.println(pub);
        System.out.printf("Total revenue from publication: %.2f%n", pub.getTotalRevenue());

        // --- Test 3: Employee salary ---
        Employee op = new Operator("Ivan", 1200);
        Employee mgr = new Manager("Maria", 1500, 20, 5000);

        double currentRevenue = 6000;

        System.out.println("Operator salary: " + op.calculateSalary(currentRevenue)); // Expect: 1200
        System.out.println("Manager salary: " + mgr.calculateSalary(currentRevenue)); // Expect: 1800

        // --- Test 4: PrintMachine basic logic ---
        PrintMachine machine = new PrintMachine("M1", 1000, true, 25);
        machine.loadPaper(600);
        try {
            machine.print(pub);
            System.out.println("Printed successfully on machine.");
        } catch (Exception e) {
            System.out.println("Print error: " + e.getMessage());
        }

        System.out.printf("Pages printed on machine: %d%n", machine.getPrintedPages());

        // --- Test 5: Full PrintShop logic ---
        PrintShop shop = new PrintShop(0.10, 1000, 10.0);
        shop.addEmployee(op);
        shop.addEmployee(mgr);
        shop.addMachine(machine);

        // already printed pub above
        shop.addPublication(pub);

        System.out.printf("Total revenue: %.2f%n", shop.calculateTotalRevenue());
        System.out.printf("Total salaries: %.2f%n", shop.calculateTotalSalaries());
        System.out.printf("Paper costs: %.2f%n", shop.calculatePaperCosts());
        System.out.printf("Profit: %.2f%n", shop.calculateProfit());
    }
}
