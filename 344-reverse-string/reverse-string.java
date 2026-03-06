// class Solution {
//     public void reverseString(char[] s) {
//         int i=0;
//         int j= s.length-1;
//         while(i<=j){
//             char temp = s[i];
//             s[i] = s[j];
//             s[j] = temp;
//             i++;
//             j--;
//         }
//     }
// }

class Solution {

   

    public void recurstion(char[] s,int i, int j){

        if(i>j){
            return;
        }

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        recurstion(s,i+1,j-1);
        


    }
    public void reverseString(char[] s) {

       
        recurstion(s,0,s.length-1);
    }
}