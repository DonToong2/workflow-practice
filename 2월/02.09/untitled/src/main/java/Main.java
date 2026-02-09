import java.util.*;
import java.io.*;

class Adventurer {
    // 인스턴스 변수 : 객체마다 별도로 저장됨(전사, 마법사 등), 힙 영역
    String name; // 모험가의 이름
    int level = 1; // 모험가의 레벨

    // 클래스 변수(static) : 모든 객체가 공유함, 스택 영역
    static int totalCount = 0; // 현재 생성된 모험가의 수

    // 생성자
    public Adventurer() {
        totalCount++; // 생성자가 호출될 때마다 값을 누적
    }

    // 메서드 오버로딩 -> 이름은 같지만 매개변수가 다름 (공격) 2가지 패턴
    public void attack() {
        System.out.println("맨손으로 공격합니다!");
    }

    public void attack(String weapon) {
        System.out.println("무기로 공격합니다!");
    }


    // 가변인자 : 아이템 개수가 몇 개 들어올지 모를 때 사용 -> 아이템 획득
    public void getLoot(String... items) {
        for(String item : items) {
            System.out.println("아이템 " + item + "을(를) 획득하였습니다!");
        }
    }

    // static 메서드 : 인스턴스 변수(name등은 사용 불가). static 변수만 사용 가능하게
    public static void printTotalCount() {
        System.out.println("현재 생성된 총 모험가의 수 : " + totalCount);    // 현재 서버의 총 모험가 수 출력
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 객체 생성 (생성자 호출 시 static 변수 증가)
        Adventurer Warrior = new Adventurer();
        Adventurer Magician = new Adventurer();

        // 메서드 오버로딩 테스트
        String weapon = "";
        Warrior.attack();
        Warrior.attack(weapon);

        // 가변인자 테스트
        String item1 = "검";
        String item2 = "지팡이";
        String item3 = "표창";
        Magician.getLoot(item1, item2, item3);

        // static 변수 공유 확인
        Adventurer.printTotalCount();
//        Magician.printTotalCount();

    }
}
