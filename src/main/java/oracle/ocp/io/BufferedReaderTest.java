package oracle.ocp.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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

class WriteFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(".\\src\\main\\resources\\DeterminingDnaHealth.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(".\\src\\main\\resources\\copy.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.append(line + "\n");
        }
        bufferedWriter.flush();
    }
}

class AutoCloseableFun {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src\\main\\resources\\BufferedReaderInput.txt");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader bufferedReader = new BufferedReader(isr)) {
            if (bufferedReader.markSupported()) {
                System.out.println((char) bufferedReader.read());
                bufferedReader.mark(12);
                System.out.println((char) bufferedReader.read());
                bufferedReader.reset();
                System.out.println((char) bufferedReader.read());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class BufferedReaderInputFun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println(number);
    }
}