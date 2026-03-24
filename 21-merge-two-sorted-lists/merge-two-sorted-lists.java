
class Solution {

    ListNode head;
    ListNode curr;

    public void mergeTwoListsHelper(ListNode list1, ListNode list2){

        if(list1 == null && list2 == null){
            return;
        }

        if(list1 == null ){
            curr.next = list2;
            return;
        }

        if(list2 == null){
            curr.next = list1;
            return;
        }

        if(list1.val < list2.val){
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
                 mergeTwoListsHelper(list1, list2);
        }
        
        else{
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
                mergeTwoListsHelper(list1, list2);
            }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        head = new ListNode(0);
        curr = head;

        mergeTwoListsHelper(list1, list2);

        return head.next;
    }
}




// class Solution {

    
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
//        ListNode dummy = new ListNode(0);

//        ListNode curr = dummy;

//        while(list1 !=null && list2 !=null){

//             if(list1.val < list2.val){
//                 curr.next = list1;
//                 curr = list1;
//                 list1 = list1.next;
//             } else{
//                 curr.next = list2;
//                 curr = list2;
//                 list2 = list2.next;
//             }
//        }

//        if(list1 == null){
//           curr.next = list2;
//        }

//        if(list2 == null){
//           curr.next = list1;
//        }

//        return dummy.next;

//     }
// }