class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    public void printDetails() {
        System.out.println("License Plate : " + licensePlate);
        System.out.println("Owner Name : " + ownerName);
        System.out.println("Hours Parked : " + hoursParked);
        System.out.println();
    }
}

class ParkingLot {
    private Vehicle[] vehicles=new Vehicle[5];
    private int vehicleCount=0;

    public void parkVehicle(Vehicle v) {
        if (vehicleCount < 5) {
            vehicles[vehicleCount] = v;
            vehicleCount++;
        } else {
            System.out.println("Parking lot is full. Cannot park more vehicles.");
        }
    }

    public void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i=0; i<vehicleCount; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
            
                for (int j = i; j < vehicleCount-1; j++) {
                    vehicles[j] = vehicles[j+1];
                }
                vehicles[vehicleCount-1] = null;
                vehicleCount--;
                found = true;
                System.out.println("Vehicle with license " + licensePlate + " removed.");
				System.out.println();
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with license " + licensePlate + " not found.");
        }
    }

    public void displayVehicles() {
        System.out.println("------ Parked Vehicles ------");
        for (int i=0; i<vehicleCount; i++) {
            vehicles[i].printDetails();
        }
    }
}

public class Q_02 {
    public static void main(String[] args) {
        ParkingLot lot=new ParkingLot();

        lot.parkVehicle(new Vehicle("ABC123","John Doe",2));
        lot.parkVehicle(new Vehicle("XYZ789","Jane Smith",4));
        lot.parkVehicle(new Vehicle("LMN456","Bob Brown",1));

        lot.removeVehicle("XYZ789");

        lot.displayVehicles();
    }
}

