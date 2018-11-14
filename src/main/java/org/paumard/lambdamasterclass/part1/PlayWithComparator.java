package org.paumard.lambdamasterclass.part1;

import org.paumard.lambdamasterclass.part1.model.Person;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PlayWithComparator {

    public static void main(String[] args) {

        Person michael = new Person("Jackson", "Michael", 51);
        Person michaelBis = new Person("Jackson", null, 51);
        Person rod = new Person("Rod", "Stewart", 71);
        Person paul = new Person("Paul", "McCartney", 74);
        Person mick = new Person("Mick", "Jagger", 73);
        Person jermaine = new Person("Jackson", "Jermaine", 61);

        Function<Person, String> getLastName = p -> p.getLastName();
        Function<Person, String> getFirstName = p -> p.getFirstName();
        Function<Person, Integer> getAge = p -> p.getAge();

        Comparator<Person> cmp = Comparator.comparing(Person::getLastName)
                .thenComparing(getFirstName)
                .thenComparing(getAge);

        Comparator<Person> cmpNull = Comparator.nullsLast(cmp);


        List<Person> people = Arrays.asList(rod, null, michael);
        people.sort(cmpNull);
        people.forEach(System.out::println);

//        Comparator<Person> cmpReversed = cmp.reversed();
//
//        System.out.println("Michael and Rod :" + cmp.compare(michael, rod));
//        System.out.println("Michael and Jermaine :" + cmp.compare(michael, jermaine));

        Comparator<String> cmp2 = Comparator.<String>nullsLast(Comparator.naturalOrder());
        int result = cmp2.compare("Hello", null);
        System.out.println("result = " + result);

        Comparator<Person> cmp20 = Comparator.comparing(Person::getLastName, Comparator.nullsLast(Comparator.naturalOrder()));
    }
}
