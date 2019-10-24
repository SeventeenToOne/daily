package alg.sort;

/*
* 关联索引的泛型优先队列
*
* P203
* @author wxq
* @date 2018-6-7
* */
public class IndexMinPQ<Item extends Comparable<Item>> extends SortTemplate {
    // N 当前优先队列中元素的个数
    private int N = 0;
    // 0位置不放置元素 从 1...N
    private Item[] items;
    // 索引数组, itemsKey[k] = key 代表当前items中的第k位置的item 的 索引是key
    private int[] itemsKey;

    // 创建一个最大容量为maxN的优先队列， 索引的取值范围为0至maxN-1
    public IndexMinPQ(int maxN){
        items = (Item[]) new Comparable[maxN + 1];
        itemsKey = new int[maxN+1];
    }

    // 插入一个元素，将它和索引k相关联
    public void insert(int k, Item item){
        if(N >= items.length){
            // 扩容操作 或者 插入失败
            return;
        }

        items[++N] = item;
        //
        itemsKey[N] = k;
        swim(N);

    }

    // 从下到上调整顺序,并返回相应的调整后的数组下标, 将小的元素上浮
    public int swim(int k){
        // 改进条件 k > 1 &&
        while(k/2 > 0 && less(k, k/2)){
            exch(k, k/2);
            k = k/2;
        }
        return k;
    }

    // 由上到下调整
    public int sink(int k){

        // 细节
        while(k*2 <= N){
            int j = k * 2;
            if(j < N && less(j+1, j)) j++;
            if(less(k, j)) break;
            exch(j,  k);
            k = j;
        }
        return k;
    }

    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0; // 简便写法
    }

    // 修改 exch 方法, 在交换两个元素的同时,交换索引
    private void exch(int i, int j){
        Item t = items[i];
        int tKey = i;

        items[i] = items[j];
        itemsKey[i] = itemsKey[j];

        items[j] = t;
        itemsKey[j] = tKey;

    }

    // 将索引为k的元素设为item
    // 函数设置的原因
    public void change(int k, Item item){

    }

    // 是否存在索引为k的元素
    public boolean contains(int k){
        return true;
    }

    // 删去索引k及其相关联的元素
    public void delete(int k){

    }

    // 返回最小元素
    public Item min(){
        if(N >= 1){
            return items[1];
        }else {
            return null;
        }

    }

    // 返回最小元素的索引
    public int minIndex(){
        return itemsKey[1];
    }

    //删除最小的元素并返回它的索引
    public int delMin(){
        int minIntemKey = itemsKey[1];
        exch(1, N--);
        // 防止对象游离
        items[N+1] = null;
        sink(1);
        return minIntemKey;
    }

    // 优先队列是否为空
    public boolean isEmpty(){
        if(N == 0){
            return true;
        }else {
            return false;
        }
    }

    // 优先队列中的元素数量
    public int size(){
        return N;
    }
}
