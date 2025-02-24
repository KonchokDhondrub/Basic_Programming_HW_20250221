//  Дан лист String. Необходимо определить, есть ли в данном листе повторяющиеся объекты.
//  (данный метод можно реализовать в общем виде, для листа любых объектов)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1 - Get answer if List have duplicated objects");
        List<String> personList = List.of("Karl", "David", "Karl", "John", "David", "Erick");
        System.out.println("\t" + personList);
        System.out.println("\tList has duplicates: " + duplicates(personList));

        // Task 2
        System.out.println("\nTask 2 - Get List of not duplicated Persons from two Lists");
        List<Person> team1 = List.of(new Person("Karl", 33), new Person("David", 24),
                new Person("John", 30), new Person("Erick", 33), new Person("Elena", 45));
        List<Person> team2 = List.of(new Person("Karl", 33), new Person("Robert", 39),
                new Person("Jack", 22),   new Person("Simon", 44), new Person("Elena", 45));

        System.out.println("\tList 1: " + team1 + "\n\tList 2: " + team2);
        System.out.println("\tResult: " + allEmployees(team1, team2));

        // Task 3
        System.out.println("\nTask 3 - Get List of not duplicated objects from String");
        String listOfNames = "Jack,John,Nick,John";
        System.out.println("\tString: [" + listOfNames + ']');
        removeDuplicates(listOfNames);

        // Task 4
        System.out.println("\nTask 4 - Get Set of duplicated Persons from both lists");
        List<Person> list1 = List.of(new Person("Alice", 30), new Person("Jack", 25), new Person("John", 35));
        List<Person> list2 = List.of(new Person("Jack", 25), new Person("John", 35), new Person("David", 40));

        System.out.println("\tList 1: " + list1);
        System.out.println("\tList 2: " + list2);
        System.out.println("\tResult: " + retailAll(list1, list2));

        // Task 5
        System.out.println("\nTask 5 - Get Set of duplicated Persons");
        List<Person> listOfPersons = List.of(new Person("Jack", 25), new Person("John", 35),
                new Person("David", 40), new Person("Jack", 25), new Person("David", 40));
        System.out.println("\t" + listOfPersons);
        System.out.println("\tResult: " + findDuplicates(listOfPersons));
    }


    // Task 1
    public static <T> boolean duplicates(List<T> list) {
        Set<T> duplicate = new HashSet<>();
        for (T element : list) {
            if (!duplicate.add(element)) {
                return true;
            }
        }
        return false;
    }

    // Task 2
    public static <T> List<T> allEmployees(List<T> l1, List<T> l2){
        Set<T> allEmployees = new HashSet<>();
        allEmployees.addAll(l1);
        allEmployees.addAll(l2);
        return new ArrayList<>(allEmployees);
    }

    // Task 3
    public static void removeDuplicates(String listOfNames) {
        String[] namesArray = listOfNames.split(",");
        for (String name : namesArray) {
            System.out.println("\t" + name);
        }
    }

    // Task 4
    public static <T> List<T> retailAll(List<T> l1, List<T> l2){
        HashSet<T> setList1 = new HashSet<>(l1);
        setList1.retainAll(l2);
        return new ArrayList<>(setList1);
    }

    // Task 5
    public static <T> Set<T> findDuplicates(List<T> personList) {
        Set<T> duplicates = new HashSet<>();
        Set<T> search = new HashSet<>();
        for (T person : personList) {
            if (!search.add(person)) {
                duplicates.add(person);
            }
        }
        return duplicates;
    }
}