package practice.interview.prepraration.kit.sorting;

import java.util.*;

public class FraudlentActivityNotificationFaster {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int check1, check2;
        double average;
        int elementToRemove;
        int elementToAdd;
        int notifications = 0;
        List<Integer> trailingList = new ArrayList<>(d);
        int insertIndex;

        if (expenditure.length <= d) return 0;

        check2 = d / 2;
        if (d % 2 != 0) {
            check1 = check2;
        } else {
            check1 = (d / 2) - 1;
        }

        for (int i = 1; i < d; i++) {
            elementToAdd = expenditure[i - 1];
            insertIndex = Collections.binarySearch(trailingList, elementToAdd);
            if (insertIndex < 0) {
                insertIndex = (-1 * insertIndex) - 1;
            }
            trailingList.add(insertIndex, elementToAdd);
        }

        System.out.println(trailingList.size() + " " + d);

        for (int i = d; i < expenditure.length; i++) {

            if (trailingList.size() == d) {
                elementToRemove = expenditure[i - d - 1];
                trailingList.remove((Integer) elementToRemove);
            }
            elementToAdd = expenditure[i - 1];
            insertIndex = Collections.binarySearch(trailingList, elementToAdd);
            if (insertIndex < 0) {
                insertIndex = (-1 * insertIndex) - 1;
            }
            trailingList.add(insertIndex, elementToAdd);

            if (trailingList.size() == d) {
                average = trailingList.get(check1) + trailingList.get(check2);
                if (expenditure[i] >= average) notifications++;
            }
        }
        return notifications;
    }
}
