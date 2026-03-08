// class Solution {
//     public int fib(int n) {
        
//         if(n==0 || n==1) return n;

//         return fib(n-1) + fib(n-2);
//     }
// }


class Solution {

    HashMap<Integer,Integer> map;

    public int fibHelper(int n){

        //base case
        if(n == 0 || n==1){
            return n;
        }

        //already calls executed so result store in map
        if(map.containsKey(n)){
            return map.get(n);
        }

        return fibHelper(n-1) + fibHelper(n-2);

    }
    public int fib(int n) {

        map = new HashMap<Integer,Integer>();

        return fibHelper(n);
        
    }
}