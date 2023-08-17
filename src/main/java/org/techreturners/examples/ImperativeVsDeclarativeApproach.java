package org.techreturners.examples;

import org.techreturners.data_models.Person;
import org.techreturners.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImperativeVsDeclarativeApproach {

    public static void main(String[] args) throws Exception {

        imperativeApproach();

        declarativeApproachUsingStreams();
    }

    // We would like our algorithm to:
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    public static void imperativeApproach() throws IOException {

        List<Person> people = MockData.getPeople();
        List<Person> youngPeople = new ArrayList<>();
        int limit = 10;
        int count = 0;
        for (Person person : people) {
            if (person.age() <= 18) {
                youngPeople.add(person);
                count ++;
                if(count == limit) {
                    break;
                }
            }
        }
        youngPeople.forEach(System.out::println);
    }

    public static void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();

        List<Person> filteredList = people.stream()
                .filter(s -> s.age() <= 18)
                .limit(10)
                .toList();
        filteredList.forEach(System.out::println);
    }
}
