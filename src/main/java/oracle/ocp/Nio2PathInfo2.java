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

