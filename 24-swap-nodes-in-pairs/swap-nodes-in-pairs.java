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
// class Solution {

//     public void recursion(ListNode head){

//         if(head == null || head.next == null){
//             return;
//         }

//         recursion(head.next);


//         //swap valus
//         int temp = head.val;
//         head.val = head.next.val;
//         head.next.val = temp;

//     }
//     public ListNode swapPairs(ListNode head) {
        
//        recursion( head);

//        return head;
//     }
// }


class Solution {

   
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;

        while(temp1 != null && temp2 != null){

            int temp = temp1.val;
            temp1.val = temp2.val;
            temp2.val = temp;

            temp1 = temp2.next;
            if(temp1 == null){
                return head;
            }
            temp2 = temp1.next;

        }

        return head;
    }
}