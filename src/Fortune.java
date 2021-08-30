import java.util.Random;

public class Fortune implements Attributes {
    private String name;
    private int armor;
    private int hpBonus;
    private int hitModifier;
    DiceType type;

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    /**
     * Returns the replacement damage dice for the knight.
     * @return DiceType type
     */
    @Override
    public DiceType getDamageDie() {
        return type;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        String t1 = ("+" + getMaxHP());
        String t2 = ("+" + getArmor());
        String t3 = ("+" + getHitModifier());
        String t4 = (type != null ? type.toString() : "-");
        return String.format(
                "+======================+\n" +
                "|%-22s|\n" +
                "|HP Bonus:%13s|\n" +
                "|AC Bonus:%13s|\n" +
                "|Hit Bonus:%12s|\n" +
                "|Damage Adj:%11s|\n" +
                "+======================+",
                getName(), t1, t2, t3, t4);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier){
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type){
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.type = type;
    }


}
