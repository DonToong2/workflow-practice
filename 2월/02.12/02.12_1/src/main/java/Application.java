import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Order {
    String customerName;
    List<String> items;

    public Order(String customerName, List<String> items) {
        this.customerName = customerName;
        this.items = items;
    }
}
public class Application {
    public static void main(String[] args) {
        Map<String, Order> orderMap = new HashMap<>();

        // TODO
        orderMap.put("ORD001", new Order("민지", List.of("마우스", "키보드"))); // ORD001, 민지, 마우스, 키보드
        orderMap.put("ORD002", new Order("수현", List.of("노트북"))); // ORD002, 수현, 노트북
        orderMap.put("ORD003", new Order("지훈", List.of("모니터", "USB 허브", "스피커"))); // ORD003, 지훈, 모니터, USB 허브, 스피커

        for(Map.Entry<String, Order> entry : orderMap.entrySet()) {
            String orderId = entry.getKey();
            Order order = entry.getValue();

            System.out.println("주문번호 : " + orderId);
            System.out.println("고객명 : " + order.customerName);
            System.out.println("상품목록 : " + order.items);
        }
    }
}

/*
## 4. 복합 데이터 처리 실습

### 4-1. 요구사항

- 주문번호(`String`)를 기준으로 주문 정보를 저장하고 출력해야 함
- 주문 정보는 **고객명과 상품 목록**을 포함해야 함
- 전체 주문 내역을 반복문으로 출력해야 함*/
