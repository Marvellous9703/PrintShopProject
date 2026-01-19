package printshop.model;

public class Operator extends Employee {

    public Operator(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary(double revenue) {
        return getBaseSalary();
    }
}
