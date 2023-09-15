package org.techreturners.exercises;

import org.techreturners.data_models.Car;
import org.techreturners.data_models.Person;
import org.techreturners.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Exercise002 {
    public static final String FILTER_COLOUR = "red";
    public static final int LIMIT_RECORDS = 10;

    public static void main(String[] args) throws IOException {

        sortPeopleByAge();
        sortByCarMakeAndYear();
        tenMostExpensiveRedCars();

    }

    public static void sortPeopleByAge() throws IOException {
        // My list of people is unsorted, and I'd like it to be in age order
        // Please return the results from the lowest to the highest age
        System.out.println("Persons sorted by age: ");
        List<Person> people = MockData.getPeople();
        people.stream().sorted(Comparator.comparingInt(Person::age))
                .toList()
                .forEach(System.out::println);
    }

    public static void sortByCarMakeAndYear() throws IOException {
        // My list of cars is currently unsorted
        // Please return the results of the list of cars sorted in:
        // Alphabetical order of make
        // Year within each make
        // Print the results of this to the console

        List<Car> cars = MockData.getCars();
        System.out.println("Cars sorted alphabetically on make and then year: ");
        cars.stream()
                .sorted(Comparator.comparing(Car::make).thenComparingInt(Car::year))
                .toList()
                .forEach(System.out::println);
    }


    public static void tenMostExpensiveRedCars() throws IOException {
        // I've grown to be accustomed to expensive tastes and want to blow some cash on a new car
        // return the top ten most expensive cars from the list
        // Oh, also, it has to be Red!

        List<Car> cars = MockData.getCars();
        System.out.println("Top 10 Expensive Cars: ");
        cars.stream()
                .filter(c -> c.colour().equalsIgnoreCase(FILTER_COLOUR))
                .sorted((c1, c2) -> Double.compare(c2.price(), c1.price()))
                .limit(LIMIT_RECORDS)
                .toList()
                .forEach(System.out::println);
    }
}
