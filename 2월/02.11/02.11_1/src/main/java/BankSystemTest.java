public class BankSystemTest {
    public static void main(String[] args) {
        // 가정 : DB에서 "W"(출금)라는 코드가 넘어옴
        String dbCode = "T";
        int amount = 50000;

        try {
            // 안전한 조회 (DB코드 -> Enum)
            TransactionType type = TransactionType.fromCode(dbCode);
            System.out.println("거래 종류 : " + type.getDesc());

            // Enum 다형성 활용(if문 없이 바로 계산)
            int fee = type.calculateFee(amount);
            System.out.println("수수료 : " + fee + "원");

            // switch문 활용
            switch (type) {
                case WITHDRAWAL:
                    System.out.println("-> 출금 시 보이스피싱 주의.");
                    break;
                case TRANSFER:
                    System.out.println("-> 이체 한도를 확인하세요.");
                    break;
                case DEPOSIT:
                    System.out.println("-> 감사합니다.");
                    break;
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("오류 : " + e.getMessage());
        }
    }
}

enum TransactionType {
    // 상수별로 데이터와 동작을 동시에 정의 (@Override)
    DEPOSIT("D", "입금") {
        @Override
        public int calculateFee(int amount) {
            return 0;
        }
    },
    WITHDRAWAL("W", "출금") {
        @Override
        public int calculateFee(int amount) {
            return 1000;
        }
    },
    TRANSFER("T", "이체") {
        @Override
        public int calculateFee(int amount) {
            return (int) (amount * 0.1);
        }
    };

    private final String code;
    private final String desc;

    // 필드 및 생성자
    TransactionType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    // 추상 메서드 선언
    public abstract int calculateFee(int amount);

    // 역매핑 메서드 -> 코드로 찾는 로직 직접 구현(valueof 사용X)
    public static TransactionType fromCode(String dbData) {
        if (dbData == null) {
            throw new IllegalArgumentException("코드가 null 입니다.");
        }

        for (TransactionType type : values()) {
            if (type.code.equals(dbData)) {
                return type;
            }
        }

        throw new IllegalArgumentException("존재하지 않는 코드입니다 : " + dbData);
    }
}
//## 시나리오
//
// 기존 은행 시스템은 거래 종류를 단순한 문자열(”DEPOSIT”, “WITHDRAW”)로 관리하고 있어서, 오타 위험이 큽니다. 또한 수수료 계산 로직이 `if-else`로 지저분하게 흩어져 있습니다.
//
//다음 요구사항에 맞춰 코드를 작성해 봅시다.
//
//        ## 요구사항
//
// 1. Enum 정의(Type Safety):
//        a. `TransactionType` Enum 을 만드세요.
//        b. 상수는 `DEPOSIT(”D”,”입금”)`, `WITHDRAWAL(”W”,”출금”),` `TRANSFER(”T”,”이체”)` 세가지 입니다.
// 2. 필드와 생성자(Data):
//        a. 각 상수는 DB 저장용 코드(`code`)와 한글 설명(`desc`)을 가져야 합니다.
// 3. 추상 메서드 구현:
//        a. 거래 종류마다 수수료가 다릅니다. Enum 내부에 `calculateFee(int amount)` 추상 메서드를 선언하고, 각 상수에서 직접 구현하세요.
//          i. 입금: 수수료 0원
//          ii. 출금: 1000원 고정
//          iii. 이체: 이체 금액의 10% (단, 정수로 반환)
// 4. 안전한 조회:
//        a. DB에서 읽어온 문자열 코드(예:”W”)를 Enum으로 변환하는 `fromCode(String code)` 메서드를 만드세요.
//        b. `valueOf`를 쓰지 말고, 반복문을 통해 찾으시고, 없는 코드면 `null` 대신 기본값을 임의로 정하거나 예외를 던지셔도 됩니다.