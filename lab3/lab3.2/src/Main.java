import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Necklace necklace = new Necklace();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Gemstone");
            System.out.println("2. Calculate Total Weight");
            System.out.println("3. Calculate Total Cost");
            System.out.println("4. Sort Gemstones by Value");
            System.out.println("5. Find Gemstones by Transparency Range");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addGemstone();
                    break;
                case 2:
                    calculateTotalWeight();
                    break;
                case 3:
                    calculateTotalCost();
                    break;
                case 4:
                    sortGemstonesByValue();
                    break;
                case 5:
                    findGemstonesByTransparencyRange();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }

    private static void addGemstone() {
        System.out.println("Enter Gemstone type (1 - Precious, 2 - Semi-Precious):");
        int type = scanner.nextInt();
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter weight (in carats):");
        double weight = scanner.nextDouble();
        System.out.println("Enter price (per carat):");
        double price = scanner.nextDouble();
        if (type == 1) {
            System.out.println("Enter color:");
            String color = scanner.next();
            System.out.println("Enter transparency:");
            double transparency = scanner.nextDouble();
            PreciousStone preciousStone = new PreciousStone(name, weight, price, color, transparency);
            necklace.addGemstone(preciousStone);
        } else if (type == 2) {
            System.out.println("Enter type:");
            String gemType = scanner.next();
            SemiPreciousStone semiPreciousStone = new SemiPreciousStone(name, weight, price, gemType);
            necklace.addGemstone(semiPreciousStone);
        }
        System.out.println("Gemstone added to the necklace.");
    }

    private static void calculateTotalWeight() {
        double totalWeight = necklace.calculateTotalWeight();
        System.out.println("Total Weight of the Necklace: " + totalWeight + " carats");
    }

    private static void calculateTotalCost() {
        double totalCost = necklace.calculateTotalCost();
        System.out.println("Total Cost of the Necklace: $" + totalCost);
    }

    private static void sortGemstonesByValue() {
        necklace.sortGemstonesByValue();
        System.out.println("Gemstones sorted by value.");
    }

    private static void findGemstonesByTransparencyRange() {
        System.out.println("Enter minimum transparency:");
        double minTransparency = scanner.nextDouble();
        System.out.println("Enter maximum transparency:");
        double maxTransparency = scanner.nextDouble();
        List<Gemstone> gemstones = necklace.findGemstonesByTransparencyRange(minTransparency, maxTransparency);
        if (gemstones.isEmpty()) {
            System.out.println("No gemstones found in the given transparency range.");
        } else {
            System.out.println("Gemstones in the given transparency range:");
            for (Gemstone gemstone : gemstones) {
                System.out.println(gemstone.getInfo());
            }
        }
    }
}