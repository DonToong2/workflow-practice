import java.util.ArrayList;
import java.util.List;

// 학생 명단 (순서 유지, 중복 허용) (List, ArrayList)
public class StudentList {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        // 학생 추가
        students.add("홍길동");
        students.add("김명근");
        students.add("홍길동"); // 중복 허용
        students.add("아무개");

        System.out.println("===== 학생 명단 =====");
        for(String student : students) {
            System.out.println(student);
        }
    }
}
//### 1-1. 학생 명단 관리 (순서 유지 + 중복 허용)
//
//  1. **요구사항**
//      - 학생 이름들을 저장할 수 있는 구조를 만들 것
//      - 입력 순서가 유지되어야 함 (ex: 먼저 추가된 이름이 먼저 출력됨)
//      - 같은 이름이 여러 번 들어올 수 있음 (중복 허용)
//      - 전체 학생 이름을 순서대로 출력해야 함
//  2. **적합한 컬렉션**: `List<String>`