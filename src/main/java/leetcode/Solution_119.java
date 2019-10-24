package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        if(rowIndex <= 0){
            list.add(1);
            return list;
        }

        int[] arrays = new int[rowIndex + 1];
        arrays[0] = 1;
        arrays[1] = 1;
        for(int i = 2; i <= rowIndex; i++){
            arrays[i] = 1;
            for(int j = i-1; j >0; j--){
                arrays[j] = arrays[j-1] + arrays[j];
            }
        }

        for (int array : arrays) {
            list.add(array);
        }
        return list;

    }

    public static void main(String[] args) {
        Solution_119 solution = new Solution_119();
        System.out.println(solution.getRow(3));
    }
}

/*
119. 杨辉三角 II

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]

* */
