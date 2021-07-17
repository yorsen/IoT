package greedy;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author yaosen.pys
 * @date 2021/07/10
 */
public class L455 {
    /**
     * 1、每次分配最小的饼干
     * 2、尽可能先满足胃口较小的小孩的需求
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
            }

            sIndex++;
        }

        return gIndex;
    }
}
