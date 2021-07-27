import java.util.*;

public class FedyaSharov {

    public static void main(String[] args) {

        CagesFactory cages = new CagesFactory();
        cages.add(1, 100, Species.LION)
                .add(2, 100, Species.GIRAFFE)
                .add(3, 100, Species.SQUIRREL)
                .add(4, 100, Species.PENGUIN);
        Zoo zoo = new ZooImpl(cages.getCages());
        new Parser().parse(zoo);

    }
}
