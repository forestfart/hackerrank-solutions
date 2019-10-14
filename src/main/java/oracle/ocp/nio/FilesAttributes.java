package oracle.ocp.nio;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesAttributes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("T:");
        System.out.println(Files.getOwner(path) + " " + Files.getFileStore(path));
    }

}

class BasicFileAttributesTest {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.home"));
        System.out.println(path.toAbsolutePath());
        try {
            Files.walk(path).forEach(file -> {
                BasicFileAttributes bfa = null;
                try {
                    bfa = Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (LocalDateTime.ofInstant(bfa.creationTime().toInstant(), ZoneId.of("GMT")).toLocalDate().isBefore(LocalDate.now().minus(3, ChronoUnit.MONTHS))) {
                    System.out.printf("FileName: %s, Created: %s, path: %s\n", file.getFileName(), bfa.creationTime(), file.toAbsolutePath());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class checkClazz {
    public static void main(String[] args) throws IOException {
        Stream<Path> files = Files.walk(Paths.get("."));
        Map<Boolean, List<Path>> map = files.peek(fName -> { //line n1
                    try {
                        if (Files.isReadable(fName)) { // shit does not handle if accessDenied.. better use filesWalk..
                            FileTime creationTime = Files.readAttributes(fName, BasicFileAttributes.class).creationTime();
                            System.out.printf("%s \tis a directory: %s, \tcreated: %s\n", fName.toAbsolutePath(), Files.isDirectory(fName), creationTime);
                        }
                    } catch (IOException ex) {
                    }
                }
        ).collect(Collectors.partitioningBy(n -> Files.isDirectory(n)));
        System.out.printf("Total of: %d files and %d directories", map.get(Boolean.TRUE).size(), map.get(Boolean.FALSE).size());
    }
}

