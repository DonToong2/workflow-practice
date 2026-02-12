import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

// List -> Set, Set -> List, List -> Map 테스트
public class collectionTest {
    public static void main(String[] args) {
        // List -> Set
        List<String> rawList = List.of("A", "B", "A", "C");

        // TODO
        Set<String> uniqueSet = new HashSet<>(rawList);

        System.out.println(uniqueSet);

        // Set -> List
        Set<String> nameSet = Set.of("홍길동", "김명근", "아무개");

        // TODO
        List<String> nameList = new ArrayList<>(nameSet);
        Collections.sort(nameList);
        System.out.println(nameList);

        // List -> Map
        List<String> names = List.of("홍길동", "김명근", "아무개", "홍길동", "김명근", "홍길동");

        // TODO
        Map<String, Integer> nameCountMap = new HashMap<>();
        for(String name : names) {
            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }
        System.out.println(nameCountMap);
    }
}
