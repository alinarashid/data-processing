package com.pluralsight.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Sarah", "Khan", 28));
        people.add(new Person("Omar", "Ali", 35));
        people.add(new Person("Emily", "Johnson", 22));
        people.add(new Person("Daniel", "Smith", 41));
        people.add(new Person("Aisha", "Khan", 19));
        people.add(new Person("Michael", "Brown", 56));
        people.add(new Person("Sarah", "Lee", 33));
        people.add(new Person("Hassan", "Raza", 47));
        people.add(new Person("Olivia", "Smith", 15));
        people.add(new Person("James", "Wilson", 62));
        people.add(new Person("Zara", "Ahmed", 26));
        people.add(new Person("Lucas", "Garcia", 38));

        // Ask the user for a name to search (first or last)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        // Empty list to collect people whose name matches
        List<Person> peopleToAdd = new ArrayList<>();

        // Go through everyone and add the matches to the list
        for (Person person : people) {
            // Match if the first OR last name equals the search (ignores upper/lowercase)
            if (person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name)) {
                peopleToAdd.add(person);
            }
        }

        // After checking everyone, show the results
        if (peopleToAdd.isEmpty()) {
            // Nobody matched
            System.out.println("Name not found");
        } else {
            // Print each person who matched
            for (Person person : peopleToAdd) {
                System.out.println(person);
            }
        }

    }
}
