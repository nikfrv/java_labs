package org.example;

public class Services {
    public int idService;
    public String service_name;
    public int price;
    public int duration;

    public Services(int idService, String service_name, int price, int duration) {
        this.idService = idService;
        this.service_name = service_name;
        this.price = price;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("ID: %d , service's name: %s , price: %d , duration: %d ", this.idService, this.service_name,
                this.price, this.duration);
    }

    public double getPrice() {
        return price;
    }

    public static int compareByPrice(Services service1, Services service2) {
        return Double.compare(service1.getPrice(), service2.getPrice());
    }
}