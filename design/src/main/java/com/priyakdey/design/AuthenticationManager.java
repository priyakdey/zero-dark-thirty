package com.priyakdey.design;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    // https://leetcode.com/problems/design-authentication-manager/

    private final Map<String, Integer> cache;
    private final int ttl;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        cache = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        cache.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (cache.containsKey(tokenId) && cache.get(tokenId) + ttl > currentTime) {
            cache.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) cache.values().stream()
                .filter(timestamp -> timestamp + ttl <= currentTime).count();
    }
}
