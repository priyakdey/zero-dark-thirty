package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class CourseSchedule {

    // There are a total of numCourses courses you have to take, labeled from
    // 0 to numCourses - 1. You are given an array prerequisites where
    // prerequisites[i] = [ai, bi] indicates that you must take course bi
    // first if you want to take course ai.
    //
    // For example, the pair [0, 1], indicates that to take course 0 you have
    // to first take course 1.
    // Return true if you can finish all courses. Otherwise, return false.

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return canFinishBfs(numCourses, prerequisites);
    }

    private boolean canFinishBfs(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            if (!graph.containsKey(preCourse)) {
                graph.put(preCourse, new HashSet<>());
            }
            graph.get(preCourse).add(course);
            indegrees[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int courseCompleted = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            courseCompleted++;

            if (graph.containsKey(course)) {
                for (int c : graph.get(course)) {
                    indegrees[c]--;
                    if (indegrees[c] == 0) {
                        queue.add(c);
                    }
                }
            }
        }

        return courseCompleted == numCourses;
    }

}
