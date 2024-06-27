package com.priyakdey.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 27-06-2024
 */
public class SweetAndSavory {

    // You're hosting an event at a food festival and want to showcase the best possible pairing
    // of two dishes from the festival that complement each other's flavor profile.
    // Each dish has a flavor profile represented by an integer. A negative integer means a dish
    // is sweet, while a positive integer means a dish is savory. The absolute value of that
    // integer represents the intensity of that flavor. For example, a flavor profile of -3 is
    // slightly sweet, one of -10 is extremely sweet, one of 2 is mildly savory, and one of 8 is
    // significantly savory.
    // You're given an array of these dishes and a target combined flavor profile. Write a
    // function that returns the best possible pairing of two dishes (the pairing with a total
    // flavor profile that's closest to the target one). Note that this pairing must include one
    // sweet and one savory dish. You're also concerned about the dish being too savory, so your
    // pairing should never be more savory than the target flavor profile.
    // All dishes will have a positive or negative flavor profile; there are no dishes with a 0
    // value. For simplicity, you can assume that there will be at most one best solution. If
    // there isn't a valid solution, your function should return [0, 0]. The returned array
    // should be sorted, meaning the sweet dish should always come first.

    public int[] sweetAndSavory(int[] dishes, int target) {
        Objects.requireNonNull(dishes);
        int length = dishes.length;
        if (length <= 1) return new int[]{0, 0};

        Arrays.sort(dishes);
        int sweetPtr = 0, savoryPtr = length - 1;
        int minDiff = Integer.MAX_VALUE;
        int sweetDish = 0, savoryDish = 0;

        while (dishes[sweetPtr] < 0 && dishes[savoryPtr] > 0) {
            int flavour = dishes[sweetPtr] + dishes[savoryPtr];
            if (flavour <= target) {
                int diff = target - flavour;
                if (diff < minDiff) {
                    sweetDish = dishes[sweetPtr];
                    savoryDish = dishes[savoryPtr];
                    minDiff = diff;
                }
                if (diff == 0) break;
                sweetPtr++;
            } else {
                savoryPtr--;
            }
        }

        return new int[]{sweetDish, savoryDish};
    }

}
