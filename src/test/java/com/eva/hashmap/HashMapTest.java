package com.eva.hashmap;

import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapTest {

    // Testing HashMap "hasElement" method
    @Test
    public void hasElementCheck() {
        System.out.println("* HashMap JUnit4Test: hasElementCheck()");
        HashMap<Long, Integer> map = new HashMap<>(5);

        // not existent key
        assertNull(map.get(null));
        assertNull(map.get(9223372036854775805L));

        // existent null key
        map.put(null, 0);
        assertTrue(map.get(null) == 0);

        // existent key
        map.put(9223372036854775805L, 1);
        assertTrue(map.get(9223372036854775805L) == 1);
    }

    //Testing HashMap "put/get" methods
    @Test
    public void putGetCheck() {
        System.out.println("* HashMap JUnit4Test: putGetCheck()");
        HashMap<Long, String> map = new HashMap<>(5);

        // null key test
        map.put(null, "nullKey");
        assertNotNull(map.hasElement(null));
        assertEquals(map.get(null), "nullKey");

        Long[] keys = {9223372036854775805L, 9223372036854775806L};

        // insert all the keys inside the HashMap
        for (Long key : keys) {
            map.put(key, "key");
        }

        // check if the keys exist
        for (Long key : keys) {
            assertNotNull(map.hasElement(key));
        }

        // check if the keys have the correct values
        for (Long key : keys) {
            assertEquals(map.get(key), "key");
        }
    }

    // Testing HashMap "toString" method
    @Test
    public void toStringCheck() {
        System.out.println("* HashMap JUnit4Test: toStringCheck()");
        HashMap<Long, Integer> map = new HashMap<>(5);

        assertEquals(map.toString(), "");

        map.put(10000000000L, 1);
        assertEquals(map.toString(), "[index: 2] -> { key: 10000000000 = value: 1}\n");

        map.put(20000000000L, 2);
        assertEquals(map.toString(), "[index: 2] -> { key: 10000000000 = value: 1, key: 20000000000 = value: 2}\n");

        map.put(40000000000L, 4);
        assertEquals(map.toString(), "[index: 2] -> { key: 10000000000 = value: 1, key: 20000000000 = value: 2}\n"
                + "[index: 4] -> { key: 40000000000 = value: 4}\n");
    }
}