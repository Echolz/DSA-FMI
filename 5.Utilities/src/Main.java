import U_1_Sorting_Searching.GenericSortingSearching;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GenericSortingSearching<Person> util = new GenericSortingSearching<>();

        List<Person> people = new ArrayList<>();

        for (int i = 1000; i > -1; i--) {
            people.add(new Person(String.valueOf(i), i));
        }

        util.sort(people);

        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println(util.binarySearch(people, new Person("asd", 12312458)));
    }
}

class Person implements Comparable<Person> {
    String name;
    Integer age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return String.format("%s, %d", name, age);
    }
}
