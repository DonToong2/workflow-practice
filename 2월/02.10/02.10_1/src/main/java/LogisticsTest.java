public class LogisticsTest {
    public static void main(String[] args) {
        // 4. 업캐스팅 및 배열처리
        Parcel[] parcels = {
                new FreshParcel("광주광역시"),
                new GeneralParcel("서울특별시"),
                new GeneralParcel("부산광역시")
        };

        LogisticsCenter center = new LogisticsCenter();

        for(Parcel p : parcels) {
            center.scanParcel(p);
            System.out.println("===============");
        }
    }
}

// 1. 클래스 생성
class Parcel {
    String address; // 주소(멤버 변수)

    Parcel(String address) { // 생성자
        this.address = address;
    }

    // 2-1. 모든 택배는 process() 메서드를 통해 배송 처리가 된다.
    void process() { // 메서드
        System.out.println(address + "(으)로 배송 준비 중...");
    }
}

// 1. 클래스 생성과 상속관계
class GeneralParcel extends Parcel {
    GeneralParcel(String address) {
        super(address);
    }
    
    // 2-2. 오버라이딩
    @Override
    public void process() {
        System.out.println(address + "(으)로 일반 배송합니다.");
    }
}

// 1. 클래스 생성과 상속관계
class FreshParcel extends Parcel {
    FreshParcel(String address) {
        super(address);
    }
    
    // 3-1. FreshParcel의 고유기능인 온도 유지 메서드 saveCooling()
    void saveCooling() {
        System.out.println("냉동 온도 유지중..");
    }
    // 2-2. 오버라이딩
    @Override
    public void process() {
        System.out.println(address + "(으)로 긴급 냉동 배송합니다.");
    }
}

// 3-2. 물류 센터 LogisticsCenter 클래스 생성, 신선 택배인 경우(instanceof)에만 온도 유지
class LogisticsCenter {
    void scanParcel(Parcel p) { // 택배를 보내는 메서드
        p.process();
        //신선택배인지 체크하고 신선택배면 온도 유지, 다운캐스팅
        if (p instanceof FreshParcel) {
            FreshParcel fp = (FreshParcel) p;
            fp.saveCooling();
        }
    }//
}

// 시나리오

// 우리는 택배 회사의 물류 분류 시스템을 개발하고 있습니다.
// 택배의 종류는 다양하지만, 시스템은 일관된 방식으로 배송 처리를 해야 합니다.
// 단, ‘신선 식품’은 배송 전에 반드시 온도 체크를 해야합니다.

// 요구사항

// 1. 상속 관계(Inheritance):
//        1-1. 모든 택배의 부모 클래스인 `Parcel` 을 만드세요.(배송지 `address` 정보를 가짐)
//        1-2 `Parcel`을 상속받는 `GeneralParcel`(일반 택배)과 `FreshParcel`(신선 택배) 클래스를 만드세요.
// 2. 다형성과 오버라이드(Polymorphism):
//        2-1. 모든 택배는 `process()` 메서드를 통해 배송 처리가 됩니다.
//        2-2. `GeneralParcel`은 “일반 배송합니다.” 를, `FreshParcel`은 “긴급 냉동 배송합니다.” 를 출력하도록 오버라이딩 하세요.
// 3. `instanceof`와 다운캐스팅:
//        3-1. `FreshParcel`에는 고유 기능인 `saveCooling()`(온도 유지) 메서드가 있습니다.
//        3-2. 물류 센터(`LogisticsCenter`) 클래스에서 택배를 처리할 때, 신선 택배인 경우에만 “온도를 유지합니다.” 라는 기능이 추가로 실행되어야 합니다.
// 4. 배열 처리:
//        4-1. (optional) `main` 메서드에서 여러 개의 택배를 `parcel[]` 배열에 담고, 반복문으로 일괄 처리하세요.