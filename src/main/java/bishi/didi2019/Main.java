package bishi.didi2019;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nStr = scan.nextLine();
        int N = Integer.valueOf(nStr);
        String str = scan.nextLine();
        String[] nums = str.split(" ");

//        for (String num : nums) {
//            System.out.println(num);
//        }
        for(int i = 0; i < nums.length; i = i + 2){
            boolean flag = false;
            for(int j = 2; j < nums.length - i; j = j + 2){
                int a = Integer.valueOf(nums[j-2]);
                int b = Integer.valueOf(nums[j]);

//                System.out.println(a + " " + b);

                if(nums[j-1].equals("*")){

                    if(a > b && (j-3 < 0 || !nums[j-3].equals("/"))){

//                        System.out.println(a + " " + b);
                        String temp = nums[j-2];
                        nums[j-2] = nums[j];
                        nums[j] = temp;
//                        System.out.println("nums: " + nums[j-2] + " " + nums[j]);
                        flag = true;
                    }

                }else if(nums[j-1].equals("+")){
                    if(a > b
                            && (j+1 >= nums.length || ( nums[j+1].equals("+") || nums[j+1].equals("-") ) )
                            && (j-3 < 0 || nums[j-3].equals("+"))){

                        String temp = nums[j-2];
                        nums[j-2] = nums[j];
                        nums[j] = temp;

                        flag = true;
                    }
                }else if(nums[j-1].equals("-")){
                    if(a > b
                            && (j+1 >= nums.length || (nums[j+1].equals("-") || nums[j+1].equals("+"))   )
                            && (j-3 >= 0 && nums[j-3].equals("-"))){

                        String temp = nums[j-2];
                        nums[j-2] = nums[j];
                        nums[j] = temp;

                        flag = true;
                    }
                }else{
                    if(a > b && (j-3 >= 0 && nums[j-3].equals("/"))){

                        String temp = nums[j-2];
                        nums[j-2] = nums[j];
                        nums[j] = temp;

                        flag = true;
                    }
                }

            }

            if(!flag){
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if(i == nums.length -1){
                System.out.print(nums[i]);
            }else {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println();

    }
}
/*
6
3 + 2 + 1 + -4 * -5 + 1
* */