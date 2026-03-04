class Solution {


    public boolean backtrack(char[][] board, List<HashSet<Character>> rows, List<HashSet<Character>> cols, List<HashSet<Character>> boxes){

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board.length;j++){
                
                char cell = board[i][j];
                if(cell == '.'){
                    continue;
                }

                if(rows.get(i).contains(cell)){
                    return false;
                }

                if(cols.get(j).contains(cell)){
                    return false;
                }

                int boxIndex = 3 * (i/3)+(j/3);
                if(boxes.get(boxIndex).contains(cell)){
                    return false;
                }

                rows.get(i).add(cell);
                cols.get(j).add(cell);
                boxes.get(boxIndex).add(cell);
            }
        }

        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        
        List<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
        List<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
        List<HashSet<Character>> boxes = new ArrayList<HashSet<Character>>();

        for(int i=0;i<board.length;i++){

            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());

        }

        return backtrack(board, rows, cols, boxes);

    }
}