import java.util.*;

class Solution {
    

    public void backtrack(int []nums,List<Integer> list, List<List<Integer>> result){

        //base case 
        if(list.size() == nums.length){

            result.add(new ArrayList<>(list));
            return;
        }

        //choice

        for(int i=0;i<nums.length;i++){

            if(!list.contains(nums[i])){
                list.add(nums[i]);
                backtrack(nums, list, result);
                //backtracking
                list.remove(list.size()-1);
            }

            
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, list, result);
        return result;
    }
    
    
}
