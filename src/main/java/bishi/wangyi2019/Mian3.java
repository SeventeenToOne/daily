package bishi.wangyi2019;

    import java.util.Scanner;

    public class Mian3 {
        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4};
            int xNum = 4;
            Scanner scan = new Scanner(System.in);
            int numCount = scan.nextInt();
            int searchCount = scan.nextInt();
            int[] arrNum = new int[numCount];
            int[] searchArr = new int[searchCount];
            for (int i = 0; i < numCount; i++) {
                arrNum[i] = scan.nextInt();
            }

            for (int i = 0; i < searchCount; i++) {
                searchArr[i] = scan.nextInt();
            }

            for(int i = 0; i < searchCount; i++){
                int startIndex = testCount(arrNum, searchArr[i]);
                System.out.println(startIndex);
            }
        }

        public static int testCount(int[] nums, int xNum){
            int low = 0;
            int hight = nums.length - 1;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] >= xNum){
                    nums[i] -= 1;
                    count++;
                }
            }
            return count;
        }
    }
