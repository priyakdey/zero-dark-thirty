package com.priyakdey.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class CollidingAsteroids {

    // You're given an array of integers asteroids, where each integer represents the size of an
    // asteroid. The sign of the integer represents the direction the asteroid is moving
    // (positive = right, negative = left). All asteroids move at the same speed, meaning that
    // two asteroids moving in the same direction can never collide.
    //
    // For example, the integer 4 represents an asteroid of size 4 moving to the right.
    // Similarly, -7 represents an asteroid of size 7 moving to the left.
    //
    // If two asteroids collide, the smaller asteroid (based on absolute value) explodes. If two
    // colliding asteroids are the same size, they both explode.
    //
    // Write a function that takes in this array of asteroids and returns an array of integers
    // representing the asteroids after all collisions occur.

    public int[] collidingAsteroids(int[] asteroids) {
        Objects.requireNonNull(asteroids);
        int length = asteroids.length;
        if (length < 2) return asteroids;

        Deque<Integer> stack = new ArrayDeque<>(length);

        for (int asteroid : asteroids) {
            if (asteroid >= 0) {
                stack.push(asteroid);
            } else {
                boolean push = true;
                while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                    int top = stack.pop();
                    if (Math.abs(asteroid) > Math.abs(top)) {
                        continue;
                    } else if (Math.abs(asteroid) < Math.abs(top)) {
                        asteroid = top;
                    } else {
                        push = false;
                        break;
                    }
                }
                if (push) {
                    stack.push(asteroid);
                }
            }
        }

        int[] remaining = new int[stack.size()];
        for (int i = remaining.length - 1; i >= 0; i--) {
            remaining[i] = stack.pop();
        }

        return remaining;
    }

}
