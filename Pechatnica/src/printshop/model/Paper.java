package printshop.model;

public class Paper {
    private PaperType type;
    private PaperSize size;
    private double basePriceA5;

    public Paper(PaperType type, PaperSize size, double basePriceA5) {
        this.type = type;
        this.size = size;
        this.basePriceA5 = basePriceA5;
    }

    public double calculatePrice() {
        double price = basePriceA5;
        int sizeDiff = size.getLevel() - PaperSize.A5.getLevel();
        for (int i = 0; i < sizeDiff; i++) {
            price *= 1.2;
        }
        return price * type.getMultiplier();
    }
}
