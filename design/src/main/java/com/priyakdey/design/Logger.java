package com.priyakdey.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class Logger {

    // https://leetcode.com/problems/logger-rate-limiter/description/

    private final Map<String, Integer> logs;

    public Logger() {
        this.logs = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!logs.containsKey(message) || timestamp >= logs.get(message) + 10) {
            logs.put(message, timestamp);
            return true;
        }

        return false;
    }

}
