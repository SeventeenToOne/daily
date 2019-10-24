package bishi.didi;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-09-18 20:02
 **/
public class Main {

    public static void main(String[] args) {
        int[][] p = {{5,1,6,7},{7,5,1,6},{9,8,4,10}};
        List<List<Integer>> pro = new ArrayList<>() ;
        for(int i = 0 ; i < 3 ; ++ i){
            List<Integer> one = new ArrayList<>() ;
            for(int j = 0 ; j < 4 ; ++ j){
                one.add(p[i][j]) ;
            }
            pro.add(one);
        }
        List<Integer> ans = solve(3,4,2,pro);
        for(int i = 0 ; i < ans.size() ; ++ i){
            System.out.println(ans.get(i));
        }
    }

    public static List<Integer> solve(int numCustomer,int numProduct,int numK,List<List<Integer>> productList){
        Map<Integer,Integer> ans = new HashMap<>();
        for(int i = 0 ; i < productList.size() ; ++ i){
            List<Integer> one = productList.get(i) ;
            for(int j = 0 ; j < one.size() ; ++ j){
                int num = one.get(j) ;
                if(ans.containsKey(num)){
                    ans.put(num , ans.get(num) + 1) ;
                }
                else{
                    ans.put(num,1);
                }
            }
        }
        List<Integer> answer = new ArrayList<>() ;
        for(Map.Entry<Integer,Integer> entry : ans.entrySet()){
            if(entry.getValue() >= numK){
                answer.add(entry.getKey()) ;
            }
        }
        Collections.sort(answer);
        return answer;
    }

}
