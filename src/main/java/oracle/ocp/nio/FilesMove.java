package oracle.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesMove {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("src\\main\\java\\oracle\\ocp\\nio\\green.txt");
        Path target = Paths.get("src\\main\\java\\oracle\\ocp\\nio\\yellow.txt");
        Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
        //Files.move(target, source, StandardCopyOption.ATOMIC_MOVE);
    }
}
