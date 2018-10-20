package com.jack.algorithm;

/**
 * create by jack 2018/8/8
 *
 * @auther jack
 * @date: 2018/8/8 22:32
 * @Description:
 */
public class AddTwoNum {
    //题目描述：https://leetcode-cn.com/problems/add-two-numbers/description/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,p=null;
        ListNode p1 =l1;
        ListNode p2 =l2;
        int b = 0;
        int sum = 0;
        while (p1 != null || p2 != null || b>0) {
            int num1 =0;
            int num2 =0;
            sum = 0;
            if (p1 != null && p2 !=null) {
                num1= p1.val;
                p1 = p1.next;
                num2= p2.val;
                p2 = p2.next;
            } else if (p1 != null && p2 == null) {
                num1= p1.val;
                p1 = p1.next;
            }else if (p1 == null && p2 != null) {
                num1= p2.val;
                p2 = p2.next;
            }
            sum = (num1+num2+b)%10;
            b = (num1+num2+b)/10;
            if (head == null) {
                head = new ListNode(sum);
                p = head;
            }else {
                ListNode node = new ListNode(sum);
                node.next = null;
                p.next = node;
                p = p.next;
            }
        }
        return head;
    }

    /**
     * 链表
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



    /**
     * 根据整数创建链表
     * @param num
     * @return
     */
    public static ListNode createListNode(int num){
        String s1 = String.valueOf(num);
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        int length = s2.length();
        ListNode p = null;
        ListNode head = null;
        for (int i=0;i<length;i++) {
            int n = Integer.valueOf("" + s2.charAt(i));
            if (head == null) {
                head = new ListNode(n);
                p = head;
            } else {
                ListNode node = new ListNode(n);
                p.next = node;
                p=p.next;
            }
        }
        return head;
    }

    /**
     * 打印链表
     * @param node
     */
    public static void  displayListNode(ListNode node){
        if (node == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        ListNode p = node;

        while (p != null) {
            int num = p.val;
            sb.append(num);
            p = p.next;
        }
        System.out.println(sb.toString());

    }


    public static void main(String[] args) {
        //243,564
        //ListNode list1 = createListNode(342);
        ListNode list1 = createListNode(1);
        //ListNode list2 = createListNode(465);
        ListNode list2 = createListNode(99);
        ListNode list3 = addTwoNumbers(list1,list2);
        displayListNode(list3);
    }
}
