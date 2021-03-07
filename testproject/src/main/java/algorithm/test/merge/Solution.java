package algorithm.test.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> selectList = null;
            for (int j = 0; j < resList.size(); j++) {
                if (resList.get(j).get(0).intValue() <= intervals[i][0]
                        && resList.get(j).get(1).intValue() >= intervals[i][0]) {
                    selectList = resList.get(j);
                    break;
                }
            }
            if (selectList == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(intervals[i][0]);
                arrayList.add(intervals[i][1]);
                resList.add(arrayList);
            } else {
                if (intervals[i][1] > selectList.get(1).intValue()) {
                    selectList.set(1, intervals[i][1]);
                }
            }

        }
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = new int[]{resList.get(i).get(0),resList.get(i).get(1)};
        }
        return res;
    }
}
