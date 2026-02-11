class Coffee {
    int price;

    public Coffee(int price) {
        this.price = price;
    }
}

//class Americano extends Coffee {
//    public Americano() {
//        super(4000);
//    }
//}

//class CaffeLatte extends Coffee {
//    public CaffeLatte() {
//        super(5000);
//    }

class Americano extends Coffee {
    public Americano() {
        super(4000);
    }

    @Override
    public String toString() {
        return "아메리카노";
    }
}
class CaffeLatte extends Coffee {
    public CaffeLatte() {
        super(5000);
    }

    @Override
    public String toString() {
        return "카페라떼";
    }
}

class Customer {
    int money = 50000;

//    void buyCoffee(Americano americano) {
//        money -= americano.price;
//        System.out.println("아메리카노를 구입했습니다.");
//    }
//
//    void buyCoffee(CaffeLatte caffeLatte) {
//        money -= caffeLatte.price;
//        System.out.println("카페라떼를 구입했습니다.");
//    }

    void buyCoffee(Coffee coffee) {
        if(money < coffee.price) {
            System.out.println("잔액이 부족합니다");
            return; // 후에 금액 계산과 커피 구매X
        }
        else {
            System.out.println();
        }
        money -= coffee.price;
        System.out.println(coffee + "를 구입했습니다.");
    }
}

public class AfterPolymorphism {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buyCoffee(new Americano());
        customer.buyCoffee(new CaffeLatte());

        System.out.println("현재 잔액은 " + customer.money + "원 입니다.");
    }
}