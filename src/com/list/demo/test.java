package com.list.demo;

import org.w3c.dom.NodeList;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:test
 * @Description: TODO
 */
public class test {

    public static void main(String[] args) {

    }

    /**
     * 节点类
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 删除指定节点(单链表) ---> 【直接覆盖】
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param node
     */
    public void deleteNode(ListNode node) {

        //后继节点覆盖node
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表中的重复元素(单链表) 【单指针】
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        //有序链表直接遍历即可
        ListNode node = head;
        while(node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * 返回链表的中间节点  ----> 【快慢指针】
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head ==null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 返回链表的中间节点  ----> 【计算链表长度，然后返回从中间节点开始的序列】
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        int len = 0;
        ListNode q = head;
        while(q != null){
            len++;
            q = q.next;
        }
        int temp = 0;
        ListNode node = head;
        while(node != null){
            temp++;
            if(temp == len/2+1){
                break;
            }
            node = node.next;
        }
        return node;
    }

    /**
     * 删除链表中指定值的节点 ---> 【双指针】
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
         if(head == null){
             return null;
         }
         //要删除的是第一个节点
         while(head.val == val){
             head = head.next;
             if(head == null){
                 return null;
             }
         }
         //其他情况
         //当前指针，指向当前节点
         ListNode curNode = head.next;
         //前驱指针，指向当前节点的前驱节点
         ListNode preNode = head;
         while(curNode != null){
             if(curNode.val == val){
                 preNode.next = curNode.next;
                 curNode = curNode.next;
             }else{
                 preNode = preNode.next;
                 curNode = curNode.next;
             }
         }
         return head;
    }

    /**
     * 删除链表中指定值的节点 ---> 【递归】
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        if(head != null){
            head.next = removeElements(head.next,val);
            return head.val == val ? head.next:head;
        }
        return head;
    }

    /**
     * 反转链表 【迭代】
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        //pre:每次指向反转链表的头结点
        return pre;
    }

    /**
     * 反转链表 【递归】
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        //反转过程
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
