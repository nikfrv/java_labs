public abstract class Gemstone {
    private String name;
    private double weight;
    private double price;

    public Gemstone(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateCost() {
        return weight * price;
    }

    public abstract String getInfo();
}