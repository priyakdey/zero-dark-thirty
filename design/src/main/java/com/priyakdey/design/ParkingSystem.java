package com.priyakdey.design;

public class ParkingSystem {
    // https://leetcode.com/problems/design-parking-system/

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean canPark = false;

        canPark = switch (carType) {
            case 1 -> {
                if (big > 0) {
                    big -= 1;
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (medium > 0) {
                    medium -= 1;
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (small > 0) {
                    small -= 1;
                    yield true;
                }
                yield false;
            }
            default -> false;
        };

        return canPark;
    }
}
