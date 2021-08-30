public class CombatEngine {
    GameData data;
    GameView view;

    public CombatEngine(GameData data, GameView view){
        this.data = data;
        this.view = view;
    }

    public void initialize(){
        data.getRandomFortune();
    }

}
