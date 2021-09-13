package 九月13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] point1: points) {
            // 使用哈希表存储当前点与其他点的相同距离的个数
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] point2: points) {
                int dis = distance(point1, point2);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            // 如果有n个距离相等的话，则根据排列组合有n(n-1)种情况
            // 比如3个距离相等 ab = ac = ae，那么就有6种情况，分别是(abc acb abe aeb ace aec)
            for (int dis: map.keySet()) {
                int n = map.get(dis);
                res += n * (n - 1);
            }
        }
        return res;
    }

    private int distance(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
