import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Necklace {
    private List<Gemstone> gemstones;

    public Necklace() {
        gemstones = new ArrayList<>();
    }

    public void addGemstone(Gemstone gemstone) {
        gemstones.add(gemstone);
    }

    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (Gemstone gemstone : gemstones) {
            totalWeight += gemstone.getWeight();
        }
        return totalWeight;
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Gemstone gemstone : gemstones) {
            totalCost += gemstone.calculateCost();
        }
        return totalCost;
    }

    public void sortGemstonesByValue() {
        Collections.sort(gemstones, (g1, g2) -> Double.compare(g2.getPrice(), g1.getPrice()));
    }

    public List<Gemstone> findGemstonesByTransparencyRange(double minTransparency, double maxTransparency) {
        List<Gemstone> result = new ArrayList<>();
        for (Gemstone gemstone : gemstones) {
            if (gemstone instanceof PreciousStone) {
                PreciousStone preciousStone = (PreciousStone) gemstone;
                if (preciousStone.getTransparency() >= minTransparency
                        && preciousStone.getTransparency() <= maxTransparency) {
                    result.add(gemstone);
                }
            }
        }
        return result;
    }
}