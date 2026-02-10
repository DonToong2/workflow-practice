import java.sql.SQLOutput;

public class ShopTest {
    public static void main(String[] args) {
        Member member = new Member("김명근", 20, 5000);

        System.out.println("이름 : " + member.getName());
        System.out.println("나이 : " + member.getAge());
        System.out.println("포인트 : " + member.getPoint());

        System.out.println();

        // 필드 값 변경
        member.setName("홍길동");
        member.setAge(-5); // 클래스 규약에 어긋난 값
        member.setPoint(-3000);
        System.out.println("이름 : " + member.getName());
        System.out.println("나이 : " + member.getAge());
        System.out.println("포인트 : " + member.getPoint());

        Receipt receipt1 = new Receipt("0001", 3900);
        System.out.println("영수증 번호 : " + receipt1.getOrderId());
        System.out.println("가격 : " + receipt1.getAmount());
    }
}

// 캡슐화와 Java Bean
// Java Bean 규약을 따르는 회원 클래스
class Member {
    // 접근 제어자 private -> 외부에서 필드 직접 접근 차단(데이터 보호)
    private String name;
    private int age;
    private int point;

    // 기본 생성자 필수(Java Bean 규약)
    public Member() {}

    public Member(String name, int age, int point) {
        this.name = name;
        this.age = age;
        this.point = point;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPoint() {
        return point;
    }


    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("나이는 0보다 작을 수 없습니다.");
            return;
        }
        else {
            this.age = age;
        }
    }

    public void setPoint(int point) {
        if (point < 0) {
            System.out.println("포인트는 음수가 될 수 없습니다.");
            return;
        }
        else {
            this.point = point;
        }
    }
}


// 불변 객체
class Receipt {
    // final 키워드 -> 초기화 후 값 변경 불가
    private final String orderId;
    private final int amount;

    // 생성자를 통해서만 값 주입
    Receipt(String orderId, int amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    // Getter 메서드(Setter 없이 값 변경 경로 차단)
    public String getOrderId() {
        return orderId;
    }

    public int getAmount() {
        return amount;
    }
}