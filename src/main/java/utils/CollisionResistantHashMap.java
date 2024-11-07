package utils;

import java.util.ArrayList;

public class CollisionResistantHashMap<K, V> {
    private java.util.ArrayList<Entry<K,V>>[] map = new java.util.ArrayList[103];
    private int count = 0;
    private static final double LOAD_FACTOR = 0.75;
    private static final int EXPANSION_FACTOR = 3;

    public CollisionResistantHashMap() {

    }

    private boolean hasCapacity(){
        return count < map.length*LOAD_FACTOR;
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % map.length;
    }

    private void updateMap(){
        java.util.ArrayList<Entry<K,V>>[] oldMap = map;
        map = new java.util.ArrayList[map.length*EXPANSION_FACTOR];
        // todo: For each element in original map, re-add to new map.
    }

    public V put(K key, V value){
        // Validation
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
        if(!hasCapacity()){
            updateMap();
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

    public V get(K key){
        // Validation
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }

        int pos = hash(key);
        if(map[pos] == null){
            return null;
        }

        int index = map[pos].indexOf(new Entry(key, null));
        if(index == -1){
            return null;
        }

        Entry<K, V> match = map[pos].get(index);
        return match.value;
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
