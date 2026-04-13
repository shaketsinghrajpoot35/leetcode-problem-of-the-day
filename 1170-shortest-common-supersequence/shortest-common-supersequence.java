


// class Solution {

//     public int[][] lcs(String s1, String s2, int m,int  n){
        
//         int t[][] = new int[m+1][n+1];
        
        
//         //initialization
//         for(int i=0;i<m+1;i++){
            
//             t[i][0] = 0;
//         }
//         for(int j=0; j<n+1;j++){
            
//             t[0][j] = 0;
//         }
        
//         for(int i=1;i<m+1;i++){
            
//             for(int j=1; j<n+1;j++){
                
//                 if(s1.charAt(i-1)==s2.charAt(j-1)){
                    
//                     t[i][j] = 1 + t[i-1][j-1];
//                 } else{
                    
//                     t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
//                 }
//             }
//         }
        
//         return t;
        
        
//     }

//     public String pringSCS(String s1, String s2){

//         int m = s1.length();
//         int n = s2.length();
//         int t[][] = lcs( s1,  s2, m,  n);

//         int i = m;
//         int j = n;

//         StringBuilder sb = new StringBuilder();

//         while(i !=0 && j !=0){
            
//             if(s1.charAt(i-1) == s2.charAt(j-1) ){

//                 sb.append(s1.charAt(i-1));
//                 i--;
//                 j--;

//             } else{

//                 if(t[i][j-1]>t[i-1][j]){

//                     sb.append(s1.charAt(i-1));
//                     i--;
//                 }else{
//                     sb.append(s2.charAt(j-1));
//                 }
//             }
//         }

//         while(i>0){
//              sb.append(s1.charAt(i-1));
//              i--;
//         }

//         while(j>0){
//              sb.append(s2.charAt(j-1));
//              j--;
//         }

//         return sb.reverse().toString();

//     }


//     public String shortestCommonSupersequence(String str1, String str2) {
        
//         return pringSCS(str1, str2);
//     }
// }



class Solution {

    public String printSCS(String s1, String s2, int m,int  n){
        
        int t[][] = new int[m+1][n+1];
        
        
        //initialization
        for(int i=0;i<m+1;i++){
            
            t[i][0] = 0;
        }
        for(int j=0; j<n+1;j++){
            
            t[0][j] = 0;
        }
        
        for(int i=1;i<m+1;i++){
            
            for(int j=1; j<n+1;j++){
                
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    
                    t[i][j] = 1 + t[i-1][j-1];
                } else{
                    
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int i = m;
        int j = n;

        StringBuilder sb = new StringBuilder();

        while(i !=0 && j !=0){
            
            if(s1.charAt(i-1) == s2.charAt(j-1) ){

                sb.append(s1.charAt(i-1));
                i--;
                j--;

            } else{

                if(t[i-1][j]>t[i][j-1]){

                    sb.append(s1.charAt(i-1));
                    i--;
                }else{
                    sb.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        while(i>0){
             sb.append(s1.charAt(i-1));
             i--;
        }

        while(j>0){
             sb.append(s2.charAt(j-1));
             j--;
        }

        return sb.reverse().toString();
        
        
    }

    // public String pringSCS(String s1, String s2){

    //     int m = s1.length();
    //     int n = s2.length();
    //     int t[][] = lcs( s1,  s2, m,  n);

    //     int i = m;
    //     int j = n;

    //     StringBuilder sb = new StringBuilder();

    //     while(i !=0 && j !=0){
            
    //         if(s1.charAt(i-1) == s2.charAt(j-1) ){

    //             sb.append(s1.charAt(i-1));
    //             i--;
    //             j--;

    //         } else{

    //             if(t[i][j-1]>t[i-1][j]){

    //                 sb.append(s1.charAt(i-1));
    //                 i--;
    //             }else{
    //                 sb.append(s2.charAt(j-1));
    //             }
    //         }
    //     }

    //     while(i>0){
    //          sb.append(s1.charAt(i-1));
    //          i--;
    //     }

    //     while(j>0){
    //          sb.append(s2.charAt(j-1));
    //          j--;
    //     }

    //     return sb.reverse().toString();

    // }


    public String shortestCommonSupersequence(String s1, String s2) {
        
        return printSCS( s1,  s2, s1.length(),s2.length());
    }
}