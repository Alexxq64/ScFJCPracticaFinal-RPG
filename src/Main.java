import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static boolean heroTurn;


    public static void main(String[] args) throws IOException, InterruptedException {
        br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Input hero name: ");
//        String name = br.readLine();
        String name = "Alex";
        System.out.println("New hero to protect our world.");
        hero = new Hero(name, 100, 20, 25, 0, 50);
        System.out.println(hero);
        System.out.println("0: exit   1: fight   2: buy");
        while (true) {
            switch (br.readLine()) {
                case "0":
                    System.out.println("See you later!");
                    return;
                case "1":
                    fight();
                    break;
                case "2":
                    buy();
                    break;
                default:
                    System.out.println("No such item in the menu");
            }
        }
    }

    static void buy() {
        System.out.println("There are no sellers yet");
    }

    static void fight() throws InterruptedException {
        monster = new Random().nextInt(1, 3) == 1 ?
                new Goblin("Goblin", 50, 10, 10, 50, 20) :
                new Skeleton("Skeleton", 25, 20, 20, 25, 10);
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