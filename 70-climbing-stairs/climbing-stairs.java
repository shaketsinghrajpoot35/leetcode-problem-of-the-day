class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairsHelper(int n) {


        if(map.containsKey(n) ) {
            return map.get(n);
        }

        if(n==0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        int sub_problem_res = climbStairsHelper( n-1) + climbStairsHelper(n-2);
        map.put(n,sub_problem_res);

        return map.get(n);
    }

    public int climbStairs(int n) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        climbStairsHelper(n);

        return climbStairsHelper(n);
    }
}