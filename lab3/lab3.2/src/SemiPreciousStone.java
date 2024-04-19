public class SemiPreciousStone extends Gemstone {
    private String type;

    public SemiPreciousStone(String name, double weight, double price, String type) {
        super(name, weight, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() +
                ", Weight: " + getWeight() +
                ", Price: " + getPrice() +
                ", Type: " + type;
    }
}