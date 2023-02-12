package by.grigoryev;

import by.grigoryev.model.Animal;
import by.grigoryev.model.Car;
import by.grigoryev.model.Flower;
import by.grigoryev.model.House;
import by.grigoryev.model.Person;
import by.grigoryev.util.Util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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

        List<Car> turkmenistan = cars.stream()
                .filter(car -> car.getCarMake().equals("Jaguar") || car.getColor().equals("White"))
                .toList();

        cars.removeAll(turkmenistan);

        List<Car> uzbekistan = cars.stream()
                .filter(car -> car.getMass() < 1500)
                .filter(car -> car.getCarMake().equals("BMW")
                               || car.getCarMake().equals("Lexus")
                               || car.getCarMake().equals("Chrysler")
                               || car.getCarMake().equals("Toyota"))
                .toList();

        cars.removeAll(uzbekistan);

        List<Car> kazakhstan = cars.stream()
                .filter(car -> (car.getColor().equals("Black") && car.getMass() > 4000)
                               || car.getCarMake().equals("GMC")
                               || car.getCarMake().equals("Dodge"))
                .toList();

        cars.removeAll(kazakhstan);

        List<Car> kyrgyzstan = cars.stream()
                .filter(car -> car.getReleaseYear() < 1982
                               || car.getCarModel().equals("Civic")
                               || car.getCarModel().equals("Cherokee"))
                .toList();

        cars.removeAll(kyrgyzstan);

        List<Car> russia = cars.stream()
                .filter(car -> (!car.getColor().equals("Yellow")
                                && !car.getColor().equals("Red")
                                && !car.getColor().equals("Green")
                                && !car.getColor().equals("Blue"))
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
        //        Продолжить...
    }
}