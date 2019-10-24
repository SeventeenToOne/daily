package leetcode;

import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: algorithms
 * @description:
 * 在LeetCode商店中， 有许多在售的物品。
 *
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 *
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 *
 * 任意大礼包可无限次购买。
 *
 * 示例 1:
 *
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释:
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
 * 示例 2:
 *
 * 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * 输出: 11
 * 解释:
 * A，B，C的价格分别为¥2，¥3，¥4.
 * 你可以用¥4购买1A和2B，也可以用¥9购买2A，2B和1C。
 * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
 * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
 * 说明:
 *
 * 最多6种物品， 100种大礼包。
 * 每种物品，你最多只需要购买6个。
 * 你不可以购买超出待购清单的物品，即使更便宜。
 * @author: wxq
 * @date 2019-04-02 13:44
 **/
public class Solution_638_dp {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minCost = Integer.MAX_VALUE;


        for (int i = 0; i < special.size(); i++) {
            if(IsSufficentNum(special.get(i), needs)){

                // 减去相应的数量, 计算最小值, 判断是否比最小值花费小
                List<Integer> tempNeeds  = new ArrayList();
                for (Integer need : needs) {
                    tempNeeds.add(need);
                }

                for (int j = 0; j < tempNeeds.size(); j++) {
                    tempNeeds.set(j, tempNeeds.get(j) - special.get(i).get(j));
                }
                minCost = Math.min(minCost, shoppingOffers(price, special, tempNeeds) + special.get(i).get(special.get(i).size()-1));
            }
        }


        int cost = 0;
        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }
        minCost = Math.min(cost, minCost);


        return minCost;
    }

    public static boolean IsSufficentNum(List<Integer> OneSecial, List<Integer> needs){
        boolean isSufficent = true;

        for (int i = 0; i < needs.size(); i++) {
            if(needs.get(i) - OneSecial.get(i) < 0){
                isSufficent = false;
                break;
            }
        }
        return isSufficent;
    }



    public static void main(String[] args) {
        int[] pri = new int[]{2, 3, 4};
        int[][] spr = new int[][]{{1, 1, 0, 4}, {2, 2, 1, 9}};
        int[] ne = new int[]{10, 20, 10};


        List<Integer> price = new ArrayList<Integer>();
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();

        for (int i = 0; i < pri.length; i++) {
            price.add(pri[i]);
        }
        for (int i = 0; i < spr.length; i++) {
            List<Integer> OneSpecial = new ArrayList<>();
            for (int j = 0; j < spr[i].length; j++) {
                OneSpecial.add(spr[i][j]);
            }
            special.add(OneSpecial);
        }
        for (int i : ne) {
            needs.add(i);
        }

        System.out.println(shoppingOffers(price, special, needs));
    }
}
