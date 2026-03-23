class Solution {
    
    Map<String, Integer> map ;
    public int getRowColHelper(int row,int col){

        if(row==0 || col ==0 || row==col) return 1;

        String key = row+","+col;
            if(map.containsKey(key)){
                return map.get(key);   
            }

        int result = getRowColHelper( row-1, col) + getRowColHelper( row-1, col-1);
        map.put(key,result);

        return result;
    }
    public List<Integer> getRow(int rowIndex) {
        
        map = new HashMap<>();
      
        List<Integer> ans = new ArrayList<Integer>();

        int row = rowIndex;
        for(int col=0; col<=rowIndex; col++){

            

                int value =  getRowColHelper( row, col);
       
                ans.add(value);
            
        }

        return ans;
    }
}