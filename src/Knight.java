public class Knight extends MOB {
    protected final Integer id;
    protected int xp;
    private Fortune fortune;

    public Knight(Integer id, String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        super(name, hp, armor, hitModifier, damageDie);
        this.id = id;
    }

    public Knight(Integer id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitModifier, damageDie);
        this.xp = xp;
        this.id = id;
    }

    public int getXP(){
        return xp;
    }

    public void addXP(int xp){
        this.xp += xp;
    }

    public Integer getId(){
        return id;
    }

    public void setActiveFortune(Fortune f){
        this.fortune = f;
    }

    public Fortune getActiveFortune(){
        return fortune;
    }

    public String toCSV(){
        return String.format("%s,%d,%d,%d,%s,%d", getName(), getMaxHP(), getArmor(), getHitModifier(), getDamageDie(), getXP());
    }

    @Override
    public int getMaxHP(){
        return (getActiveFortune() != null) ? fortune.getMaxHP() + super.getMaxHP() : super.getMaxHP();
    }

    @Override
    public int getArmor(){
        return (getActiveFortune() != null) ? fortune.getArmor() + super.getArmor() : super.getArmor();
    }

    @Override
    public DiceType getDamageDie(){
        return (getActiveFortune() != null) ? fortune.getDamageDie() : super.getDamageDie();
    }
    @Override
    public int getHitModifier(){
        return (getActiveFortune() != null) ? fortune.getHitModifier() + super.getHitModifier() : super.getHitModifier();
    }

    public String toString(){
        return String.format("+============================+\n" +
                "| %-27s|\n" +
                "| id: %-23d|\n" +
                "|                            |\n" +
                "| Health: %-6d  XP: %-7d|\n" +
                "|  Power: %-6s  Armor: %-4d|\n" +
                "|                            |\n" +
                "+============================+ ",
                name, id, getHP(), getXP(), damageDie.toString(), getArmor());
    }













}
