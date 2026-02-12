import java.util.Optional;

public class Member {
    private String name;
    private String id;
    private Optional<Car> car;

    public Member(String name, String id, Optional<Car> car) {
        this.name = name;
        this.id = id;
        this.car = car;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void SetId(String id) { this.id = id; }

    public Optional<Car> getCar() { return car; }
    public void setCar(Optional<Car> car) { this.car = car; }
}
