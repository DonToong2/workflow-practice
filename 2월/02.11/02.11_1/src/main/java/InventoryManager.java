import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    public static void main(String[] args) {
        // 인터페이스 타입 선언
        List<String> drink = new ArrayList<>();

        // 상품 입고
        drink.add("Coke");
        drink.add("Milk");
        drink.add("Coffee");

        System.out.println("=== 초기 재고 입고 완료 ===");
        
        // contains를 사용해 특정 요소 포함 여부 확인 -> 우유 재고가 있는지 확인
        if (drink.contains("Milk")) {
            System.out.println("현재 리스트에 Milk가 있습니다.");
        }

        // size를 사용해 현재 저장된 요소 개수 반환(수량 파악)
        System.out.println("현재 저장된 음료의 개수 : " + drink.size());

        // remove를 사용해 특정 개체 제거(상품 출고)
        drink.remove("Coke");

        // 출력전체 점검
        System.out.println("남은 음료 상품 : ");
        for(String item : drink) {
            System.out.println(item);
        }
    }
}
