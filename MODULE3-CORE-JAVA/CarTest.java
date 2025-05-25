class Car {
    // Attributes
    String make;
    String model;
    int year;

    // Constructor to initialize the car object
    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("--------------------");
    }
}

// Main class to test the Car class
public class CarTest {
    public static void main(String[] args) {
        // Create Car objects
        Car car1 = new Car("Toyota", "Camry", 2020);
        Car car2 = new Car("Honda", "Civic", 2022);
        Car car3 = new Car("Tesla", "Model 3", 2023);

        // Call displayDetails() method
        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}
