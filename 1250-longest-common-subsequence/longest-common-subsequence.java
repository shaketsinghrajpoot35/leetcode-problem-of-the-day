class Solution {

     HashMap<String, Integer> map;

     int longestCommonSubsequenceHelper(String text1, String text2, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        String key = m + "," + n;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int result;

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            result = 1 + longestCommonSubsequenceHelper(text1, text2, m - 1, n - 1);
        } else {
            int option1 = longestCommonSubsequenceHelper(text1, text2, m, n - 1);
            int option2 = longestCommonSubsequenceHelper(text1, text2, m - 1, n);
            result = Math.max(option1, option2);
        }

        map.put(key, result);
        return result;
    }

   public int longestCommonSubsequence(String s1, String s2) {
        map = new HashMap<>();
        return longestCommonSubsequenceHelper(s1, s2, s1.length(), s2.length());
    }
}






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