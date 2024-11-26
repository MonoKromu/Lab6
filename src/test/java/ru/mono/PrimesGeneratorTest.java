package ru.mono;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PrimesGeneratorTest {

    @Test
    void outputTest() {
        ArrayList<Integer> expectedPrimeNumbers = new ArrayList<>(Arrays.asList(
                new Integer[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71}));

        ArrayList<Integer> actualPrimeNumbers = new ArrayList<>();
        PrimesGenerator generator = new PrimesGenerator(20);
        Iterator<Integer> iterator = generator.iterator();
        while(iterator.hasNext()) actualPrimeNumbers.add(iterator.next());

        assertEquals(expectedPrimeNumbers, actualPrimeNumbers);
        System.out.println(actualPrimeNumbers);
        System.out.println(actualPrimeNumbers.reversed());
    }
}