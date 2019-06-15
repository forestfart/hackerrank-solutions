package oracle.ocp;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        System.out.println("(path1.compareTo(path2) == 0) is: "
                + (path1.compareTo(path2) == 0));

        // comparing two paths using equals() method
        System.out.println("path1.equals(path2) is: " + path1.equals(path2));

        // comparing two paths using equals() method with absolute path
        System.out.println("path2.equals(path1.toAbsolutePath()) is "
                + path2.equals(path1.toAbsolutePath()));
    }
}


