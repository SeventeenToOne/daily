package alg.Find_SymbolTable;

/**
 * @program: algorithms
 * @description:测试各个查找方法的效率以及结果
 * @author: wxq
 * @date 2019-04-20 10:28
 **/
public class Example {
    public static void main(String[] args) {
//        BinarySearchST<Character, Integer> st = new BinarySearchST<>(10);
//        BST<Character, Integer> st = new BST<>();
//        RedBlackBST<Character, Integer> st = new RedBlackBST<>();
//
//        st.put('d', 1);
//        st.put('e', 1);
//        st.put('a', 2);
//        st.put('b', 1);

        RedBlackBST<Integer, Integer> st = new RedBlackBST<>();

        st.put(3, 1);
        st.put(5, 1);
        st.put(4, 2);
        st.put(9, 1);
        st.put(8, 1);
        st.put(7, 1);
        st.put(6, 2);
        st.put(10, 1);
        st.put(11, 1);
        st.put(1, 1);
        st.put(2, 2);
        st.put(15, 1);

        st.deleteMin();
        st.deleteMax();
        st.delete(4);
        System.out.println(st.get(11));

//        for (String o : st.keys()) {
//            System.out.println(st.get(o));
//        }
//        for (Character character : st.keys('a', 'd')) {
//            System.out.println(character);
//        }
    }
}
