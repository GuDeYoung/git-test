import com.sun.org.apache.regexp.internal.RE;

import javax.jnlp.ClipboardService;
import javax.swing.*;
import java.net.HttpRetryException;
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class test {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here

        if(m == n)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode p= newHead;
        ListNode pre = newHead;
        ListNode temp = null;

        for(int i = 0; i < m ;i++){
            pre = p;
            p = pre.next;
        }


        for(int j = 1; j <= n-m;j++){

            temp = p.next;
            p.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;

        }

        return newHead.next;

    }

//    public ListNode mergeKLists(ArrayList<ListNode> lists) {
//
//        ListNode newHead = null;
//
//        for(int i = 0; i < lists.size();i++){
//            newHead = merge(newHead, lists.get(i));
//        }
//
//        return newHead;
//
//    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        return merLists(lists,0,lists.size()-1);

    }

    public ListNode merLists(ArrayList<ListNode> lists,int left, int right) {

       if(left>right){
           return null;
       }

       if(left == right){
           return lists.get(left);
       }

       int mid  = (left+right)/2;

       return merge(merLists(lists,left,mid),merLists(lists,mid+1,right));


    }

    public ListNode merge(ListNode list1,ListNode list2){
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;



        while(list1 !=null && list2 !=null){
            if (list1.val < list2.val){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }

            else{
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }

        }

        if(list1 != null){
            p.next = list1;
        }

        if(list2 != null){
            p.next = list2;
        }

        return newHead.next;
    }

    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode low = pHead;

        if (pHead == null)
            return null;

        for (int i = 0; i < k; i++) {
            if (fast == null)
                return null;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }

        return low;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode pre = null;
        ListNode fast = head;
        ListNode low = head;

        if (head == null)
            return head;

        for (int i = 0; i < n; i++) {

            if (fast == null)
                return null;
            fast = fast.next;
        }
        if (fast == null) {
            return low.next;
        }

        while (fast != null) {
            pre = low;
            fast = fast.next;
            low = low.next;
        }

        pre.next = low.next;

        return head;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int i = 0;
        while (p1 != null) {
            i++;
            p1 = p1.next;
        }

        int j = 0;
        while (p2 != null) {
            j++;
            p2 = p2.next;
        }

        if (i > j) {
            for (int k = 0; k < i - j; k++) {
                pHead1 = pHead1.next;

            }

            while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

            return pHead1;
        } else {
            for (int k = 0; k < j - i; k++) {
                pHead2 = pHead2.next;

            }

            while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

            return pHead2;
        }

    }


    public ListNode reverse(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode temp = null;

        while (head != null) {

            temp = head.next;

            head.next = pre.next;
            pre.next = head;
            head = temp;
        }

        return pre.next;
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here

        head1 = reverse(head1);
        head2 = reverse(head2);

        System.out.println(head1);


        ListNode pre = new ListNode(-1);
        ListNode p =pre;

        pre.next = p;

        int chu = 0;

        while (head1 != null || head2 != null || chu != 0) {

            int val1= 0;
            if(head1 != null)
                val1 = head1.val;

            int val2 = 0;
            if(head2 != null)
                val2 = head2.val;

            int sum = val1 + val2 + chu;
            int yu = sum % 10;
            chu = sum / 10;

            p.next  = new ListNode(yu);
            p = p.next;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }


        }

        return reverse(pre.next);
    }

    public ListNode sortInList (ListNode head) {
        // write code here
        ListNode newhead = new ListNode(-1);
        ListNode r = newhead;
        newhead.next = head;
        ListNode p = newhead.next;
        ListNode pre = null;

        while (p != null) {

            pre =newhead;
            ListNode q =p;

            ListNode min = q;
            ListNode minPre = pre;

            while (q != null){

                if (q.val <min.val) {
                    min = q;
                    minPre = pre;
                }

                pre = q;
                q = q.next;
            }

            ListNode temp = r.next;
            r.next = min;
            minPre.next = min.next;
            min.next = temp;


        }

        return null;
    }

}