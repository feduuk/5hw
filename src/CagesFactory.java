import java.util.HashMap;

public class CagesFactory {

    HashMap<Integer, Cage> cages;
    CagesFactory(){
        cages = new HashMap<>();
    }
    public CagesFactory add(int number, int area, Species species){
        cages.put(number, new CageImpl(number, area, new ConditionImpl(species)));
        return this;
    }
    public HashMap<Integer, Cage> getCages(){
        return cages;
    }
}
