package com.priyakdey;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length, cols = image[0].length;
        floodFill(image, sr, sc, rows, cols, color, image[sr][sc]);
        return image;
    }

    public void floodFill(int[][] image, int row, int col, int rows,
                          int cols, int color, int startingColor) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != startingColor || image[row][col] == color) {
            return;
        }

        image[row][col] = color;
        floodFill(image, row + 1, col, rows, cols, color, startingColor);
        floodFill(image, row - 1, col, rows, cols, color, startingColor);
        floodFill(image, row, col + 1, rows, cols, color, startingColor);
        floodFill(image, row, col - 1, rows, cols, color, startingColor);
    }

}
