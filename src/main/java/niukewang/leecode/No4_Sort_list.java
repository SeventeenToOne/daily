package niukewang.leecode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author: wxq
 * @date 2018-10-15 21:04
 **/

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
public class No4_Sort_list {
    /*
    * 此方法将链表复制到一个集合中,通过集合的排序来完成最后的结果,此方法不是最优方法.时间和空间都不是最好的
    * @author wxq
    * @date 2018-10-15
    * */
    public static ListNode sortList_1(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(head == null){
            return null;
        }
        while (head != null){
            arrayList.add(head.val);
            head = head.next;
        }
        Collections.sort(arrayList);
        ListNode q = null;
        for (Integer integer : arrayList) {
            if (q == null){
                q = new ListNode(integer);
                head = q;
            }else {
                ListNode temp = new ListNode(integer);
                q.next = temp;
                q = temp;
            }
        }
        return head;
    }

    /*
    * 使用快慢指针,以及归并排序完成在链表上的排序, 时间复杂的NlogN, 空间复杂度N
    * @author wxq
    * @date 2018-10-18
    * */
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        return mergeList(left, right);
    }

    /*
    * 通过快慢指针查找到中间值
    *
    * 找到最小的递归子问题,判断是否正确, 即两个元素的中间值,应该为前面一个,若为后面一个,会进入 死循环,
    * 归并时,右边永远为null,左边永远为两个节点
    * @author wxq
    * @date 2018-10-18
    * */
    public static ListNode findMiddle(ListNode node){
        ListNode fastNode = node;
        ListNode middleNode = node;
        if(node == null || node.next == null) {
            return node;
        }
        while (fastNode.next != null && fastNode.next.next != null){
            middleNode = middleNode.next;
            fastNode = fastNode.next.next;
        }
        return middleNode;
    }

    /*
    * 归并两个链表
    * */
    public static ListNode mergeList(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                node.next = l2;
//                node = l2;
                l2 = l2.next;
            }else {
                node.next = l1;
//                node = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if(l1 == null){
            node.next = l2;
        }
        if(l2 == null){
            node.next = l1;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head = sortList(head);
        while (head != null) {
            System.out.println(head + " ");
            head = head.next;
        }
    }
}
