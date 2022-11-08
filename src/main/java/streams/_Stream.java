package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Justin", MALE),
                new Person("Zayn", MALE),
                new Person("Selena", FEMALE)
        );

        // Gender
        System.out.println(" *** Gender *** ");
       people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toList())
               .forEach(System.out::println);

       // Name
        System.out.println(" *** Name *** ");
       people.stream()
               .map(person -> person.name)
               .collect(Collectors.toList())
               .forEach(System.out::println);

       // Length
        System.out.println("*** Length *** ");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // All Match
        Boolean containsOnlyFemales = people.stream()
                .allMatch(person -> person.gender.equals(FEMALE));

        System.out.println(containsOnlyFemales);

        // Any Match
        Boolean containsAnyFemales = people.stream()
                .anyMatch( person -> person.gender.equals(FEMALE));

        System.out.println(containsAnyFemales);
    }


    // Person Class
    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
