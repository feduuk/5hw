import java.util.*;

public class ZooImpl implements Zoo{

    final private HashMap<Integer, Cage> cages;
    final private HashMap<String, Animal> animals;
    final private HashMap<String, Integer> animalsInCagesMap;
    final private HashMap<String, InhibitionLog> logs;

    public ZooImpl(HashMap<Integer, Cage> cages) {
        this.cages = cages;
        animals = new HashMap<String, Animal>();
        animalsInCagesMap = new HashMap<>();
        logs = new HashMap<>();
    }

    @Override
    public void checkInAnimal(Animal animal) throws IllegalArgumentException {
        for(String nameOfAnimal : animals.keySet()){
            if(nameOfAnimal.equals(animal.getName()))
            {
                throw new IllegalArgumentException("Such name already in use!!!");
            }
        }
        for(Cage cage : cages.values()){                                                    //iterates through cages
            for(int j = 0; j < cage.getCondition().isAvailableFor().size(); j++){           //iterates through species available for cage

                if(cage.getCondition().isAvailableFor().get(j) == animal.getSpecies()){     //check if species is correct
                    if(cage.isVacantCage()){                                                //check if cage isn't occupied
                        cage.setCage(true);
                        animals.put(animal.getName(), animal);
                        animalsInCagesMap.put(animal.getName(), cage.getNumber());
                        logs.put(animal.getName(), new InhibitionLog(new Date(), animal.getSpecies(), animal.getName()));
                        return;
                    }else{
                        throw new IllegalArgumentException("Cage for an animal of that species is occupied!!!");
                    }
                }
            }
        }
        throw new IllegalArgumentException("There is no cage for such species!!!");
    }

    @Override
    public void checkOutAnimal(Animal animal) throws IllegalArgumentException {
        String name = animal.getName();
        if(animalsInCagesMap.containsKey(name)){
            int number = animalsInCagesMap.get(name);
            cages.get(number).setCage(false);
            animals.remove(name);
            animalsInCagesMap.remove(name);
            logs.get(name).setCheckOutDate(new Date());
        }else {
            throw new IllegalArgumentException("There's no such animal!!!");
        }
    }

    @Override
    public HashMap<String, InhibitionLog> getHistory() {
        return logs;
    }

    @Override
    public HashMap<Integer, Cage> getCages() {
        return cages;
    }

    @Override
    public HashMap<String, Animal> getAnimals() {
        return animals;
    }

    @Override
    public HashMap<String, Integer> getAnimalsInCagesMap() {
        return animalsInCagesMap;
    }

}
