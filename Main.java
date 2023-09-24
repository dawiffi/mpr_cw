import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person(21, "Dawid");

        Person person2 = new Person(87, "Andrzej");

        Person person3 = new Person(50, "Piotr");

        Person person4 = null;
        try{
            person4 = new Person (-20, "Jan");
        } catch (InvalidAgeException e){
            System.out.println("Zlapano wyjatek: " + e.getMessage());
        }

        Person person5 = null;
        try{
            person5 = new Person (102, "Krzysztof");
        } catch (InvalidAgeException e){
            System.out.println("Zlapano wyjatek: " + e.getMessage());
        }

        System.out.println("Imie: " + person1.getName());
        System.out.println("Wiek: " + person1.getAge());

        List<Person> personList = List.of(person1, person2, person3);
        List<Person> anotherPersonList = new ArrayList<>();

        anotherPersonList.add(person1);
        anotherPersonList.add(person2);
        anotherPersonList.add(person3);

        System.out.println("PersonList:" + personList);
        System.out.println("anotherPersonList:" + anotherPersonList);

        Set<Person> personSet = Set.of(person1, person2, person3);
        Set<Person> anotherPersonSet = new HashSet<>();

        anotherPersonSet.add(person1);
        anotherPersonSet.add(person2);
        anotherPersonSet.add(person3);

        System.out.println("Set 1: " + personSet);
        System.out.println("Set 2: " + anotherPersonSet);

        Map<Integer, Person> personMap = Map.of(1, person1, 2, person2, 3, person2);
        Map<Integer, Person> anotherPersonMap = new HashMap<>();

        anotherPersonMap.put(1, person1);
        anotherPersonMap.put(2, person2);
        anotherPersonMap.put(1, person2);
        anotherPersonMap.put(3, person3);

        System.out.println("Map 1: " + personMap);
        System.out.println("Map 2: " + anotherPersonMap);

        List<Integer> ageList = personList.stream()
                .map(Person::getAge).collect(Collectors.toList());

        System.out.println(ageList);

        int result = ageList.stream()
                .reduce(0, (sum, value) -> sum + value);

        System.out.println("Suma wieku: " + result);

        //4.2
        List<String> peopleNames = personList.stream()
                .map(Person::getName).collect(Collectors.toList());

        System.out.println("Imiona ludzi: " + peopleNames);

        //4.3
        List<Person> peopleOverTwentyFive = personList.stream()
                .filter(a -> 25 < a.getAge()).collect(Collectors.toList());
        System.out.println("Ludzie powyzej 25 wieku zycia: " + peopleOverTwentyFive);

        //4.4
        List<String> peopleNamesSorted = personList.stream()
                .map(Person::getName)
                .sorted().collect(Collectors.toList());
        System.out.println("Imiona posortowane alfabetycznie: " +peopleNamesSorted);

        //4.5
        List<Person> peopleForEachPrint = personList.stream()
                .forEach(p -> {System.out.print("Imie: " + p.getName() + "Wiek: " + p.getAge());
                }); // nie dziala
    }
}
