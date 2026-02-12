import java.util.function.IntBinaryOperator;

class Calculator2 {
    public int multiply(int a, int b) {
        return a * b;
    }
}
public class InstanceMethodTest {
    public static void main(String[] args) {
        // TODO: 생성한 객체(calc)의 multiply 메서드를 메서드 참조로 연결
        Calculator2 calculator = new Calculator2();
        IntBinaryOperator operator = calculator::multiply;
        int result = operator.applyAsInt(10,20);
        System.out.println("인스턴스 메서드 결과 : " + result);
    }
}
