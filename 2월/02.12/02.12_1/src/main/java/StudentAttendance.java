import java.util.HashSet;
import java.util.Set;

// 학생 출석부 (순서 유지X, 중복 제거) (Set, HashSet)
public class StudentAttendance {
    public static void main(String[] args) {
        Set<String> attendance = new HashSet<>();

        attendance.add("홍길동");
        attendance.add("김명근");
        attendance.add("홍길동"); // 중복 허용 X
        attendance.add("아무개");

        for (String name : attendance) {
            System.out.println(name);
        }
    }
}

//### 2-2. 출석 체크 기록 (중복 제거)
//
// 1. **요구사항**
//        - 학생들의 출석을 기록할 구조를 만들 것
//    - 한 학생이 여러 번 출석하더라도 **한 번만 기록**되어야 함 (중복 불가)
//    - 저장 순서는 중요하지 않음
//    - 출석한 학생 명단 전체를 출력할 수 있어야 함
// 2. **적합한 컬렉션**: `Set<String>`