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

    ListNode prev;

    public ListNode recursionReverseList(ListNode prev, ListNode curr){

        if(curr == null){
            return prev;
        }

        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;

        return recursionReverseList( prev,curr);


    }

    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        return recursionReverseList(prev, head);

       
    }
}

// class Solution {
//     public ListNode reverseList(ListNode head) {
        
//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode prev = null;

//         while(head != null ){

//             ListNode temp = head.next;
//             head.next = prev;
//             prev = head;
//             head = temp;
//         }

      

//         return prev;
//     }
// }