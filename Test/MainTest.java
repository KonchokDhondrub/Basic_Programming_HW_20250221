import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

class MainTest {

    @Nested
    public class IsHaveDuplicates_existDuplicates_expectTrue {

        @Test
        @DisplayName("(#1) When value have duplicates")
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
        @DisplayName("(#4) RemoveDuplicates: List with Persons")
        void allEmployeesWithoutDuplicates() {
            List<Person> team1 = List.of(new Person("Karl", 33), new Person("David", 24));
            List<Person> team2 = List.of(new Person("Karl", 33), new Person("Robert", 39));
            List<Person> team3 = List.of(new Person("Eleonora", 32), new Person("Karl", 33));

            List<Person> actualResult = Main.allEmployeesWithoutDuplicates(team1, team2, team3);
            List<Person> expectedResult = List.of(new Person("Eleonora", 32), new Person("David", 24),
                    new Person("Karl", 33), new Person("Robert", 39));
            HashSet<Person> actualSet = new HashSet<>(actualResult);
            HashSet<Person> expectedSet = new HashSet<>(expectedResult);
            boolean isOk = expectedSet.equals(actualSet) && expectedResult.size() == actualResult.size();

            Assertions.assertTrue(isOk);
            Assertions.assertEquals(new HashSet<>(expectedResult), new HashSet<>(actualResult));

        }
    }
}