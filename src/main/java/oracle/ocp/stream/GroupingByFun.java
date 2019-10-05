package oracle.ocp.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static oracle.ocp.stream.Student.City.LOS_ANGELES;
import static oracle.ocp.stream.Student.City.NEW_YORK;
import static oracle.ocp.stream.Student.Course.JAVA_EE;
import static oracle.ocp.stream.Student.Course.JAVA_SE;

class Student {
    private String name;
    private Course course;
    private City city;

    enum Course {
        JAVA_EE("Ka"),
        JAVA_SE("La");
        String str;

        Course(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    enum City {LOS_ANGELES, NEW_YORK;}

    Student(String name, Course course, City city) {
        this.name = name;
        this.course = course;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public City getCity() {
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
                new Student("Kate", JAVA_SE, LOS_ANGELES),
                new Student("Adam", JAVA_EE, NEW_YORK),
                new Student("Morrison", JAVA_SE, LOS_ANGELES));

        students.stream().collect(Collectors.groupingBy(Student::getCourse))
                .forEach((course, js) -> System.out.println(course + " " + js));

        students.stream().collect(Collectors.groupingBy(Student::getCity, Collectors.mapping(Student::getName, Collectors.toList())))
                .forEach((city, names) -> System.out.println(names + " " + city));
    }
}
