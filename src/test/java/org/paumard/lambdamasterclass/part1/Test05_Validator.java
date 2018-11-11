package org.paumard.lambdamasterclass.part1;

import org.junit.Test;
import org.paumard.lambdamasterclass.part1.model.Person;
import org.paumard.lambdamasterclass.part1.util.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Test05_Validator {

    /*
    @Test
    public void validator_1() {

        Validator<Person> validator =
                Validator.<Person>firstValidate(p -> p.getLastName() == null, "name is null")
                        .thenValidate(p -> p.getAge() < 0, "age is negative")
                        .thenValidate(p -> p.getAge() > 150, "age is greater than 150");

        Person person = new Person("Stuart", 25);
        assertThat(validator.validate(person).get()).isSameAs(person);
    }

    @Test
    public void validator_2() {

        Validator<Person> validator =
                Validator.<Person>firstValidate(p -> p.getLastName() == null, "name is null")
                        .thenValidate(p -> p.getAge() < 0, "age is negative")
                        .thenValidate(p -> p.getAge() > 150, "age is greater than 150");

        Person person = new Person(null, 25);
        assertThatExceptionOfType(Validator.ValidationException.class)
                .isThrownBy(() -> validator.validate(person).get());

         validator.validate(person).get();
    }

    @Test
    public void validator_3() {

        Validator<Person> validator =
                Validator.<Person>firstValidate(p -> p.getLastName() == null, "name is null")
                        .thenValidate(p -> p.getAge() < 0, "age is negative")
                        .thenValidate(p -> p.getAge() > 150, "age is greater than 150");

        Person person = new Person(null, 180);
        assertThatExceptionOfType(Validator.ValidationException.class)
                .isThrownBy(() -> validator.validate(person).get());

         validator.validate(person).get();
    }

    @Test
    public void validator_4() {

        Validator<Person> validator =
                Validator.<Person>firstValidate(p -> p.getLastName() == null, "name is null")
                        .thenValidate(p -> p.getAge() < 0, "age is negative")
                        .thenValidate(p -> p.getAge() > 150, "age is greater than 150");

        Person person = new Person("Stuart", -10);
        assertThatExceptionOfType(Validator.ValidationException.class)
                .isThrownBy(() -> validator.validate(person).get());

         validator.validate(person).get();
    }
    */
}
