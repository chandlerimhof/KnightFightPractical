import java.lang.reflect.Array;
import java.util.ArrayList;

public interface GameView{
    public void splashScreen();
    public void endGame();
    public String displayMainMenu();
    public void printHelp();
    public void listKnights(ArrayList<Knight> list);
    public void knightNotFound();
    public void showKnight(Knight k);
    public void setActiveFailed();
    public void printBattleText(ArrayList<MOB> m, ArrayList<Knight> k);
    public void printBattleText(MOB m);
    public void printFortunes(ArrayList<Knight> k);
    public boolean checkContinue();
    public void printDefeated();
}