package greedy;

import java.util.Arrays;

/**
 * @author yaosen.pys
 * @date 2021/07/17
 */
public class L452 {
    public static int findMinArrowShots(int[][] points) {
        if (null == points || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> {
            return a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1);
        });

        int min = points[0][1];
        int diffArrow = 0;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= min) {
                diffArrow++;
                if (points[i][1] < min) {
                    min = points[i][1];
                }
            } else {
                min = points[i][1];
            }

        }
        return points.length - diffArrow;
    }

    public static void main(String[] args) {
        // [[10,16],[2,8],[1,6],[7,12]]
        //int[][] points = new int[4][2];
        //
        //points[0][0] = 10;
        //points[0][1] = 16;
        //points[1][0] = 2;
        //points[1][1] = 8;
        //points[2][0] = 1;
        //points[2][1] = 6;
        //points[3][0] = 7;
        //points[3][1] = 12;
        //
        //System.out.println(findMinArrowShots(points));


        //[[1,2],[3,4],[5,6],[7,8]]

        //int[][] points = new int[4][2];
        //points[0][0] = 1;
        //points[0][1] = 2;
        //points[1][0] = 3;
        //points[1][1] = 4;
        //points[2][0] = 5;
        //points[2][1] = 6;
        //points[3][0] = 7;
        //points[3][1] = 8;
        //
        //System.out.println(findMinArrowShots(points));


        //[[1,2]]
        //int[][] points = new int[1][2];
        //points[0][0] = 1;
        //points[0][1] = 2;
        //System.out.println(findMinArrowShots(points));



        int[][] points = new int[2][2];
        points[0][0] = 1;
        points[0][1] = 2;
        points[1][0] = 1;
        points[1][1] = 2;
        System.out.println(findMinArrowShots(points));
    }
}
