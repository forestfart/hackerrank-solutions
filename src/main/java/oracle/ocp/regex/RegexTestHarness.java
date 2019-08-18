package oracle.ocp.regex;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            System.out.print("Enter your regex: ");
            Pattern pattern = Pattern.compile(console.readLine());
            System.out.print("Enter input string to search: ");
            Matcher matcher = pattern.matcher(console.readLine());

            boolean found = false;
            while (matcher.find()) {
                System.out.printf("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n\n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found){
                System.out.print("No match found.\n\n");
            }
        }
    }
}
