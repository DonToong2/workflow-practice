public class Product {

    private String name; //  상품 이름
    private int price; // 상품 가격

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + price + "원";
    }
}