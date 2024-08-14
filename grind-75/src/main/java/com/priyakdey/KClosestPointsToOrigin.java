package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        Comparator<Tuple> comparator =
                (t1, t2) -> t2.distanceSq - t1.distanceSq;
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>(k, comparator);

        for (int[] point : points) {
            int x = point[0], y = point[1];
            int distanceSq = distanceSq(x, y);
            if (maxHeap.size() < k) {
                maxHeap.offer(new Tuple(x, y, distanceSq));
            } else {
                Tuple root = maxHeap.peek();
                if (distanceSq < root.distanceSq) {
                    maxHeap.poll();
                    maxHeap.offer(new Tuple(x, y, distanceSq));
                }
            }
        }

        int[][] closest = new int[k][2];
        int cursor = 0;

        while (!maxHeap.isEmpty()) {
            Tuple root = maxHeap.poll();
            closest[cursor][0] = root.x;
            closest[cursor][1] = root.y;
            cursor++;
        }

        return closest;
    }

    private int distanceSq(int x, int y) {
        return x * x + y * y;
    }

    private record Tuple(int x, int y, int distanceSq) {
    }

}
