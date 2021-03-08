package practice.interview.prepraration.kit.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class FraudlentActivityNotificationFaster {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int size;
        int elementToAdd;
        int notifications = 0;
        List<Integer> trailingList = new ArrayList<>();

        if (expenditure.length <= d) return 0;

        for (int i = 1; i < expenditure.length; i++) {
            if (trailingList.size() == d) {
                int elementToRemove = expenditure[i - d - 1];
                System.out.println("remove: " + elementToRemove);
                trailingList.remove((Integer) elementToRemove);
            }
            elementToAdd = expenditure[i - 1];
            trailingList.add(elementToAdd);
            System.out.println("add: " + elementToAdd);

            trailingList = trailingList.stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(trailingList.toString());

            double average;
            size = trailingList.size();
            if (size % 2 != 0) {
                average = trailingList.get(size / 2) * 2;
            } else {
                average = (trailingList.get((size / 2) - 1) + trailingList.get(size / 2));
            }

            if (expenditure[i] >= average && trailingList.size() == d) {
                notifications++;
            }
        }
        return notifications;
    }

}
