package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void add() {
        ArrayList myList = new ArrayList();
        int value = 5;
        myList.add(value);

        assertEquals(1, myList.size());

        int retrieved = myList.get(0);
        assertEquals(value, retrieved);
    }
}