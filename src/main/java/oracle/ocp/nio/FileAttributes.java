package oracle.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAttributes {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("T:");
        System.out.println(Files.getOwner(path) + " " + Files.getFileStore(path));
    }
}
