public class CSVGameData extends GameData {
    private int id = 1;

    public CSVGameData(String gameData, String saveData){
        loadGameData(gameData);
        loadSaveData(saveData);
    }

    public void loadSaveData(String saveData){  //id, name, hp, armor, hitmodifier, damageDie, xp
        CSVReader reader = new CSVReader(saveData,false);
        DiceType diceType;
        while(reader.hasNext()){
            StringBuilder tmp = new StringBuilder();
            tmp.append(reader.getNext().toString());

            String name = tmp.substring(1, tmp.indexOf(",")); tmp.delete(0,tmp.indexOf(",") + 2);
            int hp = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0,tmp.indexOf(",") + 2);
            int armor = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0,tmp.indexOf(",") + 2);
            int hitModifier = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0,tmp.indexOf(",") + 2);
            String damageDie = tmp.substring(0, tmp.indexOf(",")); tmp.delete(0,tmp.indexOf(",") + 2);
            int xp = Integer.parseInt(tmp.substring(0, tmp.length()-1));
            knights.add(new Knight(id, name, hp, armor, hitModifier, DiceType.valueOf(damageDie), xp));
            id++;
        }
    }

    public void loadGameData(String gameData){
        CSVReader reader = new CSVReader(gameData, false);
        while(reader.hasNext()){
            String name; int hp; int armor; int hitModifier; DiceType diceType; // MOB
            StringBuilder tmp = new StringBuilder(reader.getNext().toString());
            String type = tmp.substring(1, tmp.indexOf(",")); tmp.delete(0, tmp.indexOf(",") + 2);
            if(type.equalsIgnoreCase("MOB")){
                name = tmp.substring(0, tmp.indexOf(",")); tmp.delete(0, tmp.indexOf(",")+2);
                hp = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0, tmp.indexOf(",")+2);
                armor = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0, tmp.indexOf(",")+2);
                hitModifier = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0, tmp.indexOf(",")+2);
                diceType = DiceType.valueOf(tmp.substring(0, tmp.length()-1));
                super.monsters.add(new MOB(name, hp, armor, hitModifier, diceType));
            }
            else if (type.equalsIgnoreCase("FORTUNE")){
                name = tmp.substring(0, tmp.indexOf(",")); tmp.delete(0, tmp.indexOf(",")+2);
                hp = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0, tmp.indexOf(",")+2);
                armor = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0, tmp.indexOf(",")+2);
                hitModifier = Integer.parseInt(tmp.substring(0, tmp.indexOf(","))); tmp.delete(0, tmp.indexOf(",")+2);
                if(tmp.substring(0, tmp.length()-1).contains("D")){
                diceType = DiceType.valueOf(tmp.substring(0, tmp.length()-1));
                super.fortunes.add(new Fortune(name, hp, armor, hitModifier, diceType));
                }
                else{
                    super.fortunes.add(new Fortune(name,hp, armor, hitModifier));
                }
            }
        }
    }

    @Override
    public void save(String filename) {

    }

}
