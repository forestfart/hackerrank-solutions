package oracle.ocp.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name, course, city;

    Student(String name, String course, String city) {
        this.name = name;
        this.course = course;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

public class GroupingByFun {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Kate", "Course Cool", "Los Angeles"),
                new Student("Adam", "GoodAtIt", "Huston"),
                new Student("Morrison", "Course Cool", "London"));

        students.stream().collect(Collectors.groupingBy(Student::getCourse))
                .forEach((course, js) -> System.out.println(course + " " + js));
    }
}
