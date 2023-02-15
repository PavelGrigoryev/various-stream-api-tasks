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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
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
        AtomicInteger index = new AtomicInteger(0);

        List<Animal> animals = Util.getAnimals();

        Map<Integer, List<Animal>> zoo = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() < 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .collect(Collectors.groupingBy(animal -> index.getAndIncrement() / 7));

        System.out.println("Director Pavel Grigoryev : " + zoo.get(2));
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> "Japanese".equals(animal.getOrigin()))
                .map(animal -> "Female".equals(animal.getGender())
                        ? animal.getBread().toUpperCase() : animal.getBread())
                .forEach(System.out::println);
    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().startsWith("A"))
                .map(Animal::getOrigin)
                .distinct()
                .forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();

        long femaleCount = animals.stream()
                .filter(animal -> "Female".equals(animal.getGender()))
                .count();

        System.out.println(femaleCount);
    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();

        boolean isHungarian = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> "Hungarian".equals(animal.getOrigin()));

        System.out.println(isHungarian);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();

        boolean isAllMatchMaleAndFemale = animals.stream()
                .allMatch(animal -> "Male".equals(animal.getGender()) && "Female".equals(animal.getGender()));

        System.out.println(isAllMatchMaleAndFemale);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();

        boolean isNoneMatchOceania = animals.stream()
                .noneMatch(animal -> "Oceania".equals(animal.getOrigin()));

        System.out.println(isNoneMatchOceania);
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(animal -> System.out.println(animal.getAge()));
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .min(Comparator.comparing(chars -> chars.length))
                .ifPresent(chars -> System.out.println(chars.length));
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();

        int ageSum = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();

        System.out.println(ageSum);
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> "Indonesian".equals(animal.getOrigin()))
                .mapToInt(Animal::getAge)
                .average()
                .ifPresent(System.out::println);
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();

        people.stream()
                .filter(person -> "Male".equals(person.getGender()))
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= 18)
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) < 27)
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();

        List<Person> allPeople = new ArrayList<>(
                houses.stream()
                        .flatMap(house -> house.getPersonList().stream())
                        .toList()
        );

        List<Person> firsts = houses.stream()
                .filter(house -> "Hospital".equals(house.getBuildingType()))
                .flatMap(house -> house.getPersonList().stream())
                .toList();

        allPeople.removeAll(firsts);

        List<Person> seconds = allPeople.stream()
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) < 18
                                  || (ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= 58
                                      && "Female".equals(person.getGender()))
                                  || (ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= 63
                                      && "Male".equals(person.getGender())))
                .toList();

        allPeople.removeAll(seconds);

        List<Person> evacuation = Stream.of(firsts, seconds, allPeople)
                .flatMap(Collection::stream)
                .limit(500)
                .toList();

        evacuation.forEach(System.out::println);
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();

        List<Car> turkmenistan = cars.stream()
                .filter(car -> "Jaguar".equals(car.getCarMake()) || "White".equals(car.getColor()))
                .toList();

        cars.removeAll(turkmenistan);

        List<Car> uzbekistan = cars.stream()
                .filter(car -> car.getMass() < 1500)
                .filter(car -> "BMW".equals(car.getCarMake())
                               || "Lexus".equals(car.getCarMake())
                               || "Chrysler".equals(car.getCarMake())
                               || "Toyota".equals(car.getCarMake()))
                .toList();

        cars.removeAll(uzbekistan);

        List<Car> kazakhstan = cars.stream()
                .filter(car -> ("Black".equals(car.getColor()) && car.getMass() > 4000)
                               || "GMC".equals(car.getCarMake())
                               || "Dodge".equals(car.getCarMake()))
                .toList();

        cars.removeAll(kazakhstan);

        List<Car> kyrgyzstan = cars.stream()
                .filter(car -> car.getReleaseYear() < 1982
                               || "Civic".equals(car.getCarModel())
                               || "Cherokee".equals(car.getCarModel()))
                .toList();

        cars.removeAll(kyrgyzstan);

        List<Car> russia = cars.stream()
                .filter(car -> (!"Yellow".equals(car.getColor())
                                && !"Red".equals(car.getColor())
                                && !"Green".equals(car.getColor())
                                && !"Blue".equals(car.getColor()))
                               || car.getPrice() > 40_000)
                .toList();

        cars.removeAll(russia);

        List<Car> mongolia = cars.stream()
                .filter(car -> car.getVin().contains("59"))
                .toList();

        AtomicInteger countryIndex = new AtomicInteger(1);

        double totalSum = Stream.of(
                        turkmenistan,
                        uzbekistan,
                        kazakhstan,
                        kyrgyzstan,
                        russia,
                        mongolia
                )
                .map(echelon -> echelon.stream()
                        .mapToDouble(Car::getMass)
                        .sum()
                )
                .map(operand -> BigDecimal.valueOf(operand)
                        .divide(BigDecimal.valueOf(1000), 4, RoundingMode.UP)
                        .multiply(BigDecimal.valueOf(7.14)))
                .peek(operand -> System.out.printf(
                        "%s) %s$%n",
                        countryIndex.getAndIncrement(),
                        operand.setScale(2, RoundingMode.HALF_UP)
                ))
                .mapToDouble(BigDecimal::doubleValue)
                .sum();

        System.out.printf("Total sum : %s$", BigDecimal.valueOf(totalSum).setScale(2, RoundingMode.HALF_UP));
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();

        double sum = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin)
                        .reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay)
                        .reversed()
                )
                .filter(flower -> flower.getCommonName().matches("^[C-S].*"))
                .filter(flower -> flower.isShadePreferred()
                                  && (flower.getFlowerVaseMaterial().contains("Glass")
                                      || flower.getFlowerVaseMaterial().contains("Aluminium")
                                      || flower.getFlowerVaseMaterial().contains("Steel"))
                )
                .mapToDouble(flower -> BigDecimal.valueOf(flower.getPrice())
                        .add(
                                BigDecimal.valueOf(flower.getWaterConsumptionPerDay())
                                        .multiply(BigDecimal.valueOf(
                                                ChronoUnit.DAYS.between(
                                                        LocalDate.now(),
                                                        LocalDate.now().plusYears(5)
                                                )
                                        ))
                                        .divide(BigDecimal.valueOf(1000), 6, RoundingMode.HALF_UP)
                                        .multiply(BigDecimal.valueOf(1.39))
                        )
                        .doubleValue())
                .sum();

        System.out.printf("%.2f$", sum);
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
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + entry.getValue() + new StringBuilder(entry.getKey()).insert(1, "/"))
                .collect(Collectors.joining("\n", "<taxesForBinary>\n", "</taxesForBinary>"));

        System.out.println(validXml);

        Path absolutePath = Paths.get("src\\main\\resources\\taxes-for-binary.xml");
        try {
            Files.write(absolutePath, validXml.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}