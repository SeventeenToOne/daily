package bishi.weibo2019;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] versions = str.split(", ");

//        for (String version : versions) {
//            System.out.println(version);
//        }

        String minStr = versions[0];
        for (int i = 1; i < versions.length; i++) {
            if(compare(minStr, versions[i]) > 0){

                minStr = versions[i];
            }
        }

        System.out.println(minStr);
    }

    public static int compare(String a, String b){
        String[] as = a.split("\\.");
        String[] bs = b.split("\\.");

//        System.out.println("compare");
//        for (String s : as) {
//            System.out.println(s);
//        }
//
//        for (String s : bs) {
//            System.out.println(s);
//        }
//        System.out.println("compare");

        int minLen = Math.min(as.length, bs.length);

        for(int i = 0; i < minLen; i++){
            int anum = Integer.valueOf(as[i]);
            int bnum = Integer.valueOf(bs[i]);

            if(anum > bnum){
                return 1;
            }

            if(anum < bnum){
                return -1;
            }
        }

        if(as.length > minLen){
            return 1;
        }

        return  -1;
    }

}

/*
3, 4.3.5.4, 2.10.3, 2.4
* */
