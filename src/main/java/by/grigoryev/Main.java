package by.grigoryev;

import by.grigoryev.model.Animal;
import by.grigoryev.model.Car;
import by.grigoryev.model.Flower;
import by.grigoryev.model.House;
import by.grigoryev.model.Person;
import by.grigoryev.util.Util;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...

    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
//        Продолжить...
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        //        Продолжить...
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }

    private static void task16() throws IOException {
        List<Person> people = Util.getPersons();
        String xml = """
                    <person>
                        <fullName>%s</fullName>
                        <gender>%s</gender>
                        <age>%d</age>
                        <tax>%s</tax>
                    </person>
                """;

        Map<String, String> occupationTree = new TreeMap<>(
                people.stream()
                        .filter(person -> "Male".equals(person.getGender()) || "Female".equals(person.getGender()))
                        .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= 18)
                        .collect(Collectors.groupingBy(
                                person -> """
                                        <%s>
                                        """.formatted(
                                        person.getOccupation()
                                                .replace(" ", "")
                                                .replace("/", "")
                                                .replace(person.getOccupation().charAt(0),
                                                        Character.toLowerCase(person.getOccupation().charAt(0)))
                                ),
                                Collectors.mapping(
                                        person -> xml.formatted(
                                                person.getFirstName()
                                                        .substring(0, 1)
                                                        .concat(".")
                                                        .concat(person.getLastName()),
                                                person.getGender().toUpperCase(),
                                                ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()),
                                                BigDecimal.valueOf(
                                                                ChronoUnit.MONTHS.between(
                                                                        person.getDateOfBirth().plusYears(18),
                                                                        LocalDate.now())
                                                        )
                                                        .multiply(BigDecimal.valueOf(5.45))
                                                        .toString()
                                                        .concat("$")
                                        ),
                                        Collectors.joining("")
                                )
                        ))
        );

        occupationTree.forEach((k, v) -> System.out.println(k + v + new StringBuilder(k).insert(1, "/")));
    }

}