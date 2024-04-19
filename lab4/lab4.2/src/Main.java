
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);

        int parkingSpace1 = parkingLot.parkCar("ABC123");
        int parkingSpace2 = parkingLot.parkCar("DEF456");
        int parkingSpace3 = parkingLot.parkCar("GHI789");

        parkingLot.printParkingLotStatus();

        parkingLot.removeCar(parkingSpace1);
        parkingLot.removeCar(parkingSpace2);
        parkingLot.removeCar(parkingSpace3);
        System.out.println("Removed all cars");

        parkingLot.printParkingLotStatus();
    }
}