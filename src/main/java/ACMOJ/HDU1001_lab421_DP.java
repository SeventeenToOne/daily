package ACMOJ;


import java.util.*;

/**
 * @program: algorithms
 * @description: dp
 * @author: wxq
 * @date 2018-06-28 11:01
 **/
public class HDU1001_lab421_DP {

//    static class Shape implements Comparable<Shape>{
//        int x, y;
//        int area;
//        public Shape(int x, int y){
//            this.x = x;
//            this.y = y;
//            this.area = x * y;
//        }
//
//        @Override
//        public int compareTo(Shape shape) {
//            if(shape.area == this.area){
//                return 0;
//            }
//            if ((this.area < shape.area) &&
//                    ((this.x < shape.x && this.y < shape.y) || (this.x < shape.y && this.y < shape.x)) ){
//                return -1;
//            }else {
//                return 1;
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "Shape{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    ", area=" + area +
//                    '}';
//        }
//
//    }

    static class Block implements Comparable{
        int x, y, height, area;

        public Block(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.area = x * y;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "x=" + x +
                    ", y=" + y +
                    ", height=" + height +
                    '}';
        }


        public int compareTo(Object o) {
            Block block = (Block) o;
            if(this.area == block.area){

                return 0;
            }else if(this.area < block.area){
                return -1;
            }else {
                return 1;
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Block block = (Block) o;
            return x == block.x &&
                    y == block.y &&
                    height == block.height &&
                    area == block.area;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y, height, area);
        }
    }

    // 1 10 20 30
    // 2 6 8 10 5 5 5
    // 7 1 1 1 2 2 2 3 3 3 4 4 4 5 5 5 6 6 6 7 7 7
    // 5 31 41 59 26 53 58 97 93 23 84 62 64 33 83 27
    // 2 3 3 4 3 3 5
    // 3 3 3 4 3 3 5 2 6 10

    public static void main(String[] args){
        int n , count = 0;
        Scanner scan = new Scanner(System.in);


        while((n = scan.nextInt()) != 0){
            count++;
            int x, y, z;
            ArrayList<Block> blocks = new ArrayList<>();
            //Set<Block> simpleBlocks = new HashSet<>();
            for (int i = 0; i < n; i++) {
                x = scan.nextInt();
                y = scan.nextInt();
                z = scan.nextInt();

                blocks.add(new Block(x, y, z));
                blocks.add(new Block(y, z, x));
                blocks.add(new Block(z, x, y));
            }
//            for (Block simpleBlock : simpleBlocks) {
//                blocks.add(simpleBlock);
//            }
            Collections.sort(blocks);
            int maxHeight = maxHeight(blocks);
            System.out.println("Case " + count + ": maximum height = " + maxHeight);
        }

    }

    public static int maxHeight(ArrayList<Block> blocks){

        int[] dpHeight = new int[blocks.size()];

        //
//        for (Block block : blocks) {
//            System.out.print(block + " ");
//        }
//        System.out.println();
        for (int i = 1; i < blocks.size(); i++) {
            if((blocks.get(i).x == blocks.get(i-1).x && blocks.get(i).y == blocks.get(i-1).y)
                    || (blocks.get(i).x == blocks.get(i-1).y && blocks.get(i).y == blocks.get(i-1).x)){
                if(blocks.get(i).height > blocks.get(i-1).height){
                    blocks.get(i-1).height = blocks.get(i).height;
                }else {
                    blocks.get(i).height = blocks.get(i-1).height;
                }
            }
        }
//        for (Block block : blocks) {
//            System.out.print(block + " ");
//        }
//        System.out.println();


        for (int i = 0; i < dpHeight.length; i++) {
            dpHeight[i] = blocks.get(i).height;
        }
        dpHeight[0] = blocks.get(0).height;


        for(int i = 1; i < blocks.size(); i++){
            for(int j = 0; j < i; j++){

                if(less(blocks.get(j), blocks.get(i))){
                    dpHeight[i] = max(dpHeight[i], dpHeight[j] + blocks.get(i).height);
                }
            }
        }

        // out
//        for (Block block : blocks) {
//            System.out.print(block + "\t");
//        }
//        System.out.println();
//        for (int i : dpHeight) {
//            System.out.print(i + "\t");
//        }
//        System.out.println();
       return max(dpHeight);
    }

    public static boolean less(Block b1, Block b2){

        if ((b1.area < b2.area) &&
                ((b1.x < b2.x && b1.y < b2.y) || (b1.x < b2.y && b1.y < b2.x)) ){
            return true;
        }else {
            return false;
        }

    }

    public static int max(int i, int j){
        return i > j ? i: j;
    }

    public static int max(int[] a){
        int max = -1;
        for (int i : a) {
            if(max < i){
                max = i;
            }
        }
        return max;
    }
}


/*
Monkey and Banana
Time Limit : 2000/1000ms (Java/Other)   Memory Limit : 65536/32768K (Java/Other)
Total Submission(s) : 3   Accepted Submission(s) : 1
Font: Times New Roman | Verdana | Georgia
Font Size: ← →
Problem Description
A group of researchers are designing an experiment to test the IQ of a monkey. They will hang a banana at the roof of a building, and at the mean time, provide the monkey with some blocks. If the monkey is clever enough, it shall be able to reach the banana by placing one block on the top another to build a tower and climb up to get its favorite food.

The researchers have n types of blocks, and an unlimited supply of blocks of each type. Each type-i block was a rectangular solid with linear dimensions (xi, yi, zi). A block could be reoriented so that any two of its three dimensions determined the dimensions of the base and the other dimension was the height.

They want to make sure that the tallest tower possible by stacking blocks can reach the roof. The problem is that, in building a tower, one block could only be placed on top of another block as long as the two base dimensions of the upper block were both strictly smaller than the corresponding base dimensions of the lower block because there has to be some space for the monkey to step on. This meant, for example, that blocks oriented to have equal-sized bases couldn't be stacked.

Your job is to write a program that determines the height of the tallest tower the monkey can build with a given set of blocks.
Input
The input file will contain one or more test cases. The first line of each test case contains an integer n,
representing the number of different blocks in the following data set. The maximum value for n is 30.
Each of the next n lines contains three integers representing the values xi, yi and zi.
Input is terminated by a value of zero (0) for n.
Output
For each test case, print one line containing the case number (they are numbered sequentially starting from 1) and the height of the tallest possible tower in the format "Case case: maximum height = height".
Sample Input
1
10 20 30
2
6 8 10
5 5 5
7
1 1 1
2 2 2
3 3 3
4 4 4
5 5 5
6 6 6
7 7 7
5
31 41 59
26 53 58
97 93 23
84 62 64
33 83 27
0
Sample Output
Case 1: maximum height = 40
Case 2: maximum height = 21
Case 3: maximum height = 28
Case 4: maximum height = 342
* */
