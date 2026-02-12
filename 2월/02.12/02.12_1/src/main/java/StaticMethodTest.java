import java.util.function.IntBinaryOperator;

class Calculator1 {
    //TODO 덧셈 (int, int) -> int
    public static int add(int a, int b) {
        return a + b;
    }
}

public class StaticMethodTest {
    public static void main(String[] args) {
        // TODO : Calculator 클래스의 add 메서드를 메서드 참조로 연결
        IntBinaryOperator operator = Calculator1::add;
        int result = operator.applyAsInt(3,5);
        System.out.println("정적 메서드 결과 : " + result);
    }
}
