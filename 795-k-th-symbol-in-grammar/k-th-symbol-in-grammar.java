class Solution {

    public int kthGrammarHelper(int n, int k,int numOfFlip) {
        
        if(n==1){
            return numOfFlip%2==0 ? 0 : 1;
        }

        if(k%2==0){
            numOfFlip++;
            return  kthGrammarHelper( n-1, k/2,numOfFlip);
        }

        return kthGrammarHelper( n-1, (k+1)/2,numOfFlip);
    }
    public int kthGrammar(int n, int k) {
        return kthGrammarHelper( n, k,0);
    }
}