package cn.edu.cqvie.leetcode;

public class Solution2 {
//2. 两数相加
//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//    示例：
//    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出：7 -> 0 -> 8
//    原因：342 + 465 = 807

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = solution1.addTwoNumbers(l1, l2);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int t = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(t % 10);
            current = current.next;
            t = t / 10;
        }
        return result.next;
    }

}

class ListNode {
    int val;
    ListNode next;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

