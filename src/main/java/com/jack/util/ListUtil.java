package com.jack.util;

import com.jack.algorithm.MergeTwoSortedLists;
import com.jack.entity.ListNode;

/**
 * create by jack 2018/11/4
 *
 * @author jack
 * @date: 2018/11/4 11:56
 * @Description:
 */
public class ListUtil {
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

}
