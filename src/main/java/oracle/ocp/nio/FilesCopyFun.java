package oracle.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesCopyFun {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("src\\main\\java\\oracle\\ocp\\nio\\gr33n.txt"); // <- throws NoSuchFileException if it is not found.. damn it!
        Path destination = Paths.get("src\\main\\resources\\green.txt");
        Files.copy(source,destination);
    }
}
