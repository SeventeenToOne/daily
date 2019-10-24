package niukewang.leecode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-10-17 21:20
 **/
public class No9_DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        ListNode slowPoint = head, fastPoint = head;
        if(head == null){
            return null;
        }
        while (fastPoint != null && fastPoint.next != null){
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
            if(slowPoint == fastPoint){
                break;
            }

        }
       if(fastPoint == null || fastPoint.next == null){
            return null;
       }
//        2*(a + b) = a + b + n * (b + c)；即
//        a=(n - 1) * b + n * c = (n - 1)(b + c) +c;
        slowPoint = head;
        while (slowPoint != fastPoint){
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next;
        }
        return slowPoint;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode cycle = new ListNode(4);
        head.next.next = cycle;
        cycle.next = head;
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        System.out.println(detectCycle(head));
//        while (head != null) {
//            System.out.println(head + " ");
//            head = head.next;
//        }
    }
}
