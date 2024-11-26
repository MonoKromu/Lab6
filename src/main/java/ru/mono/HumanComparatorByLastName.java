package ru.mono;

import java.util.Comparator;

public class HumanComparatorByLastName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
