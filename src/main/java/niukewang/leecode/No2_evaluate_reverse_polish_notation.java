package niukewang.leecode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author: wxq
 * @date 2018-10-11 20:04
 **/
public class No2_evaluate_reverse_polish_notation {

    /*
    * 判断是否是是数字,还是哪种运算,
    * */
    public static int isNum(String s){
        if("*".equals(s)){
            return 1;
        }
        if ("/".equals(s)) {
            return 2;
        }
        if("-".equals(s)){
            return 3;
        }
        if ("+".equals(s)){
            return 4;
        }
        return 0;
    }

    public static int get(LinkedList<Integer> stack){
        if(stack.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return stack.removeLast();
    }

    public static boolean put(LinkedList<Integer> stack, int value){
        return stack.add(value);
    }
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            switch (isNum(token)){
                case 0:
                    put(stack, Integer.valueOf(token));
                    break;
                case 1:
                    if(!stack.isEmpty()){
                        put(stack, get(stack)*get(stack));
                    }
                    break;
                case 2:
                    if(!stack.isEmpty()){
                        int b = get(stack);
                        int a = get(stack);
                        put(stack, a / b);
                    }
                    break;
                case 3:
                    if(!stack.isEmpty()){
                        int b = get(stack);
                        int a = get(stack);
                        put(stack, a - b);
                    }
                    break;
                case 4:
                    if(!stack.isEmpty()){
                        int b = get(stack);
                        int a = get(stack);
                        put(stack, a + b);
                    }
                    break;
            }
        }
        return stack.getLast();
    }
}
