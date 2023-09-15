package org.techreturners.exercises;

import org.techreturners.data_models.Car;
import org.techreturners.data_models.Person;
import org.techreturners.mockdata.MockData;

import java.io.IOException;
import java.util.List;

public class Exercise001 {
    public static final int FILTER_YEAR = 2001;
    public static final int FILTER_PRICE = 30000;
    public static final String FILTER_COLOUR = "Green";
    public static final String FILTER_GENDER = "Male";
    public static final String FILTER_INITIAL_FIRST = "A";
    public static final String FILTER_INITIAL_LAST = "M";
    public static final int FILTER_AGE = 30;

    public static void main(String[] args) throws Exception {

        filterCars();
        findPerson();

    }

    public static void filterCars() throws Exception {
        // I'm in the market to buy a new car, and I'm looking for something very particular:
        // It has to be made in or before 2001, cost 30000 or less, and be coloured Green.
        // I would like the results printed out to the console
        // I have provided you with the list of cars to find these from below:
        List<Car> cars = MockData.getCars();
        System.out.println("List of cars made in or before 2001, costing 30000 or less "
                        +"andin colour Green: ");
        cars.stream().
                filter(c -> c.year() <= FILTER_YEAR
                        && c.price() <= FILTER_PRICE
                        && c.colour().equals(FILTER_COLOUR))
                .forEach(System.out::println);
    }

    public static void findPerson() throws IOException {
        // I'm looking for the details of someone in particular and I don't have much to go on
        // All I know is that it's a Male, older than 30, who's initials are A M.
        // Can you find people who match this to help whittle down my search?
        // Output your result to the console

        List<Person> people = MockData.getPeople();
        System.out.println("Details of all Male, older than 30 and initials A M: ");
        people.stream()
              .filter(x -> x.gender().equals(FILTER_GENDER) &&
                      x.age() > FILTER_AGE &&
                      x.firstName().startsWith(FILTER_INITIAL_FIRST) &&
                      x.lastName().startsWith(FILTER_INITIAL_LAST))
                .forEach(System.out::println);
    }
}
