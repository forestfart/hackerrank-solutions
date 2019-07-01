package oracle.ocp.Stream;

import java.util.IntSummaryStatistics;
import java.util.regex.Pattern;

public class StreamDataMethods {

}

class WordStatistics {
    public static void main(String []args) {
        String limerick = "Limerick is a comic verse, containing five anapestic (unstressed/unstressed/stressed) lines," +
                "in which the first, second, and fifth lines are longer, rhyme together, and follow three metrical feet. " +
                "The third and fourth lines rhyme together, are shorter, and follow two metrical feet. However, sometimes " +
                "it may vary, and amphibrachic (unstressed/stressed/unstressed) form can replace anapestic. " +
                "In fact, it is a bawdy, humorous, or nonsensical verse written in the form of five anapests, with an aabba " +
                "rhyme scheme. Since it has a special structure and format, it is called fixed or closed form of poetry.";

        IntSummaryStatistics wordStatistics = Pattern.compile("[ \\t\\n\\x0B\\f\\r]")
                .splitAsStream(limerick)
                .mapToInt(String::length)
                .summaryStatistics();

        System.out.printf(" Number of words = %d\n Sum of the length of the words = %d\n" +
                        " Minimum word size = %d\n Maximum word size %d\n Average word size = %f\n",
                wordStatistics.getCount(),
                wordStatistics.getSum(),
                wordStatistics.getMin(),
                wordStatistics.getMax(),
                wordStatistics.getAverage());
    }
}