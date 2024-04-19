public class PassengerFlight implements Flight {
    private int flightNumber;
    private String destination;
    private String vesselMark;
    private String vesselStatus;
    private int passengerCount;
    private boolean food;
    private boolean businessclass;

    public PassengerFlight(int flightNumber, String destination, String vesselMark, String vesselStatus,
            int passengerCount, boolean food, boolean businessclass) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.vesselMark = vesselMark;
        this.vesselStatus = vesselStatus;
        this.passengerCount = passengerCount;
        this.food = food;
        this.businessclass = businessclass;
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
        System.out.println("Food = " + (food ? "with food" : "without food"));
        System.out.println("Business class = " + (businessclass ? "with business class" : "without business class"));
    }

    @Override
    public void averageFlightTime(double flightTime) {
        System.out.println("Average flight time is: " + flightTime + " hours");
    }

    @Override
    public void vesselWeight(double weight) {
        System.out.println("Weight is: " + weight + " tones");
    }

    @Override
    public void fuelAmount(double fuel) {
        System.out.println("The amount of fuel is: " + fuel + " l.");
    }

    @Override
    public void sendVessel() {
        System.out.println("Send flight number: " + flightNumber);
        System.out.println("Flight number" + flightNumber + " was sent");
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
}
