import java.util.ArrayList;
import java.util.HashMap;

class Animal {
    private String name;
    private int age;
    private String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

class Hyena extends Animal {
    private String color;
    private int weight;
    private String birthSeason;
    private String origin;

    public Hyena(String name, int age, String color, int weight, String birthSeason, String origin) {
        super(name, age, "Hyena");
        this.color = color;
        this.weight = weight;
        this.birthSeason = birthSeason;
        this.origin = origin;
    }

    // Getters and Setters for Hyena specific attributes
}

class Lion extends Animal {
    // Similar to Hyena, but with Lion-specific attributes
}

class Tiger extends Animal {
    // Similar to Hyena, but with Tiger-specific attributes
}

class Bear extends Animal {
    // Similar to Hyena, but with Bear-specific attributes
}

public class Main {
    public static void main(String[] args) {
        // Creating ArrayList for storing animal instances
        ArrayList<Animal> animals = new ArrayList<>();

        // Creating HashMap for counting species
        HashMap<String, Integer> speciesCount = new HashMap<>();

        // Adding animal instances to ArrayList and counting species
        // Example:
        animals.add(new Hyena("Shenzi", 4, "tan", 70, "spring", "Friguia Park, Tunisia"));
        animals.add(new Lion("Scar", 12, "dark tan", 375, "winter", "KopeLion, Tanzania"));
        animals.add(new Tiger("Tony", 2, "gold and tan stripes", 270, "spring", "Dhaka, Bangladesh"));
        animals.add(new Bear("Yogi", 7, "brown", 320, "spring", "Alaska Zoo, Alaska"));

        for (Animal animal : animals) {
            // Counting species
            speciesCount.put(animal.getSpecies(), speciesCount.getOrDefault(animal.getSpecies(), 0) + 1);
        }

        // Printing species count
        System.out.println("Species count:");
        for (String species : speciesCount.keySet()) {
            System.out.println(species + ": " + speciesCount.get(species));
        }
    }
}

