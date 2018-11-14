package org.paumard.lambdamasterclass.part1;

import org.paumard.lambdamasterclass.part1.util.Predicate;

import java.util.Objects;

public class PlayWithPredicates {

    public static void main(String[] args) {

        Predicate<String> p = String::isEmpty;
        Predicate<String> pNot = p.negate();

        System.out.println("For Hello = " + pNot.test("Hello"));
        System.out.println("For empty string = " + pNot.test(""));

        Predicate<String> p1 = Objects::nonNull;
        Predicate<String> p2 = String::isEmpty;

        Predicate<String> p3 = p1.and(p2);
        p3.test("Hello");
        System.out.println("For null : " + p3.test(null));

        Predicate<String> p11 = s -> s.length() == 4;
        Predicate<String> p12 = s -> s.startsWith("J");

        Predicate<String> p13 = p11.xOr(p12);

        System.out.println("For True = " + p13.test("True"));
        System.out.println("For Julia = " + p13.test("Julia"));
        System.out.println("For Java = " + p13.test("Java"));
    }
}
