package applications;

import model.Person;
import utils.CollisionResistantHashMap;
import utils.FamilyMap;

public class UsingFamilyMap {
    private static CollisionResistantHashMap<Integer, Person> people = new CollisionResistantHashMap<>();
    private static FamilyMap families = new FamilyMap();

    private static Person[] generatePeople(){
        Person p1 = new Person("Karen", "Wilkens", 34);
        Person p2 = new Person("Frank", "Wilkens", 21);
        Person p3 = new Person("Tommy", "Wilkens", 3);
        Person p4 = new Person("JJ", "Wilkens", 1);
        Person p5 = new Person("Astrid", "Franklyn", 87);

        return new Person[] {p1, p2, p3, p4, p5};
    }

    public static void main(String[] args) {
        Person [] peopleDataSet = generatePeople();

        for (Person person : peopleDataSet) {
            people.put(person.getId(), person);
            families.put(person, person);
        }

        people.display();
        families.display();
    }
}
