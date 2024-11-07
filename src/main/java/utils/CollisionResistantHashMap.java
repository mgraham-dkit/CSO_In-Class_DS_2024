package utils;

import java.util.ArrayList;

public class CollisionResistantHashMap<K, V> {
    private java.util.ArrayList<Entry<K,V>>[] map = new java.util.ArrayList[103];
    private int count = 0;

    public CollisionResistantHashMap() {

    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % map.length;
    }

    public V put(K key, V value){
        // Validation
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
        // Calculate appropriate slot/bucket for use based on key
        int pos = hash(key);

        // If slot/bucket is null, it has never been used.
        // Add a new list and add new Entry
        if(map[pos] == null) {
            map[pos] = new ArrayList<>();
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        int index = map[pos].indexOf(newEntry);
        if(index != -1){
            Entry<K, V> toBeUpdated = map[pos].get(index);
            V replaced = toBeUpdated.value;
            toBeUpdated.value = value;
            return replaced;
        }

        map[pos].add(newEntry);
        count++;
        return null;
    }


    private static class Entry<K, V>{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key.equals(entry.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
