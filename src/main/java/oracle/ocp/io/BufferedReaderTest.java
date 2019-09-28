package oracle.ocp.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        Path path = Paths.get(".\\src\\main\\resources\\DeterminingDnaHealth.txt").toAbsolutePath();
        try (BufferedReader localBuffReader = new BufferedReader(new FileReader(path.toFile()))) {
            bufferedReader = localBuffReader;
            System.out.printf("%s; ready to read? %s\n", path.normalize(), bufferedReader.ready());
            bufferedReader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.ready();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
