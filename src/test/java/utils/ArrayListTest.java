package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void add_EmptyList() {
        ArrayList myList = new ArrayList();
        int value = 5;
        myList.add(value);

        assertEquals(1, myList.size());

        int retrieved = myList.get(0);
        assertEquals(value, retrieved);
    }

    @Test
    void add_PopulatedList() {
        ArrayList myList = new ArrayList();
        int [] values = {1, 5, 7, 9};
        for (int value : values) {
            myList.add(value);
        }

        assertEquals(values.length, myList.size());

        for (int i = 0; i < myList.size(); i++) {
            int retrieved = myList.get(i);
            assertEquals(values[i], retrieved);
        }
    }

    @Test
    void add_PopulatedList_GrowRequired() {
        ArrayList myList = new ArrayList();

        int [] values = new int[11];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }

        for (int value : values) {
            myList.add(value);
        }

        assertEquals(values.length, myList.size());

        for (int i = 0; i < myList.size(); i++) {
            int retrieved = myList.get(i);
            assertEquals(values[i], retrieved);
        }
    }
}