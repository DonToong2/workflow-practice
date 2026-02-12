import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("무선 마우스", 18000),
                new Product("기계식 키보드", 45000),
                new Product("HDMI 케이블", 12000),
                new Product("USB 허브", 22000)
        );

        // Stream을 사용해 필터링 + 변환 + 수집 작업 수행
        List<String> result = products.stream()
                .filter(product -> product.getPrice() >= 20000) // 필터링, 조건
                .map(product -> product.getName())
                .toList();
        System.out.println(result);

    }
}
