package niukewang.leecode;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 * Sort a linked list using insertion sort.
 *
 * @author: wxq
 * @date 2018-10-16 20:38
 **/

public class No5_insertionSortList {
    public static  ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head, q = head.next;
        while (p.next != null){
            ListNode t = head, front = null;
            if(p.val > q.val){
                while (t.val < q.val){
                    front = t;
                    t = t.next;
                }
                if(front == null){
                    p.next = q.next;
                    q.next = t;
                    head = q;
                    q = p.next;
                }else {
                    p.next = q.next;
                    q.next = t;
                    front.next = q;
                    q = p.next;
                }
            }else {
                p = p.next;
                q = p.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(4);
        head = insertionSortList(head);
        while (head != null) {
            System.out.println(head + " ");
            head = head.next;
        }
    }
}
