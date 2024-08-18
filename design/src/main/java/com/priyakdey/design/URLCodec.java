package com.priyakdey.design;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class URLCodec {
    // https://leetcode.com/problems/encode-and-decode-tinyurl/

    private final MessageDigest digest;
    private final Map<String, String> urlMappings;

    public URLCodec() {
        try {
            digest = MessageDigest.getInstance("SHA-1");
            this.urlMappings = new HashMap<>();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Encodes a URL to a shortened URL.
     *
     * @param longUrl String
     * @return hashed URL
     */
    public String encode(String longUrl) {
        digest.update(longUrl.getBytes());
        String hash = new String(digest.digest());
        urlMappings.put(hash, longUrl);
        return hash;
    }

    /**
     * Decodes a shortened URL to its original URL.
     *
     * @param shortUrl String
     * @return decoded string
     */
    public String decode(String shortUrl) {
        return urlMappings.get(shortUrl);
    }
}
