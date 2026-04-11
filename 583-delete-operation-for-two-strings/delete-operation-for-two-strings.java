class Solution {

    public int lcs(String s1, String s2, int m , int n){
        
        int t[][] = new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            t[i][0] =0;
        }
        
        for(int j=0;j<n+1;j++){
            t[0][j] =0;
        }
        
        for(int i=1;i<m+1;i++){
            
            for(int j=1; j<n+1;j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    
                    t[i][j] = 1 +t[i-1][j-1];
                } else{
                    
                    t[i][j]  =Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[m][n];
    }


    public int minDistance(String word1, String word2) {
        
        int lcsLeng =  lcs(word1, word2, word1.length(), word2.length());

        //           word1 = "sea", word2 = "eat"
        //lcs="ea"            -ea            ea- 
        //apart form lcs become deletion character 

        int deletionFromWord1 = word1.length() - lcsLeng;
        int deletionFromWord2 = word2.length() - lcsLeng;
        int totalDeletionFromBoth = deletionFromWord1 + deletionFromWord2 ;

        return totalDeletionFromBoth;
    }
}