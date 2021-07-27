import java.util.*;

public class Parser {
    private Zoo zoo;
    public void parse(Zoo zoo){
        this.zoo = zoo;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Zoo!\n" +
                "You can use 5 types of operations:\n" +
                "check-in <species of animal> <name of animal>\n" +
                "check-out <name of animal>\n" +
                "status\n" +
                "log\n" +
                "exit\n" +
                "--------------------------------------------");
        String command = null;
        boolean isRunning = true;
        while(isRunning){
            command = scan.nextLine();
            if(command.split(" ").length == 0)
            {
                System.out.println("Please enter a valid command!!!");
                continue;
            }


            switch(command.split(" ")[0]){
                case("status"):
                    if(command.split(" ").length > 1){
                        System.out.println("Command check-out entered incorrectly!!!");;
                        continue;
                    }
                    HashMap<String, Integer> animalsInCagesMap = zoo.getAnimalsInCagesMap();
                    for(Map.Entry<String, Integer> me : animalsInCagesMap.entrySet()){
                        System.out.println("cage#" + me.getValue() + " contains " + me.getKey());
                    }
                    break;
                case("log"):
                    if(command.split(" ").length > 1){
                        System.out.println("Command check-out entered incorrectly!!!");;
                        continue;
                    }
                    HashMap<String, InhibitionLog> logs = zoo.getHistory();
                    List<InhibitionLog> list = new ArrayList<>();
                    for(Map.Entry<String, InhibitionLog> me : logs.entrySet()){
                        list.add(me.getValue());
                    }

                    for(InhibitionLog log : list){
                        System.out.println(log);
                    }
                    break;
                case("exit"):
                    if(command.split(" ").length > 1){
                        System.out.println("Command check-out entered incorrectly!!!");;
                        continue;
                    }
                    isRunning = false;
                    break;
                case("check-in"):
                    if(command.split(" ").length != 3){
                        System.out.println("Command check-out entered incorrectly!!!");
                        continue;
                    }

                    String name = command.split(" ")[2];

                    String species = command.split(" ")[1];
                    Animal animalForEntering = null;
                    if(species.equals(Lion.class.getName())){

                        animalForEntering = new Lion(name, Species.LION);

                    } else if(species.equals(Giraffe.class.getName())){

                        animalForEntering = new Giraffe(name, Species.GIRAFFE);

                    } else if(species.equals(Squirrel.class.getName())){

                        animalForEntering = new Squirrel(name, Species.SQUIRREL);

                    } else if(species.equals(Penguin.class.getName())){

                        animalForEntering = new Penguin(name, Species.PENGUIN);

                    } else{
                        System.out.println("There is no such species!!!");
                        continue;
                    }

                    try {
                        zoo.checkInAnimal(animalForEntering);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case("check-out"):
                    if(command.split(" ").length != 2){
                        System.out.println("Command check-out entered incorrectly!!!");;
                        continue;
                    }
                    String nameOfAnimal = command.split(" ")[1];
                    Animal animalForExiting = null;

                    HashMap<String, Animal> animals = zoo.getAnimals();
                    if(animals.containsKey(nameOfAnimal)){
                        animalForExiting = animals.get(nameOfAnimal);
                    } else{
                        System.out.println("There is no such animal!!!");
                        continue;
                    }

                    try {
                        zoo.checkOutAnimal(animalForExiting);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Please enter a valid command!!!");

            }
        }
    }
}
