class Solution {

    public double myPowHelper(double x, int n) {
        
        if(n==0){
            return 1;
        }

        double half = myPowHelper( x,  n/2);
        if(n%2==0){

            return half*half;
        } else{

            return x*half*half;

        }

        
    }
    public double myPow(double x, int n) {
        
        if(n<0){
           double pow =  myPowHelper( x,  -n);
           return 1/pow;
        }


        return myPowHelper( x, n);
    }
}