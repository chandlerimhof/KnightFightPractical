public class MOB implements Attributes {
    final String name;
    protected int hitModifier;
    protected int armor;
    protected int maxHP;
    protected int damage;
    protected DiceType damageDie;

    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie){
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public int getHP(){
        return getMaxHP() - getDamage();
    }

    public int getDamage(){
        return damage;
    }

    public String getName(){
        return name;
    }

    public void addDamage(int damage){
        this.damage += damage;
    }

    public void resetDamage(){
        this.damage = 0;
    }

    public String toString(){
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("| Health: %-5d  Damage: %-4d|%n", getHP(), getDamage())  +
                String.format("|        Armor: %-13d|%n", getArmor()) +
                "|                            |\n" +
                "+============================+\n";
    }

    public MOB copy(){
        return new MOB(name, getHP(), armor, hitModifier, damageDie);
    }

}
