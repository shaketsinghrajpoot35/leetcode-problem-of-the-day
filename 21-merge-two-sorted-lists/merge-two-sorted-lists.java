// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {

//     ListNode head;
//     ListNode prev;

//     public void mergeTwoListsHelper(ListNode list1, ListNode list2){

//         if(list1 == null && list2 == null && prev != null){
//             prev.next = null;
//             return;
//         }

//         if(list1 == null && prev != null){
//             prev.next = list2;
//             return;
//         }

//         if(list2 == null && prev != null){
//             prev.next = list1;
//             return;
//         }

//         if(list1.val < list2.val){

//             if(prev==null){
//                 head =list1;
//                 prev = list1;

//             } else{
//                 prev.next = list1;
//                 prev = list1;
//             }

//             list1 = list1.next;

//             mergeTwoListsHelper(list1, list2);

//         } else{

//              if(prev==null){
//                 head =prev=list2;
              

//             } else{
//                 prev.next = list2;
//                 prev = list2;
//             }

//             list2 = list2.next;

//             mergeTwoListsHelper(list1, list2);
//         }
//     }

//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         head = null;
//         prev = null;

//         mergeTwoListsHelper(list1, list2);

//         return head;
//     }
// }



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

    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
       ListNode dummy = new ListNode(0);

       ListNode curr = dummy;

       while(list1 !=null && list2 !=null){

            if(list1.val < list2.val){
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            } else{
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }
       }

       if(list1 == null){
          curr.next = list2;
       }

       if(list2 == null){
          curr.next = list1;
       }

       return dummy.next;

    }
}