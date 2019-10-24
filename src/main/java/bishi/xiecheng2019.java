package bishi;

import java.util.LinkedList;
import java.util.Scanner;

public class xiecheng2019 {
    public static String resolve(String expr){
        if("".equals(expr) || expr == null){
            return "";
        }

        char[] arr = expr.toCharArray();

        //括号匹配
        LinkedList<Character> stack1 = new LinkedList<>();
        //记录字母index
        LinkedList<Integer> stack2 = new LinkedList<>();


        for (int i = 0; i < expr.length(); i++) {
            if(expr.charAt(i) == '('){

                stack1.push('(');
                stack2.push(i);

            } else if(expr.charAt(i) == ')'){
                if(stack1.isEmpty()){
                    return "";
                }else {
                    stack1.pop();
                    int lo = stack2.pop();
                    int hi = i;

                    while(lo <= hi){
                        while (expr.charAt(lo) == '(' || expr.charAt(lo) == ')'){
                            lo++;
                        }
                        while (expr.charAt(hi) == '(' || expr.charAt(hi) == ')'){
                            hi--;
                        }
                        if(lo > hi){
                            break;
                        }
                        arr[lo] =  expr.charAt(hi);
                        arr[hi] =  expr.charAt(lo);
                        lo++;
                        hi--;
                    }

                }
            }
        }

       StringBuilder res = new StringBuilder();
        for (char c : arr) {
            if(c != '(' && c != ')'){
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expr = scan.next();
        System.out.println(resolve(expr));

    }
}

/*
((ur)oi)k)

((ur)oi)kt

((ur)oi)(kt)

(1)

(((ur)oi)(kt))

((ba)(dc)(fe))

* */
