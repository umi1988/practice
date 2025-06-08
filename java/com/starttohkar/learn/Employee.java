package com.starttohkar.learn;

/**
 *
 * A comparable object is capable of comparing itself with another object.
 * The class itself must implements the java.lang.Comparable interface to compare its instances.
 *
 * Comparable is meant for objects with natural ordering which means the object itself must know
 * how it is to be ordered. For example Roll Numbers of students. Whereas, Comparator interface
 * sorting is done through a separate class.
 *
 * Logically, Comparable interface compares “this” reference with the object specified and
 * Comparator in Java compares two different class objects provided.
 *
 * If any class implements Comparable interface in Java then collection of that object either List or
 * Array can be sorted automatically by using Collections.sort() or Arrays.sort() method and objects
 * will be sorted based on there natural order defined by CompareTo method.
 *
 * A basic differentiating feature is that using comparable we can use only one comparison. Whereas,
 * we can write more than one custom comparators as you want for a given type, all using different
 * interpretations of what sorting means. Like in the comparable example we could just sort by only one
 * attribute, i.e., year but in the comparator, we were able to use different attributes like rating, name,
 * and year as well.
 *
 * To summarize, if sorting of objects needs to be based on natural order then use Comparable whereas
 * if you sorting needs to be done on attributes of different objects, then use Comparator in Java.
 *
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class Employee implements Comparable<Employee>{
    private long empId;
    private String empName;
    private int age;

    public Employee(long empId, String empName, int age) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
    }

    @Override
    public int compareTo(Employee e) {
        return this.age - e.age;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empId +
                ", empNAME='" + empName + '\'' +
                ", agE=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"abc", 25));
        list.add(new Employee(2,"xyz", 30));
        list.add(new Employee(3,"def", 22));
        list.add(new Employee(4,"pqr", 21));

        Collections.sort(list);

        System.out.println("After sorting : - ");

        list.forEach((i) -> System.out.println("EMPID - " + i.getEmpId() + " - EMPNAME - " + i.getEmpName() + " - EMPAGE " + i.getAge()));


    }
}
