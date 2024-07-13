package com.priyakdey.stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class SunsetViews {

    // Given an array of buildings and a direction that all of the buildings face, return an
    // array of the indices of the buildings that can see the sunset.
    //
    // A building can see the sunset if it's strictly taller than all of the buildings that come
    // after it in the direction that it faces.
    //
    // The input array named buildings contains positive, non-zero integers representing the
    // heights of the buildings. A building at index i thus has a height denoted by buildings[i].
    // All of the buildings face the same direction, and this direction is either east or west,
    // denoted by the input string named direction, which will always be equal to either "EAST"
    // or "WEST". In relation to the input array, you can interpret these directions as right for
    // east and left for west.
    //
    // Important note: the indices in the ouput array should be sorted in ascending order.

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        Objects.requireNonNull(buildings);
        int length = buildings.length;
        if (length == 0) return new ArrayList<>();
        if (length == 1) new ArrayList<>(List.of(0));

        Deque<Pair> deque = new ArrayDeque<>(length);

        switch (direction) {
            case "EAST":
                for (int i = 0; i < length; i++) {
                    int height = buildings[i];
                    while (!deque.isEmpty() && height >= deque.peekLast().height) {
                        deque.pollLast();
                    }
                    deque.offerLast(new Pair(height, i));
                }
                break;
            case "WEST":
                for (int i = length - 1; i >= 0; i--) {
                    int height = buildings[i];
                    while (!deque.isEmpty() && height >= deque.peekFirst().height) {
                        deque.pollFirst();
                    }
                    deque.offerFirst(new Pair(height, i));
                }
                break;
            default:
                throw new IllegalArgumentException("direction can be EAST or WEST");
        }

        return deque.stream().map(Pair::index).collect(Collectors.toCollection(ArrayList::new));
    }

    private record Pair(int height, int index) {
    }
}
