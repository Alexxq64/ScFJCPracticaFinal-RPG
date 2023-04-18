public class Goods {
    String name;
    int price;

    public Goods(String name, int price, String applyTo, int power) {
        this.name = name;
        this.price = price;
        this.applyTo = applyTo;
        this.power = power;
    }

    static Goods smallPotion = new Goods("Small", 50, "health", 10);
    static Goods middlePotion = new Goods("Middle", 100, "health", 30);
    static Goods bigPotion = new Goods("Big", 200, "health", 80);

    @Override
    public String toString() {
        return "\n" +
                name  +
                ": price=" + price +
                ", apply to " + applyTo +
                ", power=" + power + " , qtty" ;
    }

    String applyTo;
    int power;
}
