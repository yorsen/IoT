package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.misc.Queue;

/**
 * @author yaosen.pys
 * @date 2021/07/17
 */
public class L406 {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for(int[] p : people) {
            result.add(p[1], p);
        }

        return result.toArray(new int[people.length][]);
    }

    //[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    public static void main(String[] args) {
        int[][] people = new int[6][2];

        people[0][0] = 7;
        people[0][1] = 0;

        people[1][0] = 4;
        people[1][1] = 4;

        people[2][0] = 7;
        people[2][1] = 1;

        people[3][0] = 5;
        people[3][1] = 0;

        people[4][0] = 6;
        people[4][1] = 1;

        people[5][0] = 5;
        people[5][1] = 2;

        int[][] result = reconstructQueue(people);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0]);
            System.out.print(" , ");
            System.out.print(result[i][1]);
            System.out.println();
        }

    }
}
