import java.util.HashMap;

public class NPC {
    String name;
    HashMap<Goods,Integer> goods;

    public NPC(String name, HashMap<Goods, Integer> goods) {
        this.name = name;
        this.goods = goods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Goods, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Goods, Integer> goods) {
        this.goods = goods;
    }


    public void buy(Pers p, Goods g){

    }

    public void sell(Pers p, Goods g) {
        if (p.getGold() >= g.price) {
            goods.put(g, goods.get(g) - 1);
            p.setHealth(p.getHealth() + g.power);
            p.setGold(p.getGold() - g.price);
            System.out.println(p);
        } else System.out.println("You don't have enough money");
    }

    public void make(Goods[] ingredients, Goods result){

    }

    @Override
    public String toString() {
        return name  + " has some potions " +
                goods;
    }
}
