package org.techreturners.exercises;

import org.techreturners.data_models.Car;
import org.techreturners.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise003 {

    public static void main(String[] args) throws IOException {

        groupByColour();

    }

    public static void groupByColour() throws IOException {
        // I would like information for some cars returned in a specific way.
        // I'm looking for cars that are less than 20000 and made in 1995
        // Group the results together by their colour and print to the console

        List<Car> cars = MockData.getCars();
        cars.stream()
            .filter(c -> c.price() < 20000 && c.year() == 1995)
            .collect(Collectors.groupingBy(Car::colour))
            .forEach((colour, carList) -> {
                    System.out.println("Cars with colour "+colour+" : ");
                    carList.forEach(System.out::println);
            });
    }
}

