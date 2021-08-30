import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView implements GameView {
    Scanner scnr = new Scanner(System.in);

    @Override
    public void splashScreen() {
        System.out.print("Knight Fight Legend\n" +
                "     _,.\n" +
                "   ,` -.)\n" +
                "  ( _/-\\-._\n" +
                " /,|`--._,-^|           ,\n" +
                " \\_| |`-._/||          ,'|\n" +
                "   |  `-, / |         /  /\n" +
                "   |     || |        /  /\n" +
                "    `r-._||/   __   /  /\n" +
                " __,-<_     )`-/  `./  /\n" +
                " '  \\   `---'   \\   /  /\n" +
                "     |           |./  /\n" +
                "     /           //  /\n" +
                " \\_/' \\         |/  /\n" +
                "  |    |   _,^-'/  /\n" +
                "  \\    , ``  (\\/  /_\n" +
                "   (  /   `-._/x/^`\n" +
                "    `Y-.____(__}\n" +
                "     |     {__)\n" +
                "           ()\n" +
                "        by\n" +
                "  Round Table Games\n");
    }

    @Override
    public void endGame() {
        System.out.println("Thank you for played! Goodbye!");
        scnr.close();
    }

    @Override
    public String displayMainMenu() {
        System.out.println("What would you like to do?");
        return scnr.nextLine();
    }

    @Override
    public void printHelp() {
        System.out.println(
            "Unsure what to do, here are some options:\n" +
                "ls or list all  - listing the knights\n" +
                "list active  - list the active knights knights only\n" +
                "show name or id - show the knight details card\n" +
                "set active name or id - set knight as active (note: only 4 knights can be active) \n" +
                "remove active name or id - remove a knight from active status (heals knight)\n" +
                "explore or adventure or quest - find random monsters to fight\n" +
                "save filename - save the game to the file name (default: saveData.csv)\n" +
                "exit or goodbye - to leave the game\n" +
                "\n" +
                "Game rules: You can have four active knights. As long as they are active, they won't heal, \n" +
                "but they can gain XP by going on adventures.\n" +
                "When you make a knight inactive, they will heal. How many monsters can you defeat \n" +
                "before, you have to heal? ");

    }

    @Override
    public void listKnights(ArrayList<Knight> list) {
        int i = 1;
        if (list.size() != 0){
            for (Knight k : list) {
                System.out.println(i + ": " + k.name);
                i++;
            }
        } else {
            System.out.println("No knights to list");
        }
    }

    @Override
    public void knightNotFound() {
        System.out.println("Knight not found!");
    }

    @Override
    public void showKnight(Knight k) {
        System.out.println(k.toString());
        System.out.println();
    }

    @Override
    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time");
    }

    @Override
    public void printBattleText(ArrayList<MOB> m, ArrayList<Knight> k) {
        for (Knight k1 : k){if(k1 == null)

        System.out.println("Our heroes come across the following monsters. Prepare for Battle!\n");
        for (int i = 0; i < 4; ++i){
            System.out.printf("%-30s%s\n", k.get(i).name, m.get(i).name);
        }

    }

    @Override
    public void printBattleText(MOB m) {
            String name = m.get(0).name;
            System.out.println(name + " was defeated!");
        }

    }

    @Override
    public void printFortunes(ArrayList<Knight> k) {

    }

    @Override
    public boolean checkContinue() {
        return false;
    }

    @Override
    public void printDefeated() {

    }
}
