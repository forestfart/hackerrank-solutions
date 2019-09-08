package oracle.ocp.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;

public class MatchFileVisitor {
    static boolean f;

    public static void main(String args[]) throws IOException {
        Path path = Paths.get("C:\\Users\\mnm\\Downloads");
        FileVisitor<Path> searcher = new Search();
        Path s = Files.walkFileTree(path, searcher);
        if (!f) System.out.println("No matches");
    }

    private static final class Search extends SimpleFileVisitor<Path> {
        public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes) throws IOException {
            Pattern pattern = Pattern.compile(".\\.....");
            PathMatcher pm = FileSystems.getDefault().getPathMatcher("regex:" + pattern);
            if (pm.matches(file.getFileName())) {
                System.out.println(file);
                f = true;
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
