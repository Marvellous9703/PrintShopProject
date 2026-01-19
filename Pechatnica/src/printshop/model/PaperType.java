package printshop.model;

public enum PaperType {
    NORMAL(1.0),
    GLOSSY(1.3),
    NEWSPAPER(0.8);

    private final double multiplier;

    PaperType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}

