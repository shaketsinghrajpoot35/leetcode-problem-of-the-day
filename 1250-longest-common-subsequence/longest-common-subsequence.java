
class Solution {


   public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int [][]t = new int[m+1][n+1];

        //initialization of t[][] if row or col is 0 so it value is 0
        for(int i=0;i<m+1;i++){
            t[i][0] = 0;
        }

        for(int j=0;j<n+1;j++){
            t[0][j] = 0;
        }
        
        for(int i=1;i<m+1;i++){
            
            for(int j=1;j<n+1;j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                     t[i][j]  = 1 + t[i-1][j-1];
                } else{

                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }

        return t[m][n];
    }
}


// class Solution {

//     int t[][] ;

//     int longestCommonSubsequenceHelper(String text1, String text2, int m, int n) {

//         if (m == 0 || n == 0) {
//             return 0;
//         }

      

//         if (t[m][n] != -1) {
//             return t[m][n];
//         }

//         int result;

//         if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
//             result = 1 + longestCommonSubsequenceHelper(text1, text2, m - 1, n - 1);
//         } else {
//             int option1 = longestCommonSubsequenceHelper(text1, text2, m, n - 1);
//             int option2 = longestCommonSubsequenceHelper(text1, text2, m - 1, n);
//             result = Math.max(option1, option2);
//         }

//         t[m][n] = result ;
//         return result;
//     }

//    public int longestCommonSubsequence(String s1, String s2) {
//         int m = s1.length();
//         int n = s2.length();
//         t = new int[m+1][n+1];
//         for(int i=0;i<m+1;i++){
            
//             for(int j=0;j<n+1;j++){
                
//                 t[i][j] = -1;
//             }
//         }
//         return longestCommonSubsequenceHelper(s1, s2, m, n);
//     }
// }






// class Solution {

//      HashMap<String, Integer> map;

//      int longestCommonSubsequenceHelper(String text1, String text2, int m, int n) {

//         if (m == 0 || n == 0) {
//             return 0;
//         }

//         String key = m + "," + n;

//         if (map.containsKey(key)) {
//             return map.get(key);
//         }

//         int result;

//         if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
//             result = 1 + longestCommonSubsequenceHelper(text1, text2, m - 1, n - 1);
//         } else {
//             int option1 = longestCommonSubsequenceHelper(text1, text2, m, n - 1);
//             int option2 = longestCommonSubsequenceHelper(text1, text2, m - 1, n);
//             result = Math.max(option1, option2);
//         }

//         map.put(key, result);
//         return result;
//     }

//    public int longestCommonSubsequence(String s1, String s2) {
//         map = new HashMap<>();
//         return longestCommonSubsequenceHelper(s1, s2, s1.length(), s2.length());
//     }
// }






// class Solution {

//     public int longestCommonSubsequenceHelper(String text1, String text2,int m,int n) {
        
//         if(m==0 || n==0) {
//             return 0;
//         }

//         if(text1.charAt(m-1) == text2.charAt(n-1)){

//            return  1 + longestCommonSubsequenceHelper( text1,  text2, m-1, n-1) ;
//         } 
        
//         else{

//             int text1MInclude = longestCommonSubsequenceHelper( text1,  text2, m, n-1);
//             int text2NInclude = longestCommonSubsequenceHelper( text1,  text2, m-1, n);
//             return Math.max(text1MInclude, text2NInclude);
//         }
        
//     }

//     public int longestCommonSubsequence(String text1, String text2) {
        

//         return longestCommonSubsequenceHelper( text1,  text2, text1.length(), text2.length());
//     }
// }