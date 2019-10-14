package oracle.ocp.nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesListFun {
    public static void main(String[] args) throws IOException {
        Stream<Path> stream = Files.list(Paths.get("C:\\users\\HP\\Links"));
        stream.forEach(System.out::print);
        System.out.println("\n---");

        Stream<Path> stream2 = Files.find(Paths.get("C:\\users\\HP\\Links"), 100, (p,b) -> b.isDirectory(), FileVisitOption.FOLLOW_LINKS);
        stream2.forEach(System.out::print);
        System.out.println("\n---");

        Stream<Path> stream3 = Files.walk(Paths.get("C:\\users\\HP\\Links"));
        stream3.forEach(System.out::println);
        System.out.println("\n---");
    }
}
