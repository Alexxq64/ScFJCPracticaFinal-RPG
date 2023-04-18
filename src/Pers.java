
public abstract class Pers implements Fighter {
    private String name;
    private int health;
    private int strength;
    private int dexterity;
    private int xp;
    private int gold;

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Pers(String name, int health, int strength, int dexterity, int xp, int gold, int level) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
    }


    @Override
    public int attack() {
        int hit = 0;
        int critical =  Math.random() > 0.8 ? 2 : 1;
        if (dexterity * 3 > (int) (Math.random() * 100)) hit = strength * critical;
        if (!Main.heroTurn) System.out.print("               ");
        System.out.print(hit + " ");
        if (hit == 0)
        System.out.println(Main.YELLOW + "Miss " + Main.BLACK);
        else if(critical == 2) System.out.println(Main.RED + "Critical hit" + Main.BLACK);
        else System.out.println(Main.BLUE + "Hit" + Main.BLACK);
        return hit;
    }

    @Override
    public String toString() {
        String extra = "";
        if (xp > 50 * Math.pow(5, level)) extra = Main.GREEN + "\nYou may level up!" + Main.BLACK;
        return name + ':' +
                " health = " + health +
                ", strength = " + strength +
                ", dexterity = " + dexterity +
                ", experience = " + xp +
                ", level = " + level +
                ", gold = " + gold + extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
