package com.pluralsight.streams;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        //* List of people
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


        //* Search

        // Ask the user for a name to search (first or last)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        // Keep only people whose first OR last name matches (ignores case),
        // then collect them into a new list
        List<Person> matches = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(name)
                        || person.getLastName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        // Show the results, or a message if nobody matched
        if (matches.isEmpty()) {
            System.out.println("Name not found");
        } else {
            matches.forEach(person -> System.out.println(person));
        }


        //* Stats

        //? Average age
        // Turn each person into their age, then add all the ages together
        int total = people.stream()
                .map(person -> person.getAge())
                .reduce(0, (a, b) -> a + b);

        // Cast to double so the decimals aren't cut off
        double avg = (double) total / people.size();
        System.out.printf("Average age: %.2f%n", avg);

        //? Oldest and youngest
        // mapToInt turns the stream into numbers so we can use max() and min()
        int oldest = people.stream()
                .mapToInt(person -> person.getAge())
                .max()
                .getAsInt();

        int youngest = people.stream()
                .mapToInt(person -> person.getAge())
                .min()
                .getAsInt();

        System.out.println("Oldest: " + oldest);
        System.out.println("Youngest: " + youngest);

        scanner.close();
    }
}