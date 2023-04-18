import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;


public class Main {
    public static String BLACK = "\u001B[30m";
    public static String GREEN = "\u001B[32m";
    public static String BLUE = "\u001B[34m";
    public static String RED = "\u001B[31m";
    public static String YELLOW = "\u001B[33m";

    private static BufferedReader br;
    static Hero hero;
    static Pers monster;
    static NPC seller;
    public static boolean heroTurn;


    public static void main(String[] args) throws IOException, InterruptedException {
        br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Input hero name: ");
//        String name = br.readLine();
        String name = "Alex";
        System.out.println("New hero to protect our world.");
        hero = new Hero(name, 100, 20, 25, 0, 50, 0);
        HashMap<Goods, Integer> potions = new HashMap<>();
//        Goods smallPotion = new Goods("Small", 50, "health", 10);
//        Goods middlePotion = new Goods("Middle", 100, "health", 30);
//        Goods bigPotion = new Goods("Big", 200, "health", 80);
        potions.put(Goods.smallPotion, 10);
        potions.put(Goods.middlePotion, 8);
        potions.put(Goods.bigPotion, 3);
        seller = new NPC("Pharmacist", potions);
        System.out.println(hero);
        while (true) {
        System.out.println("0: exit   1: fight   2: buy   3: level up");
            switch (br.readLine()) {
                case "0":
                    System.out.println("Good bye!");
                    return;
                case "1":
                    fight();
                    break;
                case "2":
                    buy();
                    break;
                case "3":
                    levelUp();
                    break;
                default:
                    System.out.println("No such item in the menu");
            }
        }
    }

    private static void levelUp() throws IOException {
            if (hero.getXp() <= 50 * Math.pow(5, hero.getLevel())) {
                System.out.println("Maybe next time");
                return;
            }
        while (hero.getXp() > 50 * Math.pow(5, hero.getLevel())) {
            System.out.println("You can choose something to increase");
            System.out.println("1: health   2: strength   3: dexterity");
            switch (br.readLine()) {
                case "1":
                    hero.setHealth((int) (hero.initialHealth * Math.pow(1.2, hero.getLevel() + 1)));
                    break;
                case "2":
                    hero.setStrength((int) (hero.getStrength() * 1.5));
                    break;
                case "3":
                    hero.setDexterity((int) (hero.getDexterity() * 1.8));
                    break;
                default:
                    System.out.println("No such item in the menu");
            }
            hero.setLevel(hero.getLevel() + 1);

            System.out.println(hero);
        }
    }

    static void buy() throws IOException {
        System.out.println(seller);
        System.out.println("Wanna buy anything?\n");
        System.out.println("0: to main menu   1: small   2: middle   3: big");
        while (true) {
            switch (br.readLine()) {
                case "0":
                    System.out.println("See you later!");
                    return;
                case "1":
                    seller.sell(hero, Goods.smallPotion);
                    break;
                case "2":
                    seller.sell(hero, Goods.middlePotion);
                    break;
                case "3":
                    seller.sell(hero, Goods.bigPotion);
                    break;
                default:
                    System.out.println("No such item in the menu");
            }
        }

    }

    static void fight() throws InterruptedException {
        monster = new Random().nextInt(1, 3) == 1 ?
                new Goblin("Goblin", 50, 10, 10, 50, 20, 0) :
                new Skeleton("Skeleton", 25, 20, 20, 25, 10, 0);
        heroTurn = true;
        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println(hero.getName() + " " + hero.getHealth() + " <---> " + monster.getName() + " " + monster.getHealth());
            if (heroTurn) hit(hero, monster);
            else hit(monster, hero);
//            System.out.println();
            heroTurn = !heroTurn;
            Thread.sleep(500);
        }
        if (hero.getHealth() > 0) {
            System.out.println(BLACK + "Hero won\n");
            hero.setGold(hero.getGold()+ monster.getGold());
            hero.setXp(hero.getXp()+ monster.getXp());
            System.out.println(hero);
        }

        else System.out.println("Hero lost");
    }

    static void hit(Pers attacker, Pers defender) {
        defender.setHealth(defender.getHealth() - attacker.attack());
    }
}