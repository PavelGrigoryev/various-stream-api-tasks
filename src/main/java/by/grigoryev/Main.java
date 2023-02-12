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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

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
        //        Продолжить...
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
                .filter(flower -> String.valueOf(flower.getCommonName().charAt(0)).matches("[C-S]"))
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
}