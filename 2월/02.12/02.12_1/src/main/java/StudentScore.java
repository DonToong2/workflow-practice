import java.util.HashMap;
import java.util.Map;

// 학생 점수 (Key : Value로 저장) (Map, HashMap)
public class StudentScore {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("홍길동", 88);
        scores.put("김명근", 98);
        scores.put("아무개", 78);

        System.out.println(scores.get("홍길동"));

        for(Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
//### 2-3. 학생 이름과 점수 매핑 (Key → Value)
//
// 1. **요구사항**
//    - 학생 이름과 점수를 함께 관리할 수 있는 구조를 만들 것
//    - 이름을 Key로, 점수를 Value로 저장
//    - 특정 학생의 점수를 이름으로 조회할 수 있어야 함
//    - 전체 학생의 이름과 점수를 함께 출력할 수 있어야 함
// 2. **적합한 컬렉션**: `Map<String, Integer>`