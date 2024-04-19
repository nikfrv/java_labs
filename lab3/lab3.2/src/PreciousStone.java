public class PreciousStone extends Gemstone {
    private String color;
    private double transparency;

    public PreciousStone(String name, double weight, double price, String color, double transparency) {
        super(name, weight, price);
        this.color = color;
        this.transparency = transparency;
    }

    public String getColor() {
        return color;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() +
                ", Weight: " + getWeight() +
                ", Price: " + getPrice() +
                ", Color: " + color +
                ", Transparency: " + transparency;
    }
}