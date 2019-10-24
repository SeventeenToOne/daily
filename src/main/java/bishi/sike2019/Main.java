package bishi.sike2019;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        //System.out.println(str);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\"'){
                continue;
            }

            if (str.charAt(i) == '<'){
                break;
            }

            res.append(str.charAt(i));

        }

        //System.out.println(res);
        if(res.length() >= 6 && res.charAt(0) == '%'){
            int last = res.length() - 1;
            if( (res.charAt(0) == '%' && res.charAt(0) == res.charAt(last - 2) )
                    && (res.charAt(1) == '2' && res.charAt(1) == res.charAt(last - 1) )
                    && (res.charAt(2) == '2' && res.charAt(2) == res.charAt(last) )
                    ){
                String temp  = res.substring(3, last - 2);
                res = new StringBuilder(temp);
            }
        }
        System.out.println(res);
    }
}
/*
"Cisco<sip:10000@172.16.130.42>"

"%22Cisco%22"<sip:10000@172.16.130.42>

<sip:10000@172.16.130.42>

Cisco
* */