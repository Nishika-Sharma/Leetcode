class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode temp = head;
        while (temp !=null) {
            len++;
            temp = temp.next;
        }
        int baseSize = len/k;
        int extraNodes = len % k;

        ListNode current = head;
        for (int i = 0; i < k; i++) {
            ans[i] = current;
            int partSize = baseSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;

            for (int j = 1; j < partSize && current != null; j++) {
                current = current.next;
            }
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }
        return ans;
    }
}