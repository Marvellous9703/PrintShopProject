package printshop.model;

public class Manager extends Employee {
    private double bonusPercent;
    private double revenueThreshold;

    public Manager(String name, double baseSalary, double bonusPercent, double revenueThreshold) {
        super(name, baseSalary);
        this.bonusPercent = bonusPercent;
        this.revenueThreshold = revenueThreshold;
    }

    @Override
    public double calculateSalary(double revenue) {
        if (revenue > revenueThreshold) {
            return getBaseSalary() + getBaseSalary() * bonusPercent / 100;
        }
        return getBaseSalary();
    }
}
