package utils;

import model.Person;

public class FamilyMap extends CollisionResistantHashMap<Person, Person>{
    protected int hash(Person p){
        return Math.abs(p.getLastName().hashCode()) % map.length;
    }
}
