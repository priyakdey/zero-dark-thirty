package com.priyakdey.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class TwoSum {

    // https://leetcode.com/problems/two-sum-iii-data-structure-design/

    private final List<Integer> elements;

    public TwoSum() {
        this.elements = new ArrayList<>();
    }

    public void add(int number) {
        if (elements.isEmpty()) {
            elements.add(number);
            return;
        }

        if (number <= elements.getFirst()) {
            elements.addFirst(number);
            return;
        }

        if (number >= elements.getLast()) {
            elements.add(number);
            return;
        }

        int left = 0, right = elements.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (number <= elements.get(mid)) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        elements.add(index, number);
    }

    public boolean find(int value) {
        int left = 0, right = elements.size() - 1;
        while (left < right) {
            if (elements.get(left) + elements.get(right) == value) {
                return true;
            } else if (elements.get(left) + elements.get(right) < value) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

}
