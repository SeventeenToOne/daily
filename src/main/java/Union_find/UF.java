package Union_find;

import java.util.Scanner;

/*
*
* @author wxq
* time 2018.1.25
*
* */
public class UF {
    private int[] id;
    private int count;
    public UF(int N){
        count = N;
        id = new int[count];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int getCount(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(q) == find(p);
    }
//    quick_find 算法，其时间复杂度平方级不适合大规模计算
//    public int find(int p){
//        return id[p];
//    }
//    // 算法的时间复杂度为平方级
//    public void union(int p, int q){
//        int pId = find(p);
//        int qId = find(q);
//
//        if(pId == qId) return;
//        for (int i = 0; i < id.length; i++) {
//            if(id[i] == pId) id[i] = qId;
//        }
//        count--;
//    }
    public int find(int p){
        while (p != id[p]) p = id[p]; //找到根结点
        return p;
    }
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return ;
        id[pRoot] = qRoot;
        count--;
    }

    public int[] getId() {
        return id;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        UF uf = new UF(N);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if(uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count + "components");
        for (int i = 0; i < uf.id.length; i++) {
            System.out.println(uf.id);
        }
    }

}
