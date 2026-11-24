package com.pluralsight.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //*List of people
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


        //*Search

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


        //* Stats
        //? Avg Age
        double total = 0;
        for ( Person person : people) {
            total += person.getAge();
        }
        double avg  = total / people.size();
        System.out.printf("Average age: %.2f%n", avg);

        //? Oldest and Youngest
        int oldest = people.get(0).getAge();
        int youngest = people.get(0).getAge();

        for (Person person : people) {
            if (person.getAge() > oldest) {
                oldest = person.getAge();
            } else if ( person.getAge() < youngest) {
                youngest = person.getAge();
            }
        }
        System.out.println("Oldest: " + oldest);
        System.out.println("Youngest: " + youngest);

        scanner.close();
    }
}
