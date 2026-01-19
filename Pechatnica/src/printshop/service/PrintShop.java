package printshop.service;

import printshop.model.*;

import java.util.ArrayList;
import java.util.List;

public class PrintShop {
    private List<Employee> employees;
    private List<PrintMachine> machines;
    private List<Publication> publications;

    private double basePaperPriceA5;
    private int discountThreshold; // брой копия
    private double discountPercent;

    public PrintShop(double basePaperPriceA5, int discountThreshold, double discountPercent) {
        this.employees = new ArrayList<>();
        this.machines = new ArrayList<>();
        this.publications = new ArrayList<>();
        this.basePaperPriceA5 = basePaperPriceA5;
        this.discountThreshold = discountThreshold;
        this.discountPercent = discountPercent;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void addMachine(PrintMachine m) {
        machines.add(m);
    }

    public void addPublication(Publication p) {
        publications.add(p);
    }

    public void printPublication(String machineId, Publication pub) throws Exception {
        PrintMachine machine = findMachine(machineId);
        if (machine == null) {
            throw new Exception("Машината не е намерена!");
        }
        machine.print(pub);
        publications.add(pub);
    }

    public PrintMachine findMachine(String id) {
        for (PrintMachine m : machines) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    public double calculateTotalRevenue() {
        double total = 0;
        for (Publication p : publications) {
            double pricePerCopy = p.getPricePerCopy();
            if (p.getCopies() > discountThreshold) {
                pricePerCopy -= pricePerCopy * (discountPercent / 100.0);
            }
            total += pricePerCopy * p.getCopies();
        }
        return total;
    }

    public double calculateTotalSalaries() {
        double totalRevenue = calculateTotalRevenue();
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary(totalRevenue);
        }
        return total;
    }

    public double calculatePaperCosts() {
        double total = 0;
        for (Publication p : publications) {
            Paper paper = new Paper(p.getPaperType(), p.getPaperSize(), basePaperPriceA5);
            total += p.getCopies() * paper.calculatePrice();
        }
        return total;
    }

    public double calculateTotalExpenses() {
        return calculateTotalSalaries() + calculatePaperCosts();
    }

    public double calculateProfit() {
        return calculateTotalRevenue() - calculateTotalExpenses();
    }
}
