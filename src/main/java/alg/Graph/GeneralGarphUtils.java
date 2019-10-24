package alg.Graph;

/**
 * @program: algorithms
 * @description: 常用的图的处理代码
 * @author: wxq
 * @date 2019-05-21 15:47
 **/
public class GeneralGarphUtils {
    //计算v的度数
    public static int degree(Graph G, int v){
        int degree = 0;
        for (Integer integer : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    //计算所有顶点的最大度数
    public static int maxDegree(Graph G){
        int maxDegree = 0;
        for (int i = 0; i < G.V(); i++) {
            int curDegree = degree(G, i);
            maxDegree = curDegree > maxDegree? curDegree : maxDegree;
        }
        return maxDegree;
    }

    //计算所有顶点的平均度数
    public static double avgDegree(Graph G){
        return 2.0 * G.E() / G.V();
    }

    //计算自环的个数
    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0; v < G.V(); v++){
            for (Integer w : G.adj(v)) {
                if (w == v) count++;
            }
        }

        return count / 2;
    }

    //图的邻接表的字符串表示
    public static String toString(Graph G){
        String s = G.V() + " vertices, " + G.E() + " edges\n";
        for (int v = 0; v < G.V(); v++) {
            s += v + ": ";
            for (Integer w : G.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;

    }
}
