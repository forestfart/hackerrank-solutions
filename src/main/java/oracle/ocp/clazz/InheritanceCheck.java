package oracle.ocp.clazz;

interface Book {
    abstract String read(String bname);
}

class EBook implements Book {
    public String read(String url) {
        return "View " + url;
    }
}

public class InheritanceCheck {
    public static void main(String[] args) {
        Book b1 = str -> str + " test here going on...";
        System.out.println(b1.read("Java Programing"));
        Book b2 = new EBook();
        System.out.println(b2.read("http://ebook.com/ebook"));
    }
}