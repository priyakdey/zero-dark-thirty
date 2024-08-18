package com.priyakdey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int length = startTime.length;
        List<Job> jobs = new ArrayList<>();
        int maxEndTime = 0;
        for (int i = 0; i < length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            maxEndTime = Math.max(maxEndTime, endTime[i]);
        }

        Comparator<Job> comparator = Comparator.comparingInt(j -> j.startTime);
        jobs.sort(comparator);

        return jobScheduling(jobs, 0, 0);
    }

    private int jobScheduling(List<Job> jobs, int index, int lastEndTime) {
        if (index == jobs.size()) return 0;

        // do not schedule this job
        int maxProfit = jobScheduling(jobs, index + 1, lastEndTime);

        // schedule this job
        Job job = jobs.get(index);
        if (job.startTime >= lastEndTime) {
            int i = -1;
            int left = index + 1, right = jobs.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (jobs.get(mid).startTime >= job.endTime) {
                    i = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (i != -1) {
                maxProfit = Math.max(maxProfit,
                        job.profit + jobScheduling(jobs, i, job.endTime));
            }

        }

        return maxProfit;
    }

    private record Job(int startTime, int endTime, int profit) {
    }

}
