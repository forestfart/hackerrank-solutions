package practice.java.advanced;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JAvaReflectionAttributes {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class student = Class.forName("practice.java.advanced.JAvaReflectionAttributes$Student");
        Method[] methods = student.getDeclaredMethods();
        Field[] fields = student.getFields();

        List<String> methodList = new ArrayList<>();
        for (Method method : methods) {
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for (String methodName : methodList) {
            System.out.println(methodName);
        }
        System.out.println("--------------Take out value form an object");
        Field nameField = student.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println(nameField.get(new JAvaReflectionAttributes().new Student()));

    }

    class Student {
        private String name = "namessnsnnsns";
        private String id;
        private String email;

        public String getName() {
            return name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void anothermethod() {
        }
    }
}
