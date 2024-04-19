public class Main {
    public static void main(String[] args) {
        PassengerFlight passengerFlight1 = new PassengerFlight(100, "Paris", "Boing", "Ready", 300, true, true);
        CargoFlight cargoFlight1 = new CargoFlight(317, "London", "AN-300", "unloading", 5, false, true);

        passengerFlight1.flightInfo();
        passengerFlight1.averageFlightTime(3.5);
        passengerFlight1.vesselWeight(25);
        passengerFlight1.fuelAmount(500);
        passengerFlight1.sendVessel();
        passengerFlight1.repair();
        passengerFlight1.tankUp();
        passengerFlight1.loadUP();
        passengerFlight1.unload();
        System.out.println("---------------- Passenger flight ends --------------");

        cargoFlight1.flightInfo();
        cargoFlight1.averageFlightTime(5.2);
        cargoFlight1.vesselWeight(50);
        cargoFlight1.fuelAmount(1000);
        cargoFlight1.sendVessel();
        cargoFlight1.repair();
        cargoFlight1.tankUp();
        cargoFlight1.loadUP();
        cargoFlight1.unload();
        cargoFlight1.getGoodsValue(42877287482.324);
        System.out.println("---------------- Cargo flight ends --------------");
    }
}
