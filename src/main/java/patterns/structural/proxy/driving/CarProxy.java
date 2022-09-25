package patterns.structural.proxy.driving;

public class CarProxy extends Car {
    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        // protection proxy
        if (driver.age >= 16) {
            super.drive();
        } else {
            System.out.println("Driver too young.");
        }
    }

    public static void main(String[] args) {
        Car car = new Car(new Driver(12));
        car.drive();

        Car carProxy = new CarProxy(new Driver(12));

        carProxy.drive();
    }
}
