package printshop.model;

public enum PaperSize {
    A5(1),
    A4(2),
    A3(3),
    A2(4),
    A1(5);

    private final int level;

    PaperSize(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
