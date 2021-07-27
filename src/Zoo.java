import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * entity keep state of Zoo and provide service desk functionality
 * @checkInAnimal method add Animal to Zoo
 * should throw exception when Zoo can't provide place
 * @checkOutAnimal method remove Animal from Zoo
 * @getHistory - method show log of check in and check out
 */
public interface Zoo {
    void checkInAnimal(Animal animal) throws IllegalArgumentException;
    void checkOutAnimal(Animal animal) throws IllegalArgumentException;
    HashMap<String, InhibitionLog> getHistory();
    HashMap<Integer, Cage> getCages();
    HashMap<String, Animal> getAnimals();
    HashMap<String, Integer> getAnimalsInCagesMap();
}