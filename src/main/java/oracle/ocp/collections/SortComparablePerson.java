package oracle.ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    String name;
    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class SortComparablePerson {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("jsafd"), new Person("avf"), new Person("eee"));
        Collections.sort(list);
        System.out.println(list);
    }
}
