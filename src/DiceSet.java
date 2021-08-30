import java.util.Random;

public class DiceSet {
    public int roll(DiceType diceType){
        Random rnd = new Random();
        int roll;
        int diceSides;
        switch(diceType.toString()){
            case "D4":
                diceSides = 4;
                break;
            case "D6":
                diceSides = 6;
                break;
            case "D8":
                diceSides = 8;
                break;
            case "D10":
                diceSides = 10;
                break;
            case "D12":
                diceSides = 12;
                break;
            case "D20":
                diceSides = 20;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + diceType.toString());
        }
        roll = rnd.nextInt(diceSides + 1);
        if (roll == 0) return roll + 1;
        return roll;
    }
}


