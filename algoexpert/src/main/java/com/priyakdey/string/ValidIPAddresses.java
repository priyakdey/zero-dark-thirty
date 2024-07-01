package com.priyakdey.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class ValidIPAddresses {

    // You're given a string of length 12 or smaller, containing only digits. Write a function
    // that returns all the possible IP addresses that can be created by inserting three .s in
    // the string.
    // An IP address is a sequence of four positive integers that are separated by .s, where each
    // individual integer is within the range 0 - 255, inclusive.
    // An IP address isn't valid if any of the individual integers contains leading 0s. For
    // example, "192.168.0.1" is a valid IP address, but "192.168.00.1" and "192.168.0.01"
    // aren't, because they contain "00" and 01, respectively. Another example of a valid IP
    // address is "99.1.1.10"; conversely, "991.1.1.0" isn't valid, because "991" is greater than
    // 255.
    // Your function should return the IP addresses in string format and in no particular order.
    // If no valid IP addresses can be created from the string, your function should return an
    // empty list.


    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> accumulator = new ArrayList<>();
        validIPAddresses(string, 0, new ArrayList<>(4), accumulator);
        return accumulator;
    }

    private void validIPAddresses(String string, int index, List<String> buffer,
                                  ArrayList<String> accumulator) {
        if (buffer.size() == 4 && index == string.length()) {
            accumulator.add(String.join(".", buffer));
            return;
        }

        if (buffer.size() == 4 || index == string.length()) {
            return;
        }

        for (int step = 1; step <= 3; step++) {
            if (index + step > string.length()) {
                break;
            }

            String segment = string.substring(index, index + step);
            int value = Integer.parseInt(segment);

            if (value > 255 || (segment.startsWith("0") && segment.length() > 1)) {
                break;
            }

            buffer.add(segment);
            validIPAddresses(string, index + step, buffer, accumulator);
            buffer.removeLast();
        }
    }

}
