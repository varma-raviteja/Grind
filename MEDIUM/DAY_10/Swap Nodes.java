/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res=new ListNode(-1);
        ListNode p=res;
        res.next=head;
        while(head!=null && head.next!=null)
        {
           ListNode temp=head.next;
            if(temp.next==null)
                head.next=null;
            else
                head.next=temp.next;
            temp.next=head;
            p.next=temp;
            p=p.next.next;
            head=head.next;
        }
        return res.next;
    }
}
