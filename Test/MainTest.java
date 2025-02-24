import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

class MainTest {

    @Nested
    public class IsHaveDuplicates_existDuplicates_expectTrue {

        @Test
        @DisplayName("(#1) Task 1: When value have duplicates")
        void isHaveDuplicates_existDuplicates_expectTrue() {
            List<String> personList = List.of("Karl", "David", "Karl", "John", "David", "Erick");
            Assertions.assertTrue(Main.isHaveDuplicates(personList));
        }

        @Test
        @DisplayName("(#2) When value don't have duplicates")
        void isHaveDuplicates_notExistDuplicates_expectFalse() {
            List<String> personList = List.of("Karl", "John", "David", "Erick");
            Assertions.assertFalse(Main.isHaveDuplicates(personList));
        }

        @Test
        @DisplayName("(#3) Input null list")
        void isHaveDuplicates_nullListInput_expectFalse() {
            List<String> personList = null;
            Assertions.assertFalse(Main.isHaveDuplicates(personList));
        }
    }

    @Nested
    public class allEmployeesWithoutDuplicates {
        @Test
        @DisplayName("(#4) Task 2: RemoveDuplicates: List with Persons")
        void allEmployeesWithoutDuplicates() {
            List<Person> team1 = List.of(new Person("Karl", 33), new Person("David", 24));
            List<Person> team2 = List.of(new Person("Karl", 33), new Person("Robert", 39));
            List<Person> team3 = List.of(new Person("Eleonora", 32), new Person("Karl", 33));

            List<Person> actualResult = Main.allEmployeesWithoutDuplicates(team1, team2, team3);
            List<Person> expectedResult = List.of(new Person("Eleonora", 32), new Person("David", 24),
                    new Person("Karl", 33), new Person("Robert", 39));

            // Sorting method
            actualResult.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
            expectedResult = new ArrayList<>(expectedResult);
            expectedResult.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
                Assertions.assertEquals(expectedResult, actualResult);

            // HashSet method
            HashSet<Person> actualSet = new HashSet<>(actualResult);
            HashSet<Person> expectedSet = new HashSet<>(expectedResult);
            boolean isOk = expectedSet.equals(actualSet) && expectedResult.size() == actualResult.size();

            Assertions.assertTrue(isOk);
            Assertions.assertEquals(new HashSet<>(expectedResult), new HashSet<>(actualResult));
        }
    }

    @Nested
    public class SplittingAndRemoveDuplicates {
        @Test
        @DisplayName("(#5) Task 3:  Splitting and remove duplicates")
        void splittingAndRemoveDuplicates() {
            String listOfNames = "Jack,John,Nick,John";
            String actualResult = Main.splittingAndRemoveDuplicates(listOfNames);
            String expectedResult = "Jack,John,Nick";

            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class GetSetOfDuplicatedPersons{
        @Test
        @DisplayName("(#6) Task 4: Get Set of duplicated Persons from both lists")
        void getSetOfDuplicatedPersons() {
            List<Person> list1 = List.of(new Person("Alice", 30), new Person("Jack", 25), new Person("John", 35));
            List<Person> list2 = List.of(new Person("Jack", 25), new Person("John", 35), new Person("David", 40));

            Set<Person> actualResult = Main.getSetOfDuplicatedPersons(list1, list2);
            Set<Person> expectedResult = new HashSet<>(List.of(new Person("Jack", 25), new Person("John", 35)));

            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class GetSetOfDuplicatedPersonsFromList{
        @Test
        @DisplayName("(#7) Task 5: Get Set of duplicated Persons")
        void getSetOfDuplicatedPersonsFromList(){
            List<Person> listOfPersons = List.of(new Person("Jack", 25), new Person("John", 35),
                    new Person("David", 40), new Person("Jack", 25), new Person("David", 40));

            Set<Person> actualResult = Main.getSetOfDuplicatedPersonsFromList(listOfPersons);
            Set<Person> expectedResult = new HashSet<>(List.of(new Person("David", 40), new Person("Jack", 25)));

            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

}