package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequencedCollectionTest {

    @Test
    public void testCollectionLastItem() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertEquals(5, numbers.getLast());
    }

    @Test
    public void testLinkedHashSetFirstItem() {
        LinkedHashSet<Integer> integers = new LinkedHashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        assertEquals(1, integers.getFirst());
    }
}
