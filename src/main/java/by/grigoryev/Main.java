package by.grigoryev;

import by.grigoryev.model.Animal;
import by.grigoryev.model.Car;
import by.grigoryev.model.Flower;
import by.grigoryev.model.House;
import by.grigoryev.model.Person;
import by.grigoryev.util.Util;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
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
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> animal.getGender().equals("Female")
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
                .filter(animal -> animal.getGender().equals("Female"))
                .count();

        System.out.println(femaleCount);
    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();

        boolean isHungarian = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));

        System.out.println(isHungarian);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();

        boolean isAllMatchMaleAndFemale = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") && animal.getGender().equals("Female"));

        System.out.println(isAllMatchMaleAndFemale);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();

        boolean isNoneMatchOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));

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
}