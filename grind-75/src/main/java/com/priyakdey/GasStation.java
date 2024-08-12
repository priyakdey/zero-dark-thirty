package com.priyakdey;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class GasStation {

    // There are n gas stations along a circular route, where the amount of gas at the ith
    // station is gas[i].
    // You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the
    // ith station to its next (i + 1)th station. You begin the journey with an empty tank at one
    // of the gas stations.
    // Given two integer arrays gas and cost, return the starting gas station's index if you can
    // travel around the circuit once in the clockwise direction, otherwise return -1. If there
    // exists a solution, it is guaranteed to be unique

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0
            || gas.length != cost.length) {
            throw new IllegalArgumentException("invalid argument");
        }

        for (int start = 0; start < gas.length; start++) {
            if (gas[start] >= cost[start]) {
                int curr = (start + 1) % gas.length;
                int currentGas = gas[start] - cost[start];

                while (curr != start) {
                    if (currentGas + gas[curr] < cost[curr]) {
                        break;
                    }

                    currentGas = currentGas + gas[curr] - cost[curr];
                    curr = (curr + 1) % gas.length;
                }

                if (curr == start) {
                    return start;
                }
            }
        }

        return -1;
    }

}
