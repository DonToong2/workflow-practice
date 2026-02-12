import java.util.function.Predicate;

public class LambdaRefactorExample {
    public static void main(String[] args) {
        // 익명 클래스 제거, (매개변수) -> 반환식
        // TODO Predicate
        Predicate<String> startsWithA = str -> str.startsWith("A");

        boolean result = startsWithA.test("Apple"); // TODO
        System.out.println("result = " + result);
    }
}