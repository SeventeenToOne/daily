package bishi.youzan2019;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        //System.out.println(str);
        String[] links;
        if(str.contains("\\|")){
            links = str.split("\\|");
        }else {
            links = new String[1];
            links[0] = str;
        }

        //System.out.println(links.length);

        String aTemplink;
        String bTemplink;
        if(links.length == 1){
             aTemplink = links[0];
             bTemplink = "";
        }else {
             aTemplink = links[0];
             bTemplink = links[1];
        }


//        System.out.println(aTemplink);
//        System.out.println(bTemplink);

        String[] aLink ;
        String[] bLink ;

        if(aTemplink.equals("")){
            aLink = new String[0];
        }else {
            aLink = aTemplink.split(",");
        }

        if(bTemplink.equals("")){
            bLink = new String[0];
        }else {
            bLink = bTemplink.split(",");
        }

//        for (String s : aLink) {
//            System.out.println(s);
//        }
//        for (String s : bLink) {
//            System.out.println(s);
//        }
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (i < aLink.length && j < bLink.length){
            int aval = Integer.valueOf(aLink[i]);
            int bval = Integer.valueOf(bLink[j]);
            if(aval > bval){
                res.add(bval);
                j++;
            }else if(aval < bval){
                res.add(aval);
                i++;
            }else {
                res.add(aval);
                i++;
                j++;
            }
        }

        while(i < aLink.length){
            res.add(Integer.valueOf(aLink[i]));
            i++;
        }
        while(j < bLink.length){
            res.add(Integer.valueOf(bLink[j]));
            j++;
        }

        System.out.print("[");
        for (int x = 0; x < res.size(); x++) {
            if(x == res.size()-1){
                System.out.print(res.get(x));
            }else {
                System.out.print(res.get(x) + ", ");
            }

        }
        System.out.println("]");


    }
}
// 1,2,3|2,4,6,7
//[1, 2, 3, 4, 6, 7]
// 1,2,3|2,4,6,7
//  |2,4,6,7
// 2,4,6,7