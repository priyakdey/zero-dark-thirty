package com.priyakdey;

public class FirstBadVersion {

    // https://leetcode.com/problems/first-bad-version/description/

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int badVersion = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                badVersion = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return badVersion;
    }


    private boolean isBadVersion(int version) {
        // stub
        return false;
    }

}
