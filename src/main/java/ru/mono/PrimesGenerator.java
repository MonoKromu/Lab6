package ru.mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterable<Integer>{
    Integer[] primes;
        PrimesGenerator(int count){
            primes = new Integer[count];
            generate(count);
    }

    private void generate(int n){
        int count = 0;
        int number = 2;
        while(count<n){
            if(isPrime(number)){
                primes[count] = number;
                count++;
            }
            number++;
        }
    }

    private boolean isPrime(int num){
        boolean prime = true;
        for(Integer i : primes){
            if(i == null || i > Math.sqrt(num)) break;
            if(i != 0 && num % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesGeneratorIterator();
    }

    public class PrimesGeneratorIterator implements Iterator<Integer>{
        private int counter;

        @Override
        public boolean hasNext() {
            return counter < primes.length;
        }

        @Override
        public Integer next() {
            if(!hasNext()) throw new NoSuchElementException();
            return primes[counter++];
        }
    }
}
