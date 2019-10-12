package oracle.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesWrite {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src\\main\\java\\oracle\\ocp\\nio\\yellow.txt"));
            lines.forEach(line -> {
                try {
                    Files.write(Paths.get("src\\main\\resources\\yellowCopy.txt"),
                            line.getBytes(),
                            StandardOpenOption.APPEND
                    );
                } catch (IOException e) {
                    System.out.println("Exception 1");
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.out.println("Exception 2");
            e.printStackTrace();
        }
    }
}
