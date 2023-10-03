public class Car {

    String carModel;
    int metersTraveled = 0;

    public Car(String modelCard) {
        this.carModel = modelCard;
    }
    @Override
    public String toString() {
        return "Car: " + carModel;
    }
}
