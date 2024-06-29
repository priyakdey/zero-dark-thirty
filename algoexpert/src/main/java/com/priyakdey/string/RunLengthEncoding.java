package com.priyakdey.string;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class RunLengthEncoding {

    // Write a function that takes in a non-empty string and returns its run-length encoding.
    // From Wikipedia, "run-length encoding is a form of lossless data compression in which runs
    // of data are stored as a single data value and count, rather than as the original run." For
    // this problem, a run of data is any sequence of consecutive, identical characters. So the
    // run "AAA" would be run-length-encoded as "3A".
    // To make things more complicated, however, the input string can contain all sorts of
    // special characters, including numbers. And since encoded data must be decodable, this
    // means that we can't naively run-length-encode long runs. For example, the run
    // "AAAAAAAAAAAA" (12 As), can't naively be encoded as "12A", since this string can be
    // decoded as either "AAAAAAAAAAAA" or "1AA". Thus, long runs (runs of 10 or more characters)
    // should be encoded in a split fashion; the aforementioned run should be encoded as "9A3A".

    public String runLengthEncoding(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        StringBuilder buf = new StringBuilder();
        int count = 1;
        char lastSeenChar = string.charAt(0);

        for (int i = 1, length = string.length(); i < length; i++) {
            char ch = string.charAt(i);
            if (ch != lastSeenChar || count == 9) {
                buf.append(count);
                buf.append(lastSeenChar);
                count = 1;
                lastSeenChar = ch;
            } else {
                count++;
            }
        }

        buf.append(count);
        buf.append(lastSeenChar);

        return buf.toString();
    }

}
