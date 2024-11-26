package ru.mono;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        collectionsDemo(20);
        System.out.println();

        hashSetDemo();
        System.out.println();

        String s = "aaa aaa aaa abc abc www";
        HashMap<String, Integer> wordCounts = Main.getWordCounts(s);
        System.out.println(s);
        System.out.println(wordCounts);
        System.out.println("Unique words: "+wordCounts.size()+"\n");

        HashMap<Integer, String> flippedMap = flipMap(wordCounts);
        System.out.println("Flipped map: "+flippedMap);
    }

    public static void collectionsDemo(int n){
        Integer[] num = new Integer[n];
        while(n!=0){
            num[n-1] = new Random().nextInt(101);
            n--;
        }
        System.out.print("Random numbers array:\t"+Arrays.toString(num)); //A
        List<Integer> numbers = new ArrayList<>(List.of(num));
        System.out.println("\nArray as list:\t"+numbers); //B
        Collections.sort(numbers);
        System.out.println("Sorted list:\t"+numbers); //C
        Collections.reverse(numbers);
        System.out.println("Reversed list:\t"+numbers); //D
        Collections.shuffle(numbers);
        System.out.println("Shuffled list:\t"+numbers); //E
        Collections.rotate(numbers, 1);
        System.out.println("List rotated by 1:\t"+numbers); //F
        Collection<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
        System.out.println("Set (without duplicates):\t"+uniqueNumbers); //G
        List<Integer> dupNumbers = new ArrayList<>(numbers);
        uniqueNumbers.forEach(dupNumbers::remove);
        System.out.println("List with duplicates only:\t"+dupNumbers); //H
        Integer[] array = numbers.toArray(new Integer[0]);
        System.out.println("List to array:\t"+Arrays.toString(array)); //I
        Map<Integer, Integer> numCounts = new HashMap<>();
        for(int i : numbers) numCounts.put(i, numCounts.getOrDefault(i, 0) + 1);
        System.out.println("Number counts:\t"+numCounts); //J
    }

    public static void hashSetDemo(){
        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human("Peter", "Robertson", 35));
        people.add(new Human("Peter", "Robertson", 35));
        people.add(new Human("Peter", "Robertson", 13));
        people.add(new Human("Jim", "Bailey", 21));
        people.add(new Human("Jim", "Moody", 23));
        people.add(new Human("Dennis", "Stevens", 22));
        people.add(new Human("Louise", "Wade", 22));
        HashSet<Human> peopleHashSet = new HashSet<>(people);
        System.out.println(peopleHashSet); //Повторяющиеся элементы в сете удаляются, порядок не сохраняется
        LinkedHashSet<Human> peopleLinkedHashSet = new LinkedHashSet<>(people);
        System.out.println(peopleLinkedHashSet); //Тот же сет, но сохраняется порядок добавления элементов
        TreeSet<Human> peopleTreeSet = new TreeSet<>(people);
        System.out.println(peopleTreeSet); //Отсортированный сет (сравнение по функции compareTo)
        TreeSet<Human> treeSetLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetLastName.addAll(people); //Удалены элементы с одинаковыми фамилиями, так как сравнение только по фамилии
        System.out.println(treeSetLastName);
        Comparator<Human> byAge = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        };
        TreeSet<Human> treeSetAge = new TreeSet<>(byAge); //То же самое но с возрастом
        treeSetAge.addAll(people);
        System.out.println(treeSetAge);
    }

    public static HashMap<String, Integer> getWordCounts(String s){
        ArrayList<String> words = new ArrayList<>(Arrays.asList(s.split(" ")));
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word,0)+1);
        }
        return wordCounts;
    }

    public static <K,V> HashMap<V,K> flipMap(HashMap<K,V> map){
        HashMap<V,K> flip = new HashMap<>();
        ArrayList<K> keys = new ArrayList<>(map.keySet());
        ArrayList<V> values = new ArrayList<>(map.values());
        for(int i=0; i<map.size(); i++) flip.put(values.get(i), keys.get(i));
        return flip;
    }
}