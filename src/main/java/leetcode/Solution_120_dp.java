package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-03-14 21:59
 **/
public class Solution_120_dp {
    public static int minimumTotal(List<List<Integer>> triangle) {

        int[] v = new int[triangle.get(triangle.size()-1).size()];
        Arrays.fill(v, 0);

        int row = triangle.size();
        if(row == 1){
            return triangle.get(0).get(0);
        }
        for (int i = row-2; i>=0; i--){
            List<Integer> colValues = triangle.get(i+1);
            for (int j = 0; j <= colValues.size()-2; j++) {
                v[j] = Math.min(v[j]+colValues.get(j), v[j+1]+colValues.get(j+1));
            }
            if(i == 0){
                v[0] += triangle.get(0).get(0);
            }
        }
        return v[0];
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE / 2 + 1000000);

    }
}
