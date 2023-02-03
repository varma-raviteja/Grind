//TC: O(n)
//SC: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //base case
        if(head == null){
            return head;
        }
        
        int count = 0;
        ListNode dummy = new ListNode(-1);
        //Adding a dummy node befor the head, gives us the ease to write to code
        //without having to handle seperately the case where we have to delete
        //head node or even if there is only one node in the list
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;//ahead of slow, and heance the name
        
        //We move the fast pointer until the count is <= n
        while(count <= n){
            count++;
            fast = fast.next;
        }
        //Then we move slow and fast at 1x speed, until fast is null
        //This places the slow at (n-1)th position form end
        //As we want to remove nth node, we reset links and we remove
        //the nth node
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //Reset the links and remove nth node
        slow.next = slow.next.next;
        //As head is at dummy.next, we return that
        return dummy.next;
    }
}
