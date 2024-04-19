import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<String> parkingSpaces;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpaces = new ArrayList<>(capacity);
        initializeParkingSpaces();
    }

    private void initializeParkingSpaces() {
        for (int i = 0; i < capacity; i++) {
            parkingSpaces.add(null);
        }
    }

    public int parkCar(String carNumber) {
        int availableSpace = findAvailableSpace();
        if (availableSpace != -1) {
            parkingSpaces.set(availableSpace, carNumber);
        }
        return availableSpace;
    }

    public void removeCar(int parkingSpace) {
        if (parkingSpace >= 0 && parkingSpace < capacity) {
            parkingSpaces.set(parkingSpace, null);
        }
    }

    private int findAvailableSpace() {
        for (int i = 0; i < capacity; i++) {
            if (parkingSpaces.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    public void printParkingLotStatus() {
        for (int i = 0; i < capacity; i++) {
            String carNumber = parkingSpaces.get(i);
            if (carNumber != null) {
                System.out.println("Place " + i + ": Car " + carNumber);
            } else {
                System.out.println("Place " + i + ": is free");
            }
        }
    }
}