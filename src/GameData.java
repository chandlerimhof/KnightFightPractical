import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

abstract class GameData {
    protected Random random = new Random();
    protected ArrayList<Fortune> fortunes = new ArrayList<Fortune>();
    protected ArrayList<MOB> monsters = new ArrayList<MOB>();
    protected ArrayList<Knight> knights = new ArrayList<Knight>();
    protected ArrayList<Knight> activeKnights = new ArrayList<Knight>(4);

    public ArrayList<Knight> getKnights() {
        return knights;
    }

    public ArrayList<Knight> getActiveKnights() {
        return activeKnights;
    }

    public Knight getActive(String nameOrID){
        return findKnight(nameOrID, activeKnights);
    }

    public Knight getKnight(String nameOrID) {
        return findKnight(nameOrID, knights);
    }

    public Knight findKnight(String nameOrID, ArrayList<Knight> list) {
        for (Knight k : list) {
            if (k.name.equalsIgnoreCase(nameOrID)|| k.name.toLowerCase().contains(nameOrID.toLowerCase()) || k.id.toString().equalsIgnoreCase(nameOrID))
                return k;
        }
        return null;
    }
    public boolean setActive(Knight kt){
        if (activeKnights.size() < 4){
                activeKnights.add(kt);
                return true;
        }
        if (activeKnights.size() >= 4){
            System.out.println("Unable to set active knight. Only four can be active at a time");
        }
        return false;
    }

    public void removeActive(Knight kt){
        kt.resetDamage();
        activeKnights.remove(kt);
    }

    public Fortune getRandomFortune(){
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    public ArrayList<MOB> getRandomMonsters() {
        ArrayList<MOB> list = new ArrayList<MOB>();
        while (list.size() <= activeKnights.size()) {
            list.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return list;
    }

    public ArrayList<MOB> getRandomMonsters(int number) {
        ArrayList<MOB> list = new ArrayList<MOB>();
        for (int i = 0; i < number; ++i){
            list.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return list;
    }

    public abstract void save(String filename);

}
