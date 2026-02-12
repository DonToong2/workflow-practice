import java.util.Optional;

public class Car {
    private String carName;
    private int price;
    private Optional<Insurance> insurance;

    public Car(String carName, int price, Optional<Insurance> insurance) {
        this.carName = carName;
        this.price = price;
        this.insurance = insurance;
    }

    public String getCarName() { return carName; }
    public void setCarName(String carName) { this.carName = carName; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public Optional<Insurance> getInsurance() { return insurance; }
    public void setInsurance(Optional<Insurance> insurance) { this.insurance = insurance; }

}
