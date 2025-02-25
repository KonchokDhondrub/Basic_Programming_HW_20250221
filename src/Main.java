import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1 - Get answer if List have duplicated objects");
        List<String> personList = List.of("Karl", "David", "Karl", "John", "David", "Erick");
        System.out.println("\t" + personList);
        System.out.println("\tList has duplicates: " + isHaveDuplicates(personList));

        // Task 2
        System.out.println("\nTask 2 - Get List of not duplicated Persons from two Lists");
        List<Person> team1 = List.of(new Person("Karl", 33), new Person("David", 24));
        List<Person> team2 = List.of(new Person("Karl", 33), new Person("Robert", 39));
        List<Person> team3 = List.of(new Person("Eleonora", 32), new Person("Karl", 33));

        System.out.println("\tList 1: " + team1 + "\n\tList 2: " + team2 + "\n\tList 3: " + team3);
        System.out.println("\tResult: " + allEmployeesWithoutDuplicates(team1, team2, team3));

        // Task 3
        System.out.println("\nTask 3 - Get List of not duplicated objects from String");
        String listOfNames = "Jack,John,Nick,John";
        System.out.println("\tString: [" + listOfNames + ']');
        System.out.println("\t" + splittingAndRemoveDuplicates(listOfNames));

        // Task 4
        System.out.println("\nTask 4 - Get Set of duplicated Persons from both lists");
        List<Person> list1 = List.of(new Person("Alice", 30), new Person("Jack", 25), new Person("John", 35));
        List<Person> list2 = List.of(new Person("Jack", 25), new Person("John", 35), new Person("David", 40));

        System.out.println("\tList 1: " + list1);
        System.out.println("\tList 2: " + list2);
        System.out.println("\tResult: " + getSetOfDuplicatedPersons(list1, list2));

        // Task 5
        System.out.println("\nTask 5 - Get Set of duplicated Persons");
        List<Person> listOfPersons = List.of(new Person("Jack", 25), new Person("John", 35),
                new Person("David", 40), new Person("Jack", 25), new Person("David", 40));
        System.out.println("\t" + listOfPersons);
        System.out.println("\tResult: " + getSetOfDuplicatedPersonsFromList(listOfPersons));
    }


    // Task 1 - Test OK
    public static <T> boolean isHaveDuplicates(List<T> list) {
        if (list == null) return false;
        Set<T> set = new HashSet<>(list);
//        for (T element : list) {
//            if (!set.add(element)) {
//                return true;
//            }
//        }
//        return false;
        return set.size() != list.size();
    }

    // Task 2 - Test OK
    public static <E> List<E> allEmployeesWithoutDuplicates(List<E> ... lists){
        if (lists == null) return null;
        Set<E> allEmployees = new HashSet<>();
        for (List<E> list : lists) {
            allEmployees.addAll(list);
        }
        return new ArrayList<>(allEmployees);
    }

    // Task 3 - Test OK
    public static String splittingAndRemoveDuplicates(String listOfNames) {
        if (listOfNames == null || listOfNames.isBlank()) return null;
        return String.join(",", new LinkedHashSet<>(Arrays.asList(listOfNames.split(","))));
    }

    // Task 4 - Test OK
    public static <E> Set<E> getSetOfDuplicatedPersons(List<E> ... lists){
        if (lists == null) return null;
        HashSet<E> setList = new HashSet<>(lists[0]);
        for (int i = 1; i < lists.length; i++) {
            setList.retainAll(lists[i]);
        }
        return setList;
    }

    // Task 5 - Test OK
    public static <E> Set<E> getSetOfDuplicatedPersonsFromList(List<E> personList) {
        if (personList == null) return null;
        Set<E> duplicates = new HashSet<>();
        Set<E> search = new HashSet<>();
        for (E person : personList) {
            if (!search.add(person)) {
                duplicates.add(person);
            }
        }
        return duplicates;
    }
}