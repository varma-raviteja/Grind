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


// Iterative
class Solution {  -O(n) O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode x=new ListNode(-1);
        ListNode xp=x;
        
        if(list1==null&&list2==null)
            return null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                xp.next=list1;
                list1=list1.next;
            }
            else
            {
                xp.next=list2;
                list2=list2.next;
            }
            xp=xp.next;
        }
        while(list1!=null)  // Adds to the solution list if list2's iteration is over
        {
            xp.next=list1;
            xp=xp.next;
            list1=list1.next;
        }
        while(list2!=null)
        {
            xp.next=list2;
            xp=xp.next;
            list2=list2.next;
        }
        return x.next;
    }
    
}

// Recursive

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)
            return null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        
        ListNode res=new ListNode(-1);
        compute(res,list1,list2);
        return res.next;
    }
    
    public static void compute(ListNode res,ListNode list1, ListNode list2)
    {
        if(list1==null && list2==null)
            return ;
        if(list1==null)
        {
            res.next=list2;
            return;
        }
         if(list2==null)
        {
            res.next=list1;
            return;
        }  
        
        if(list1!=null && list2!=null)
        {
            if(list1.val>=list2.val)
            {
                res.next=list2;
                list2=list2.next;
            }
            else
            {
                res.next=list1;
                list1=list1.next;
            }
            res=res.next;
            compute(res,list1,list2);
        }
        
        return;
    }
}
