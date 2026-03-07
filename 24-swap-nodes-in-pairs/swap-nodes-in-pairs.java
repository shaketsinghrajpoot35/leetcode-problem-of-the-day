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

    public void recursion(ListNode fistNode, ListNode secondNode){

        if(fistNode == null || secondNode == null){
            return;
        }

        int temp = fistNode.val;
        fistNode.val = secondNode.val;
        secondNode.val = temp;

        //now next pairs

        fistNode = secondNode.next;
        if(fistNode == null) return;
        secondNode = fistNode.next;

        recursion(fistNode,secondNode);

    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        recursion(head,head.next);

       return head;
    }
}


// class Solution {

   
//     public ListNode swapPairs(ListNode head) {

//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode temp1 = head;
//         ListNode temp2 = head.next;

//         while(temp1 != null && temp2 != null){

//             int temp = temp1.val;
//             temp1.val = temp2.val;
//             temp2.val = temp;

//             temp1 = temp2.next;
//             if(temp1 == null){
//                 return head;
//             }
//             temp2 = temp1.next;

//         }

//         return head;
//     }
// }