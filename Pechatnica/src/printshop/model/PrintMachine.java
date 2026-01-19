package printshop.model;

import java.util.HashMap;
import java.util.Map;

public class PrintMachine {
    private String id;
    private int paperCapacity;
    private int currentPaper;
    private boolean isColor;
    private Map<Publication, Integer> printed = new HashMap<>();

    public PrintMachine(String id, int capacity, boolean isColor, int speed) {
        this.id = id;
        this.paperCapacity = capacity;
        this.isColor = isColor;
    }

    public void loadPaper(int sheets) {
        if (currentPaper + sheets > paperCapacity) {
            throw new IllegalArgumentException("Too much paper");
        }
        currentPaper += sheets;
    }

    public void print(Publication pub) throws Exception {
        if (pub.isColor() && !isColor) {
            throw new Exception("Machine does not support color printing.");
        }
        int pages = pub.getCopies(); // assuming 1 page per copy
        if (pages > currentPaper) {
            throw new Exception("Not enough paper.");
        }
        currentPaper -= pages;
        printed.put(pub, printed.getOrDefault(pub, 0) + pub.getCopies());
        
    }

    public int getPrintedPages() {
        return printed.values().stream().mapToInt(Integer::intValue).sum();
    }

    public String getId() {
        return id;
    }
}
