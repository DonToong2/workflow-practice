import java.util.List;

public class Application {
    public static void main(String[] args) {

        // Stream 생성을 위한 데이터 소스 준비
        List<Student> students = List.of(
                new Student("Minji", 85),
                new Student("수현", 77),
                new Student("지훈", 90),
                new Student("은우", 65)
        );
        
        // 여기서부터 Stream을 사용해 데이터를 처리
        List<String> result = students.stream()
                .filter(student -> student.getScore() >= 80) // 조건으로 필터링을 하고
                .map(student -> student.getName().toUpperCase()) // 매핑한다, 바꾸기
                .toList();
        System.out.println((result));
    }
}
