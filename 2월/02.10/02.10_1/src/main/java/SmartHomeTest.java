public class SmartHomeTest {
    public static void main(String[] arsg) {
        // 다형성 활용: 스마트 기기와 일반 기기를 섞어서 관리
        HomeAppliance[] appliances = {
                new SmartTv("삼성"),
                new OldRadio("골드스타")
        };

        System.out.println("== 스마트 홈 시스템 가동 ==");
        for(HomeAppliance appliance : appliances) {
            appliance.turnOn();

            if (appliance instanceof SmartWifi) {
                SmartWifi smartDevice = (SmartWifi) appliance;
                smartDevice.connect();
            }
            System.out.println("===============");
        }
    }
}

abstract class HomeAppliance {
    // final 키워드로 값 변경 불가 장치
    final String brand;

    HomeAppliance(String brand) {
        this.brand = brand;
    }

    // 추상메서드로 자식에게 구현 강제
     abstract void turnOn();
}

interface SmartWifi {
    // 구현체가 반드시 구현해야 할 기능 목록
    void connect();
}

// 가전제품이면서(extends) 와이파이 연결 가능(implements)
class SmartTv extends HomeAppliance implements SmartWifi {
    SmartTv(String brand) {
        super(brand);
    }

    @Override
    public void connect() {
        System.out.println("와이파이 연결 되었습니다.");
    }

    @Override
    void turnOn() {
        System.out.println(brand + "TV를 켭니다.");
    }
}

// 가전제품(extends)
class OldRadio extends HomeAppliance {
    OldRadio(String brand) {
        super(brand);
    }

    @Override
    void turnOn() {
        System.out.println(brand + "를 켭니다.");
    }
}

