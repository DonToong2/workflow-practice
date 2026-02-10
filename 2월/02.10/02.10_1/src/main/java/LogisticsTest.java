public class LogisticsTest {
    public static void main(String[] args) {
        LogisticCenter center = new LogisticCenter();

        Parcel[] parcels = {
                new GeneralParcel("서울 강남구"),
                new FreshParcel("부산 해운대구"),
                new GeneralParcel("경기 성남시")
        };

        System.out.println("== 배송 일괄 처리 시작 ==");

        for(Parcel p : parcels) {
            center.scanParcel(p);
            System.out.println("-----------------");
        }
    }
}

class Parcel {
    String address;

    public Parcel(String address) {
        this.address = address;
    }

    void process() {
        System.out.println("[" + address + "] 배송 준비 중...");
    }
}

class GeneralParcel extends Parcel {
    public GeneralParcel(String address) {
        super(address);
    }

    @Override
    void process() {
        System.out.println("[" + address + "] 일반 택배로 배송합니다.");
    }
}

class FreshParcel extends Parcel {
    public FreshParcel(String address) {
        super(address);
    }

    public void saveCooling() {
        System.out.println("냉동 상태를 유지합니다.");
    }

    @Override
    void process() {
        System.out.println("[" + address + "] 긴급 냉동 택배로 배송합니다.");
    }
}

class LogisticCenter {
    public LogisticCenter() {}

    void scanParcel(Parcel p) {
        p.process();

        if (p instanceof FreshParcel) {
            FreshParcel fp = (FreshParcel) p;
            fp.saveCooling();
        }
    }

}

// 이거 다시