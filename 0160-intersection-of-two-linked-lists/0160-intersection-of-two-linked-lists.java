public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            if(a == null && b == null) return null;
            else if(a == null) a = headB;
            else if(b == null) b = headA;
            else{a = a.next; b = b.next;}
        }
        return a;
    }
}