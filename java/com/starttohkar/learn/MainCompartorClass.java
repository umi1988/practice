package com.starttohkar.learn;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Here are some reasons why you might want to use the Comparator interface over the Comparable
 * interface in Java:

 * Sorting based on different criteria: When using the Comparable interface,
 * the natural ordering of an object is defined in the class itself.
 * This means that you can only sort objects based on a single criterion.
 * On the other hand, when using the Comparator interface, you can define multiple sorting
 * criteria by creating different instances of the comparator interface. This provides more
 * flexibility when sorting objects.

 * Sorting objects that do not implement the Comparable interface: If you need to sort objects that do
 * not implement the Comparable interface, you cannot use the Collections.sort() method, which requires
 * objects to implement the Comparable interface. In this case, you can use the Collections.sort() method
 * that takes a Comparator object as a parameter to sort the objects.

 * Modifying sorting criteria at runtime: When using the Comparator interface, you can modify the
 * sorting criteria at runtime by creating a new instance of the Comparator interface with different
 * sorting logic. This provides more dynamic sorting behavior.

 * Sorting objects in a different order: When using the Comparable interface, the objects are sorted in
 * natural order, which is not always the desired behavior. When using the Comparator interface, you can
 * define custom sorting criteria to sort objects in a different order.

 * Separation of concerns: The Comparable interface defines the natural ordering of an object, which may
 * not always be the desired behavior when sorting. When using the Comparator interface, the sorting
 * behavior is separated from the object itself, which provides better encapsulation and separation of
 * concerns.
 *
 *
 *
 *
 */

public class MainCompartorClass
{
    public static void main(String[] args) {
        ArrayList<Movie> list1 = new ArrayList<Movie>();
        list1.add(new Movie(8.3,"Force Awakens" ,2015));
        list1.add(new Movie(8.7,"Star Wars", 1977));
        list1.add(new Movie(8.8,"Empire Strikes Back",1980));
        list1.add(new Movie(8.4,"Return of the Jedi",1983));

        System.out.println("Sorted by rating : - "); // using comparator
        RatingComparator rc = new RatingComparator();
        Collections.sort(list1,rc);
        list1.forEach((i -> System.out.println(" Movie Rating -  " + i.getRating() + " - MovieName " + i.getName() + " - MovieYear " + i.getYear())));

        System.out.println("Sorted by Name : - "); // using comparator
        NameCompare nc = new NameCompare();
        Collections.sort(list1,nc);
        list1.forEach((i -> System.out.println(" Movie Rating -  " + i.getRating() + " - MovieName " + i.getName() + " - MovieYear " + i.getYear())));

        System.out.println("Sorted by Year : - "); // using comparable
        Collections.sort(list1);
        list1.forEach((i -> System.out.println(" Movie Rating -  " + i.getRating() + " - MovieName " + i.getName() + " - MovieYear " + i.getYear())));

    }
}
