import java.io.*;
import java.util.*;

class Animal {
    private String name;
    private int age;
    private String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

class Hyena extends Animal {
    private String uniqueFeature;

    public Hyena(String name, int age, String species, String uniqueFeature) {
        super(name, age, species);
        this.uniqueFeature = uniqueFeature;
    }

    public String getUniqueFeature() {
        return uniqueFeature;
    }

    public void setUniqueFeature(String uniqueFeature) {
        this.uniqueFeature = uniqueFeature;
    }
}

class Lion extends Animal {
    private String uniqueFeature;

    public Lion(String name, int age, String species, String uniqueFeature) {
        super(name, age, species);
        this.uniqueFeature = uniqueFeature;
    }

    public String getUniqueFeature() {
        return uniqueFeature;
    }

    public void setUniqueFeature(String uniqueFeature) {
        this.uniqueFeature = uniqueFeature;
    }
}

class Tiger extends Animal {
    private String uniqueFeature;

    public Tiger(String name, int age, String species, String uniqueFeature) {
        super(name, age, species);
        this.uniqueFeature = uniqueFeature;
    }

    public String getUniqueFeature() {
        return uniqueFeature;
    }

    public void setUniqueFeature(String uniqueFeature) {
        this.uniqueFeature = uniqueFeature;
    }
}

class Bear extends Animal {
    private String uniqueFeature;

    public Bear(String name, int age, String species, String uniqueFeature) {
        super(name, age, species);
        this.uniqueFeature = uniqueFeature;
    }

    public String getUniqueFeature() {
        return uniqueFeature;
    }

    public void setUniqueFeature(String uniqueFeature) {
        this.uniqueFeature = uniqueFeature;
    }
}

public class AnimalReport {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        HashMap<String, Integer> speciesCount = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("arrivingAnimals.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String species = parts[2];
                String uniqueFeature = parts[3];

                Animal animal;
                switch (species) {
                    case "Hyena":
                        animal = new Hyena(name, age, species, uniqueFeature);
                        break;
                    case "Lion":
                        animal = new Lion(name, age, species, uniqueFeature);
                        break;
                    case "Tiger":
                        animal = new Tiger(name, age, species, uniqueFeature);
                        break;
                    case "Bear":
                        animal = new Bear(name, age, species, uniqueFeature);
                        break;
                    default:
                        animal = new Animal(name, age, species);
                }

                animals.add(animal);

                speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("newAnimals.txt"));
            for (Animal animal : animals) {
                bw.write(animal.getSpecies() + ": " + animal.getName() + ", " + animal.getAge() + ", " + ((animal instanceof Hyena) ? ((Hyena) animal).getUniqueFeature() : "") + "\n");
            }

            for (Map.Entry<String, Integer> entry : speciesCount.entrySet()) {
                bw.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
