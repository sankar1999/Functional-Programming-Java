package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
            new Person("Justin", MALE),
                new Person("Selena", FEMALE),
                new Person("Zayn", MALE)
        );
        System.out.println(people);

        // Imperative Approach
        System.out.println("*** Imperative Approach ***");
        List<Person> females = new ArrayList<>();
        for(Person person : people) {
            if (person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }
        System.out.println("Females: " + females);


        // Predicate
        // We can give inside the filter
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        // Declarative Approach
        System.out.println("*** Declarative Approach ***");
        people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

        static class Person {
            private final String name;
            private final Gender gender;

            Person(String name, Gender gender) {
                this.name = name;
                this.gender = gender;
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


