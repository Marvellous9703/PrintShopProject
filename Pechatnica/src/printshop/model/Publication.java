package printshop.model;

public class Publication {
    private String title;
    private int copies;
    private PaperSize size;
    private PaperType type;
    private double pricePerCopy;
    private boolean isColor;

    public Publication(String title, int copies, PaperSize size, PaperType type, double pricePerCopy, boolean isColor) {
        this.title = title;
        this.copies = copies;
        this.size = size;
        this.type = type;
        this.pricePerCopy = pricePerCopy;
        this.isColor = isColor;
    }

    public int getCopies() {
        return copies;
    }

    public PaperSize getSize() {
        return size;
    }

    public PaperType getType() {
        return type;
    }

    public double getPricePerCopy() {
        return pricePerCopy;
    }

    public boolean isColor() {
        return isColor;
    }

    public double getTotalRevenue() {
        return pricePerCopy * copies;
    }

    public PaperType getPaperType() {
        return type;
    }

    public PaperSize getPaperSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("Publication: %s | Copies: %d | Size: %s | Type: %s | Price: %.2f | Color: %s",
                title, copies, size, type, pricePerCopy, isColor ? "Yes" : "No");
    }
}
