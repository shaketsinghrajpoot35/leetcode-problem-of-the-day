class Solution {
    public void reverseString(char[] s) {
        int start=0;
        int end= s.length-1;
        while(start<=end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

// class Solution {

   

//     public void recurstion(char[] s,int i, int j){

//         if(i>=j){
//             return;
//         }

//         char temp = s[i];
//         s[i] = s[j];
//         s[j] = temp;

//         recurstion(s,i+1,j-1);
        


//     }
//     public void reverseString(char[] s) {

       
//         recurstion(s,0,s.length-1);
//     }
// }

