public class CargoFlight implements Flight {
    private int flightNumber;
    private String destination;
    private String vesselMark;
    private String vesselStatus;
    private int passengerCount;
    private boolean weapons;
    private boolean animals;

    public CargoFlight(int flightNumber, String destination, String vesselMark, String vesselStatus,
            int passengerCount, boolean weapons, boolean animals) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.vesselMark = vesselMark;
        this.vesselStatus = vesselStatus;
        this.passengerCount = passengerCount;
        this.weapons = weapons;
        this.animals = animals;
    }

    @Override
    public void flightInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("Your flight is:");
        System.out.println("Flight number = " + flightNumber);
        System.out.println("Flight destination = " + destination);
        System.out.println("Vessel's mark is  " + vesselMark);
        System.out.println("Your vessel's status is = " + vesselStatus);
        System.out.println("Amount of passengers = " + passengerCount);
        System.out.println("Weapons = " + (weapons ? "with weapons" : "without weapons"));
        System.out.println("Animals allowed? = " + (animals ? "yes" : "no"));
    }

    @Override
    public void averageFlightTime(double flightTime) {
        System.out.println("The average flight time is: " + flightTime);
    }

    @Override
    public void vesselWeight(double weight) {
        System.out.println("The weight of floght is: " + weight);

    }

    @Override
    public void fuelAmount(double fuel) {
        System.out.println("The amount of fuel is: " + fuel);

    }

    @Override
    public void sendVessel() {
        System.out.println("Send flight number: " + flightNumber);
        System.out.println("Flight number " + flightNumber + " was sent");
    }

    @Override
    public void repair() {
        System.out.println("Repair flight number: " + flightNumber);
        System.out.println("Flight number " + flightNumber + " was repaired");
    }

    @Override
    public void tankUp() {
        System.out.println("Tank up flight number: " + flightNumber);
        System.out.println("Flight number " + flightNumber + " was tanked up");
    }

    @Override
    public void loadUP() {
        System.out.println("Load up flight number: " + flightNumber);
        System.out.println("Flight number " + flightNumber + " was loaded up");
    }

    @Override
    public void unload() {
        System.out.println("Unload flight number: " + flightNumber);
        System.out.println("Flight number " + flightNumber + " was unloaded");
    }

    void getGoodsValue(double value) {
        System.out.println("Good's value is: " + value + " $");
    }
}
