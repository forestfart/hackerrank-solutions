package practice.interview.preparation.kit.sorting;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FraudlentActivityNotificationFastest {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        double median = 0;
        int tempIndex = d - 1;
        boolean odd = (d % 2 == 0) ? false : true;
        int index = odd ? d / 2 : d / 2 - 1;
        List<Integer> temp = IntStream.of(expenditure)
                .limit(d)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        Function<Integer, Double> fn = i -> odd ?
                (double) temp.get(i) :
                (double) (temp.get(i) + temp.get(i + 1)) / 2;

        for (int i = d; i < expenditure.length; i++) {
            median = fn.apply(index);

            if (expenditure[i] >= median * 2) {
                count++;
            }
            if (expenditure[i] == expenditure[i - d]) {
                continue;
            }

            int rmIndex = Collections.binarySearch(temp, expenditure[i - d]);
            temp.remove(rmIndex);
            tempIndex = Collections.binarySearch(temp, expenditure[i]);
            if (tempIndex < 0) {
                tempIndex = (-1 * tempIndex) - 1;
            }
            temp.add(tempIndex, expenditure[i]);
        }

        return count;
    }

}
