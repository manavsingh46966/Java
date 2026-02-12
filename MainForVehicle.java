import java.time.Year;

enum FuelType {
    PETROL, DIESEL, CNG, ELECTRIC
}

class Vehicle {

    // Private Data Members
    private String brandName;
    private String modelName;
    private double price;
    private String color;
    private String regNo;
    private Year mfgYear;
    private FuelType fuelType;
    private double speed;

    // ================= GETTERS & SETTERS =================

    public String getBrandName() { return brandName; }
    public void setBrandName(String brandName) { this.brandName = brandName; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public Year getMfgYear() { return mfgYear; }
    public void setMfgYear(Year mfgYear) { this.mfgYear = mfgYear; }

    public FuelType getFuelType() { return fuelType; }
    public void setFuelType(FuelType fuelType) { this.fuelType = fuelType; }

    // ================= CONSTRUCTORS =================

    // Default Constructor
    public Vehicle() {
        brandName = "Hyundai";
        modelName = "i10";
        price = 500000;
        color = "White";
        regNo = "KA01AB1234";
        mfgYear = Year.of(2022);
        fuelType = FuelType.PETROL;
        speed = 0;
    }

    // Parameterized Constructor
    public Vehicle(String brandName, String modelName, double price,
                   String color, String regNo, Year mfgYear,
                   FuelType fuelType) {

        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
        this.regNo = regNo;
        this.mfgYear = mfgYear;
        this.fuelType = fuelType;
        this.speed = 0;
    }

    // Copy Constructor
    public Vehicle(Vehicle v) {
        this.brandName = v.brandName;
        this.modelName = v.modelName;
        this.price = v.price;
        this.color = v.color;
        this.regNo = v.regNo;
        this.mfgYear = v.mfgYear;
        this.fuelType = v.fuelType;
        this.speed = v.speed;
    }

    // ================= METHODS =================

    public void start() {
        speed = 10;
        System.out.println("Vehicle started.");
    }

    public void stop() {
        speed = 0;
        System.out.println("Vehicle stopped.");
    }

    public void drive() {
        System.out.println("Vehicle is driving at speed: " + speed);
    }

    public void changeSpeed(double newSpeed) {
        speed = newSpeed;
        System.out.println("Speed changed to: " + speed);
    }

    public double calcMileage(double distance, double fuelUsed) {
        if (fuelType == FuelType.ELECTRIC) {
            return distance * 5;
        }
        if (fuelUsed == 0) return 0;
        return distance / fuelUsed;
    }
}

public class MainForVehicle {

    public static void main(String[] args) {

        // Create multiple objects
        Vehicle v1 = new Vehicle();

        Vehicle v2 = new Vehicle(
                "Honda",
                "City",
                900000,
                "Black",
                "KA02CD5678",
                Year.of(2023),
                FuelType.DIESEL
        );

        Vehicle v3 = new Vehicle(v2); // Copy constructor
        v3.setBrandName("Toyota");
        v3.setModelName("Corolla");
        v3.setPrice(850000);
        v3.setFuelType(FuelType.CNG);

        // Array of Vehicles
        Vehicle[] vehicles = { v1, v2, v3 };

        // Tabular Output
        System.out.println("\n================ VEHICLE DETAILS =================");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-12s %-12s %-12s %-10s%n",
                "Brand Name", "Model Name", "Price", "Mileage");
        System.out.println("-------------------------------------------------------------");

        for (Vehicle v : vehicles) {

            double mileage = v.calcMileage(100, 5);

            System.out.printf("%-12s %-12s %-12.2f %-10.2f%n",
                    v.getBrandName(),
                    v.getModelName(),
                    v.getPrice(),
                    mileage);
        }

        System.out.println("-------------------------------------------------------------");
    }
}
