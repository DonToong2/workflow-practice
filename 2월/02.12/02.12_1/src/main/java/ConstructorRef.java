import java.util.function.BiFunction;
import java.util.function.Function;

class Member {
    private String name;
    private String id;

    public Member() {
        System.out.println("기본 생성자");
    }

    public Member(String id) {
        this.id = id;
    }

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID : " + id + ", Name : " + name;
    }
}
public class ConstructorRef {
    public static void main(String[] args) {
        Function<String, Member> f1 = Member::new;
        Member m1 = f1.apply("kimcoding");

        BiFunction<String, String, Member> f2 = Member::new;
        Member m2 = f2.apply("kimcoding", "김코딩");

        // toString()이 자동 호출
        System.out.println(m1);
        System.out.println(m2);
    }
}
