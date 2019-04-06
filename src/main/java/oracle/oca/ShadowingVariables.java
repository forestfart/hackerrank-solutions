package oracle.oca;

public class ShadowingVariables {
    public static void main(String... args) {

        Parent parent = new Parent();
        parent.printInstanceVariable(); // Output - "Parent's Instance Variable"
        System.out.println(parent.x); // Output - "Parent's Instance Variable"
        Child child = new Child();
        child.printInstanceVariable();// Output - "Child's Instance Variable, Parent's Instance Variable"
        System.out.println(child.x);// Output - "Child's Instance Variable"
        parent = child; // Or parent = new Child();
        parent.printInstanceVariable();// Output - "Child's Instance Variable, Parent's Instance Variable"
        System.out.println(parent.x);// Output - Parent's Instance Variable
        // Accessing child's variable from parent's reference by type casting
        System.out.println(((Child) parent).x);// Output - "Child's Instance Variable"
    }
}


class Parent {
    // Declaring instance variable with name `x`
    String x = "Parent`s Instance Variable";
    public void printInstanceVariable() {
        System.out.println(x);
    }
    public void printLocalVariable() {
        // Shadowing instance variable `x` with a local variable with the same name
        String x = "Local Variable";
        System.out.println(x);
        // If we still want to access the instance variable, we do that by using `this.x`
        System.out.println(this.x);
    }
}


class Child extends Parent {
    // Hiding the Parent class's variable `x` by defining a variable in the child class with the same name.
    String x = "Child`s Instance Variable";
    @Override
    public void printInstanceVariable() {
        System.out.print(x);
        // If we still want to access the variable from the super class, we do that by using `super.x`
        System.out.print(", " + super.x + "\n");
    }
}