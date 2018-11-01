package com.jack.algorithm;

/**
 * create by jack 2018/11/1
 *
 * @author jack
 * @date: 2018/11/1 21:43
 * @Description:
 */
public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n ==0) {
            return head;
        }
        head = reverse(head);
        ListNode p1 = head;
        ListNode p2 = p1.next;
        int i = 1;
        if (n == 1) {
            head = head.next;
        }
        while (p1 != null && i<n) {
            i++;
            if (i == n) {
                p1.next = p2.next;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        head = reverse(head);
        return head;
    }

    /**
     * 创建链表
     * @param nums
     * @return
     */
    public static ListNode createListNode(int[] nums){
        ListNode head=null;
        ListNode p = head;
        for (int i=0;i<nums.length;i++) {
            int num = nums[i];
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                p = head;
            } else {
                p.next = node;
                p = node;
            }
        }
        return head;
    }

    /**
     * 打印链表
     * @param nodes
     */
    public static void displayListNode(ListNode nodes){
        ListNode p = nodes;
        while (p != null) {
           int num = p.val;
            System.out.print(num+"->");
           p=p.next;
        }
        System.out.println("");
    }

    /**
     * 链表反转
     * @param nodes
     * @return
     */
    public static ListNode reverse(ListNode nodes){
        ListNode head = null;
        ListNode q = nodes;
        ListNode t = null;
        while (q != null) {
            if (head == null) {
                head = q;
                q = q.next;
                head.next = null;
            } else {
                t = q;
                q=q.next;
                t.next= head;
                head = t;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        int[] nums = new int []{1,2,3,4,5};
        ListNode listNode = createListNode(nums);
        displayListNode(listNode);
        //ListNode node1 = reverse(listNode);
        ListNode head = removeNthFromEnd(listNode,2);
        displayListNode(head);
    }
}
