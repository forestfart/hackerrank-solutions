package oracle.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;

// To illustrate important methods such as normalize(), toAbsolutePath(), and toRealPath()
class Nio2PathInfo2 {
    public static void main(String[] args) throws IOException {
        // get a path object with relative path
        Path testFilePath = Paths.get("src\\test\\java\\oracle\\ocp\\FunctionPredicateTest.groovy");
        out.println("The file name is: " + testFilePath.getFileName());
        out.println("Its URI is: " + testFilePath.toUri());
        out.println("Its absolute path is: " + testFilePath.toAbsolutePath());
        out.println("Its normalized path is: " + testFilePath.normalize());
        out.println("Its real path is: " + testFilePath.toRealPath());

        // get another path object with normalized relative path
        Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
        out.println("Its normalized absolute path is: " +
                testPathNormalized.toAbsolutePath());
        out.println("Its normalized real path is: " +
                testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
    }

}

class PathCompare1 {
    public static void main(String[] args) {
        Path path1 = Paths.get("Test");
        Path path2 = Paths.get("D:\\OCPJP\\programs\\NIO2\\Test");
        // comparing two paths using compareTo() method
        out.println("(path1.compareTo(path2) == 0) is: "
                + (path1.compareTo(path2) == 0));

        // comparing two paths using equals() method
        out.println("path1.equals(path2) is: " + path1.equals(path2));

        // comparing two paths using equals() method with absolute path
        out.println("path2.equals(path1.toAbsolutePath()) is "
                + path2.equals(path1.toAbsolutePath()));
    }
}

class PathCheck1 {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("./Pics/MyPic.jpeg").toAbsolutePath().normalize();
        out.println(p1);
        out.println (p1.getNameCount() + ":" + p1.getName(1) + ":"  + p1.getFileName() + ":" + p1.getName(0));

        Path file = Paths.get ("courses.txt");
        List<String> fc = Files.readAllLines(file); fc.stream().forEach(s -> System.out.println(s));
        Stream<String> fc2 = Files.lines (file); fc.forEach(s -> System.out.println(s));
    }
}

class PathCheck2 {
    public static void main(String[] args) {
        Path path1 = Paths.get(".\\app\\.\\sys\\");
        Path res1 = path1.resolve("log");
        Path path2 = Paths.get("\\server\\exe\\");
        Path res2 = path2.resolve("\\readme.exe");
        System.out.println(res1);
        System.out.println(res2);
    }
}

class PathCheck2a {
    public static void main(String[] args) {
        // Given code fragment:

        Path path1 = Paths.get("/app/./sys/");
        Path res1 = path1.resolve("log");
        Path path2 = Paths.get("/server/exe/");
        Path res2 = path2.resolve("/readme/");
        System.out.print(res1);
        System.out.print(res2);
    }
}

class PathCheck3 {
    public static void main(String[] args) {
        Path path1 = Paths.get("/foo/././foo/bar.txt");
        Path path2 = path1.normalize();
        Path path3 = path2.relativize(path1);
        Path path4 = path3.normalize();
        System.out.printf("%s  .:|:. %s .:|:. %s .:|:. %s\n", path1, path2, path3, path4);
        System.out.printf("%s  .:|:. %s .:|:. %s .:|:. %s", path1.getNameCount(), path2.getNameCount(), path3.getNameCount(), path4.getNameCount());
    }
}


