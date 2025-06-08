package com.starttohkar.designpattern;
/**
 The Iterator pattern helps us go through a list or a group of things.
 It keeps the way the group is organized a secret and gives us a way to get to each thing one after the other.
 It does this by creating a special tool called an Iterator that helps us move through the group.

 To implement the Iterator Pattern, we will need to:

 Create an Iterator interface or abstract class that defines methods for accessing the elements of the
        aggregate object. Typically, these methods include hasNext() to check if there are more elements,
        and next() to return the next element.
 Create concrete classes that implement the Iterator interface and represent different types of iterators.
        These classes should contain a reference to the aggregate object they are iterating over.
 Create a concrete aggregate class that implements an Iterable interface or defines a method that
        returns an Iterator object. This method should create and return an instance of the appropriate
        Iterator class.
 Client code can use the Iterator to access the elements of the aggregate object.
 */

// Iterator interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Concrete iterator class
class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int currentIndex;

    public ArrayIterator(T[] array) {
        this.array = array;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < array.length;
    }

    public T next() {
        return array[currentIndex++];
    }
}

// Aggregate class
/*class Array<T> implements Iterable<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }*/

//    public Iterator<T> iterator() {
//        return new ArrayIterator<T>(array);
//    }
//}

// Client code
public class IteratorDesignPattern {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        //Array<Integer> integerArray = new Array<Integer>(array);

      /*  Iterator<Integer> iterator = integerArray.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
        }*/
    }
}
