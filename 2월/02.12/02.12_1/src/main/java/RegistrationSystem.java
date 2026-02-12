// contains, remove도 내부적으로 equals 기반으로 동작
import java.util.HashSet;
import java.util.Set;

// 이메일로 유일 식별자로 사용하는 불변 객체 정의
record User(String email) {}

public class RegistrationSystem {
    public static void main(String[] args) {
        // HashSet 사용 -> 중복 이메일 차단
        Set<User> users = new HashSet<>();

        // 가입시도 3번
        users.add(new User("java@codeit.com"));
        users.add(new User("spring@codeit.com"));
        users.add(new User("java@codeit.com"));

        // 총 가입자 수 출력
        System.out.println(users.size());

        // 추가 : 현재 가입자 명단 출력
        System.out.println("===== 가입자 명단 =====");
        for(User user : users) {
            System.out.println(user);
        }
        System.out.println(users);
        System.out.println();

        // contains는 equals 기반으로 비교
        System.out.println("===== spring@codeit.com 계정이 존재하나요 ? =====");

        boolean isSpringMember = users.contains(new User("spring@codeit.com"));
        System.out.println("spring@codeit.com 계정이 존재 유무 : " + isSpringMember);

        // 조건문으로
        if (users.contains("spring@codeit.com")) {
            System.out.println("spring@codeit.com 계정이 존재합니다.");
        }
        System.out.println();



        // remove 처리
        users.remove(new User("java@codeit.com"));
        System.out.println("java@codeit.com 계정 탈퇴");
        System.out.println();
        
        // 현재 남은 유저 출력 -> 리스트를 바로 출력
        System.out.println("===== 가입자 명단 =====");
        for(User user : users) {
            System.out.println(user);
        }
        System.out.println(users);
    }
}


//## 중복 가입 방지 시스템 구현
//
//### 시나리오
//
//여러분은 새로운 커뮤니티 서비스의 회원 가입 로직을 담당하고 있습니다. 동일한 이메일로 여러 번 가입하는 것을 막기 위해 `HashSet`을 도입하기로 했습니다.
//
//### 요구사항
//
// 1. 데이터 구조:
//    a. 이메일(email) 정보를 담는 User 객체를 record 를 사용하여 정의하세요.
// 2. 가입 처리:
//    a. java@codeit.com
//    b. spring@codeit.com
//    c. java@codeit.com → 중복 가입 시도
//    d. 위 3개 데이터를 순서대로 가입(add) 시키세요.
// 3. 결과 확인:
//    1. 가입이 완료된 후, 총 몇명의 유저가 등록되었는지 출력하세요.
//        a. spring@codeit.com유저가 명단에 있는지 확인하여 출력하세요.
// 4. 회원 탈퇴:
//    a. java@codeit.com 유저가 탈퇴를 요청했습니다. 명단에서 삭제해 주세요.