import java.util.List;
import java.util.stream.Collectors;

public class StreamAdvancedExercies {
    public static void main(String[] args) {
        List<List<String>> rawData = List.of(
                List.of("Java", "Python", "Java"),
                List.of("Kotlin", "JavaScript"),
                List.of("Python", "Rust", "Go")
        );

        // 1단계 : 중첩 구조 평탄화 + 중복 제거 + 정렬
        List<String> techList =
                rawData.stream()
                        .flatMap(List::stream)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());

        // 2단계 : 결과 포맷팅
        String formatted =
                rawData.stream()
                        .flatMap(List::stream)
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining(", ", "[", "]"));

        // 3단계 : 두 개의 다른 stream연산(단, 최종 연산이 collect()로 같음)을 하나로 합쳐보기
        System.out.println("결과 리스트 : " + techList);
        System.out.println("포맷팅 결과 : " + formatted);
//        System.out.println("oneShotStream = " + oneShotStream);
    }
}
