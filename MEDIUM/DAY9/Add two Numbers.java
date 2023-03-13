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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry=0;

        ListNode dummy=new ListNode(-1);
        ListNode dummyp=dummy;

        while(l1!=null && l2!=null)
        {
            int sum=l1.val+l2.val+carry;
            if(sum>=10)
            {
                carry=1;
                sum=sum%10;
            }else carry=0;


            ListNode s=new ListNode(sum);
            dummyp.next=s;
            dummyp=dummyp.next;
            l1=l1.next;
            l2=l2.next;

        }

        while(l1!=null)
        {
            int sum=l1.val+carry;
            if(sum>=10)
            {
                carry=1;
                sum=sum%10;
            }else carry=0;


            ListNode s=new ListNode(sum);
            dummyp.next=s;
            dummyp=dummyp.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int sum=l2.val+carry;
            if(sum>=10)
            {
                carry=1;
                sum=sum%10;
            }else carry=0;

            ListNode s=new ListNode(sum);
            dummyp.next=s;
            dummyp=dummyp.next;
            l2=l2.next;
        }

        if(carry==1)
        {
            ListNode s=new ListNode(carry);
            dummyp.next=s;
            dummyp=dummyp.next;
        }

        return dummy.next;
        
    }
}
