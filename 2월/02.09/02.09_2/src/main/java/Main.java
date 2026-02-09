// 모든 배터리는 용량(capacity) 정보를 가진다.
// 클래스명 Battery
class Battery { // 5000
    int capacity;
    Battery(int capacity) {
        this.capacity = capacity;
    }
}

// has-a
class Phone { // Galaxy S24
    // 포함 관계에 사용될 부품 폰 기종이고 배터리를 포함
    String model;
    Battery battery;
    Phone(String model, Battery battery) {
        this.model = model;
        this.battery = battery;
    }
}

// is-a
class SmartPhone extends Phone {
     // 운영체제 추가
    String os;

    // super() : 부모 클래스(Phone)의 생성자 호출
    // 생성자의 첫 줄에 위치(중요)
    SmartPhone(String model, Battery battery,String os) {
        super(model, battery);
        this.os = os;
    }

    // Overriding : 부모(Object)의 메서드를 재정의
    // 모든 클래스는 자동으로 Object를 상속받기 때문에 toString() 사용 가능
    @Override
    public String toString() {
        return "모델 : " + model + ", 배터리 : " + battery.capacity + "mAh, 운영체제 : " + os;
    }
}

public class Main {
    public static void main(String[] args) {
        // Composition(포함)을 위한 부품 객체 생성
        Battery battery = new Battery(5000);

        // 상속받은 자식 객체 생성
        SmartPhone myPhone = new SmartPhone("Galaxy S24", battery, "Android");
        
        // Object 클래스의 toString() 오버라이딩 확인
        // System.out.println(myPhone.toString()); 과 동일
        System.out.println(myPhone);

    }
}
