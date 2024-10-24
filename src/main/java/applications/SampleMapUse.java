package applications;

import utils.HashMap;

public class SampleMapUse {
    public static void main(String[] args) {
        String a = "Teheran";
        String b = "Siblings";

        System.out.println(a + " hashcode: " + a.hashCode());
        System.out.println(b + " hashcode: " + b.hashCode());

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "Mulready");
        map.put(1, "Ziegler");
        map.put(3, "McGarry");

        // Populate map, overwriting values of some existing keys
        String [] names = {"Baker Lang", "Bailey", "Lyman", "Cregg", "Moss"};
        for (int i = 0; i < names.length; i++) {
            String oldValue = map.put(i, names[i]);
            if(oldValue != null){
                System.out.println(oldValue + " was replaced by " + names[i] + " mapping to key: " + i);
            }
        }

        // Collide with existing data in map, triggering an exception:
        map.put(103, "President Vinnick");
    }
}
