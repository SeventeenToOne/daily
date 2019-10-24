package bishi.huawei2019;

import java.util.Scanner;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-07-31 19:11
 **/


import java.util.Scanner;

//public class Main {
//
//    public static  int dN = -1;
//    public static  int dM = -1;
//    public static double min = Double.MAX_VALUE;
//    public static void main(String... args) {
//
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//
//        int pointIndex = -1;
//        int zeroIndex = -1;
//        char[] chars = line.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//
//            char ch = chars[i];
//
//            if (ch == '.') {
//                pointIndex = i;
//                break;
//            }
//        }
//
//
//        for (int i = chars.length - 1; i >= 0; i--) {
//            char ch = chars[i];
//            if (ch != '0') {
//                zeroIndex = i;
//                break;
//            }
//        }
//
//
//        if (zeroIndex == -1 || pointIndex == -1||zeroIndex<pointIndex) {
//            System.out.print(((int)(Double.parseDouble(line))));
//            System.out.println(" " + 1);
//            return;
//        }
//
//        //查找
//        int nums = zeroIndex - pointIndex;
//        //3.14159265358979 355 113
//        //if(nums>4) throw new RuntimeException("输入数据异常");
//        nums = nums > 4 ? 4 : nums;
//        int max =1;
//        for (int i = 1; i <=nums; i++) {
//            max *= 10;
//        }
//
//        double  d = Double.parseDouble(line);
//        for (int i = 2; i <=max; i++) {
//
//            double  value = d*1.0 * i;
//
//            String tvalue = String.valueOf(value);
//
//            if (!isFloatNUM(tvalue, i)) {
//                System.out.println(((int)(Double.parseDouble(tvalue))) + " " + i);
//                break;
//            }
//        }
//
//        System.out.println(dN + " " + dM);
//
//    }
//
//    private static boolean isFloatNUM(String tvalue, int index) {
//
//
//        int len = tvalue.length();
//
//        int pointIndex = -1;
//        int zeroIndex = -1;
//        for (int i = len - 1; i >= 0; i--) {
//
//            if(pointIndex!=-1&&zeroIndex!=-1) break;
//            char ch = tvalue.charAt(i);
//            if(ch=='.') pointIndex = i;
//            if(zeroIndex==-1&&ch!='0') zeroIndex = i;
//        }
//
//
//        String valuemin = tvalue.substring(0,pointIndex);
//
//        double dvalue = Double.parseDouble(valuemin) + (tvalue.charAt(pointIndex + 1) >= '5' ? 1 : 0);
//        double ch = dvalue - Double.parseDouble(tvalue);
//        ch = ch < 0 ? -ch : ch;
//
//
//        if(min>ch){
//            dN = (int) dvalue;
//            dM = index;
//            min = ch;
//        }
//        return zeroIndex > pointIndex;
//
//    }
//}


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        int num = 1;
        while (num != 0) {
            String str1 = scan.next();
            String str2 = scan.next();
            if (str1.length() < str2.length()) {
                res.append(0);
                num--;
                continue;
            }
            str1 = str1 + str1;

            KMP  kmp = new KMP(str2);
            int result = kmp.search(str1);
            if (result < str1.length()){
                res.append(1);
            }else {
                res.append(0);
            }
            //System.out.println(str1);
//            boolean hasSub = true;
//            for(int i = 0; i < str1.length(); i++){
//                hasSub = true;
//                int t = i;
//                for(int j = 0; j < str2.length(); j++){
//                    if(t >= str1.length() ||  str1.charAt(t) != str2.charAt(j) ){
//                        hasSub = false;
//                        break;
//                    }
//                    t++;
//
//                }
//
//                if(hasSub){
//                    res.append(1);
//                    break;
//                }
//
//            }
//            if(!hasSub){
//                res.append(0);
//            }

            num--;

        }

        System.out.println(res.toString());

    }
}


class KMP {
    private final int R;
    private int[][] dfa;

    private char[] pattern;
    private String pat;


    public KMP(String pat) {
        this.R = 256;
        this.pat = pat;

        // build DFA from pattern
        int m = pat.length();
        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pat.charAt(j)][j] = j+1;
            x = dfa[pat.charAt(j)][x];
        }
    }


    public int search(String txt) {

        int m = pat.length();
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == m) return i - m;
        return n;
    }


}

/*

AABCD
CDAA
AABCD
ABCD
AABCD
CFS

* */