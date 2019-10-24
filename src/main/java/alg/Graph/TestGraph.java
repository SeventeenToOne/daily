package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.io.File;
import java.io.IOException;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-21 16:25
 **/
public class TestGraph {
    public static void main(String[] args){
        String tinyGPath = "src/main/java/alg/Graph/tinyG.txt";
        String tinyCGPath = "src/main/java/alg/Graph/tinyCG.txt";
        String mediumGURL = "src/main/java/alg/Graph/mediumG.txt";

        Graph tinyG = new Graph(new In(tinyGPath));
        Graph tinyCG = new Graph(new In(tinyCGPath));
        Graph mediumG = new Graph(new In(mediumGURL));


        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(tinyCG, 0);
        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(tinyCG, 0);
        CC c = new CC(tinyG);
        System.out.println("cc: " + c.count());

//        for (Integer v : depthFirstPaths.pathTo(5)) {
//            System.out.print(v +  " ");
//        }
//        System.out.println();
//        for (Integer v : breadthFirstPaths.pathTo(4)) {
//            System.out.print(v +  " ");
//        }
    }
}
