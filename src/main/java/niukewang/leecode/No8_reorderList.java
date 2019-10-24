package niukewang.leecode;

import java.util.ArrayList;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 *
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * @author: wxq
 * @date 2018-10-16 21:43
 **/
public class No8_reorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return ;
        }
        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode p = head , q;
        while (p != null){
            ListNode t = p;
            arrayList.add(t);
            p = p.next;
        }
        p = head;
        q = arrayList.remove(arrayList.size() - 1);
//        System.out.println("size" + arrayList.size());
        int i = 0;
        while (i < (arrayList.size())){
            q.next = p.next;
            p.next = q;
            if(p.next.next == null){
                break;
            }
            p = p.next.next;
            q = arrayList.remove(arrayList.size() - 1);
            i++;
//            System.out.println("size" + arrayList.size() + " i" + i);
        }
        p.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        reorderList(head);
        while (head != null) {
            System.out.println(head + " ");
            head = head.next;
        }
    }
}
