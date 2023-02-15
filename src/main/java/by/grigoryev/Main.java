package by.grigoryev;

import by.grigoryev.model.Animal;
import by.grigoryev.model.Car;
import by.grigoryev.model.Flower;
import by.grigoryev.model.House;
import by.grigoryev.model.Person;
import by.grigoryev.util.Util;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
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
        String personXml = """
                    <person>
                        <fullName>%s</fullName>
                        <gender>%s</gender>
                        <age>%d</age>
                        <tax>%s</tax>
                    </person>
                """;

        String validXml = people.stream()
                .filter(person -> "Male".equals(person.getGender()) || "Female".equals(person.getGender()))
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= 18)
                .filter(person -> !person.getOccupation().startsWith("VP"))
                .collect(Collectors.groupingBy(
                        person -> """
                                <%s>
                                """.formatted(
                                person.getOccupation()
                                        .replace(" ", "")
                                        .replace("/", "")
                                        .replaceFirst(
                                                String.valueOf(person.getOccupation().charAt(0)),
                                                String.valueOf(person.getOccupation().charAt(0)).toLowerCase()
                                        )
                        ),
                        Collectors.mapping(
                                person -> personXml.formatted(
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
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + entry.getValue() + new StringBuilder(entry.getKey()).insert(1, "/"))
                .collect(Collectors.joining("\n", "<taxesForBinary>\n", "</taxesForBinary>"));

        System.out.println(validXml);

        Path path = Paths.get("src\\main\\resources\\taxes-for-binary.xml");
        try {
            Files.write(path, validXml.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}