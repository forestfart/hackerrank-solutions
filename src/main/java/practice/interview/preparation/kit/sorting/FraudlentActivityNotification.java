package practice.interview.preparation.kit.sorting;

import java.util.*;

public class FraudlentActivityNotification {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int size;
        int elementToAdd;
        int notifications = 0;
        List<Integer> trailingList;

        if (expenditure.length <= d) return 0;

        for (int i = d; i < expenditure.length; i++) {
            trailingList = new LinkedList<>();
            for (int t = 0; t < d; t++) {
                elementToAdd = expenditure[i - (d - t)];
                int arrayIndex = binarySearch(trailingList, 0, trailingList.size() - 1, elementToAdd);
                trailingList.add(arrayIndex, elementToAdd);
            }
            double average;
            size = trailingList.size();
            if (size % 2 != 0) {
                average = trailingList.get(size / 2) * 2;
            } else {
                average = (trailingList.get((size / 2) - 1) + trailingList.get(size / 2));
            }

            if (expenditure[i] >= average) {
                notifications++;
            }
        }
        return notifications;
    }

    private static int binarySearch(List<Integer> list, int left, int right, int searchElement) {
        if (right - left < 0) return 0;
        if (right - left == 0) {
            if (list.get(left) < searchElement) {
                return right + 1;
            } else {
                return left;
            }
        }
        if (right - left == 1) {
            if (searchElement < list.get(left)) {
                return left;
            }
            if (searchElement < list.get(right)) {
                return right;
            }
            return right + 1;
        }
        int middle = (right + left) / 2;
        if (list.get(middle) <= searchElement) {
            return binarySearch(list, middle, right, searchElement);
        } else {
            return binarySearch(list, left, middle, searchElement);
        }
    }

}
