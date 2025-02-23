//  Дан лист String. Необходимо определить, есть ли в данном листе повторяющиеся объекты.
//  (данный метод можно реализовать в общем виде, для листа любых объектов)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        List<String> personList = List.of("Karl", "David", "Karl", "John", "David", "Erick");
        System.out.println("\t" + personList);
        System.out.println("\tList has duplicates: " + duplicates(personList));

        // Task 2
        System.out.println("\nTask 2");
        List<String> team1 = new ArrayList<>(List.of("Karl", "David", "John", "Erick", "Elena"));
        List<String> team2 = new ArrayList<>(List.of("Karl", "Robert", "Jack", "Elena", "Simon"));

        Set<String> allEmployees = new HashSet<>();
        allEmployees.addAll(team1);
        allEmployees.addAll(team2);
        System.out.println("\t" + team1 + "\n\t" + team2);
        System.out.println("\tResult: " + allEmployees);

        // Task 3
        System.out.println("\nTask 3");
        String listOfNames = "Jack,John,Nick,John";
        System.out.println("\t[" + listOfNames + ']');
        System.out.println("\tResult: " + removeDuplicates(listOfNames));

        // Task 4
        System.out.println("\nTask 4");
        List<Person> list1 = List.of(new Person("Alice", 30), new Person("Jack", 25), new Person("John", 35));
        List<Person> list2 = List.of(new Person("Jack", 25), new Person("John", 35), new Person("David", 40));
        Set<Person> setList1 = new HashSet<>(list1);
        Set<Person> setList2 = new HashSet<>(list2);
        setList1.retainAll(setList2);

        System.out.println("\t" + list1);
        System.out.println("\t" + list2);
        System.out.println("\tResult: " + setList1);

        // Task 5
        System.out.println("\nTask 5");
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

    // Task 3
    public static Set<String> removeDuplicates(String listOfNames) {
        String[] namesArray = listOfNames.split(",");
        return new HashSet<>(Arrays.asList(namesArray));
    }
}