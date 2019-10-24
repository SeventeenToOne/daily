package niukewang.leecode;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 *
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 * @author: wxq
 * @date 2018-10-24 21:21
 **/


class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class No12_copyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        RandomListNode copy, p;
        for (p = head; p != null; p = p.next) {
            copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy;
        }

        for (p = head; p != null; p = copy.next){
            copy = p.next;
            copy.random = p.random != null ? p.random.next : null;
        }

        for (p = head, head = copy = p.next; p != null; ){
            p.next = copy.next;
            p = p.next;
            copy.next = p != null ? p.next: null;
            copy = copy.next;
        }

        return head;
    }
}
