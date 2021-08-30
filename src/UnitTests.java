import java.sql.SQLOutput;

public class UnitTests{
    public static void runTests(){
        System.out.println("UNIT TESTS FOR KNIGHT FIGHT REVAMP PROJECT");
        System.out.println("..................................................");

        //testDice();
        //testFortune();
        //testMOB();
        //testKnight();
        //testGameData();
        consoleViewTest();
    }

    public static void testDice(){
        DiceType dice1 = DiceType.D10;
        DiceType dice2 = DiceType.D20;
        System.out.println(dice1.toString());
        DiceSet diceSet1 = new DiceSet();
        DiceSet diceSet2 = new DiceSet();
        System.out.printf("Rolling %s Dice:\n", dice1.toString());
        for(int i = 0; i < 100; ++i){
            System.out.println(diceSet1.roll(dice1));
        }

        System.out.printf("Rolling %s Dice:\n", dice2.toString());
        for(int i = 0; i < 10; ++i){
            System.out.println(diceSet2.roll(dice2));
        }

    }

    public static void testFortune(){
        System.out.println("PROWESS FORTUNE - Testing:");
        Fortune f1 = new Fortune("Prowess",0,0,2, DiceType.D12);
        System.out.println("Armor: " + f1.getArmor());
        System.out.println("Hit Modifier: " + f1.getHitModifier());
        System.out.println("Max HP: " + f1.getMaxHP());
        System.out.println("Name: " + f1.getName());
        System.out.println(f1.toString());
    }

    public static void testMOB(){
        System.out.println("\n -------------TESTING MOB-------------\n");
        MOB m1 = new MOB("Faruk", 150, 150, 7, DiceType.D20);
        System.out.println("Armor: " + m1.getArmor());
        System.out.println("Hit Modifier: " + m1.getHitModifier());
        System.out.println("Max HP: " + m1.getMaxHP());
        System.out.println("Name: " + m1.getName());
        System.out.println(m1.toString());

    }

    public static void testKnight(){
        System.out.println("\n -------------TESTING KNIGHT-------------\n");
        Knight k1 = new Knight(12,"Arthur",40,16,2,DiceType.D8,0);
        System.out.println("Armor: " + k1.getArmor());
        System.out.println("Hit Modifier: " + k1.getHitModifier());
        System.out.println("Max HP: " + k1.getMaxHP());
        System.out.println("Name: " + k1.getName());
        System.out.println(k1.toString());
        System.out.println(k1.toCSV());
    }


    public static void testGameData(){
        CSVGameData c1 = new CSVGameData("src/gamedata.csv", "src/knights.csv");
        c1.getRandomMonsters();
        c1.getRandomMonsters().size();
        System.out.println(c1.getRandomMonsters().size());
        System.out.println(c1.getRandomMonsters());
    }

    public static void consoleViewTest(){
        CSVGameData c1 = new CSVGameData("src/gamedata.csv", "src/knights.csv");
        ConsoleView v1 = new ConsoleView();
        v1.splashScreen();
        v1.listKnights(c1.knights);
        v1.showKnight(c1.knights.get(0));
        v1.printBattleText(c1.monsters, c1.activeKnights);
    }

}