package code;

import java.io.*;
import java.util.*;

class Plus {
    int x;
    int y;
    int length;

    public Plus(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    public Plus(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Plus() {
    }

    int getVolume() {
        return length * 4 - 3;
    }
    boolean conflicts(Plus other) {


        return false;
    }

    int right() {
        return x + length - 1;
    }
    int left() {
        return x - length + 1;
    }

    int up() {
        return y - length + 1;
    }

    int down() {
        return y + length - 1;
    }
};

public class Solution {

    static int[][] getGrid(String[] grid) {
        int[][] greed = new int[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length(); ++j) {
                if (grid[i].charAt(j) == 'G')
                    greed[i][j] = 1;
                else greed[i][j] = 0;
            }
        }

        return greed;
    }

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {

        ArrayList<Plus> list = new ArrayList<>();
        int[][] greed = getGrid(grid);


        // ----------- Extra cases -----------
        boolean notContains = false;

        for (int i = 0; i < grid.length; ++i) {
            if (grid[i].contains("G")) {
                // list.add(1);
                notContains = false;
                break;
            }
            else notContains = true;
        }

        if (notContains) {
            return 0;
        }

        // ----------- End cases -----------


        // ----------- Store Plus -----------
        int length = greed.length;
        int width = greed[0].length;

        for (int i = 1; i < length - 1; ++i) {
            for (int j = 1; j < width - 1; ++j) {

                if (greed[i][j] == 1) {
                    int depth = Math.min(Math.min(i, j), Math.min(length - i - 1, width - j - 1));
                    int len = (getNumeric(i, j, greed, depth) - 1) / 4;
                    if (len > 1)
                        list.add(new Plus(i, j, len));
                }
            }
        }

        // ----------- Plus Stored -----------



        // ----------- Find Max -----------
        int max = Integer.MIN_VALUE;
        int product = -1;

        for (Plus srcPLus : list) {
            for (Plus otherPlus : list) {
                if (! otherPlus.conflicts(srcPLus)) {
                    max = Math.max(srcPLus.getVolume() * otherPlus.getVolume(), max);
                }
            }
        }
        // ----------- Max Found -----------

        return max;
    }


    public static int getNumeric(int i, int j, int[][] greed, int depth) {
        int a = 0;
        int max = 1;

        while (++a <= depth) {
            if (greed[i][j + a] == 1 && greed[i][j - a] == 1 && greed[i + a][j] == 1 && greed[i - a][j] == 1) {
                max = (4 * a) + 1;

                greed[i][j + a] = 2;
                greed[i][j - a] = 2;
                greed[i + a][j] = 2;
                greed[i - a][j] = 2;
                greed[i][j] = 2;

                for (int[] row : greed) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println();

            }
            else return max;
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();
        // bufferedWriter.close();

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}
