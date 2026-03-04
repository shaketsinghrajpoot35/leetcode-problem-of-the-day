class Solution {

    boolean isSudokuSolve = false;

    public void backtrack(int row, int col, int n, char[][]board,List<HashSet<Character>> rows,List<HashSet<Character>> cols,List<HashSet<Character>> boxes){

        if(board[row][col] != '.'){
           
           if(row == n-1 && col == n-1){
                isSudokuSolve = true;
            } 

            else{

                if(col == n-1){
                        backtrack(row+1,0,n,board, rows, cols, boxes);
                    } 
                else if(col != n-1){
                        backtrack(row,col+1,n,board, rows, cols, boxes);
                    }
            }
        } 


        //board[row][col] == '.' hai to right cell find karna hai abh
        else{
             
            //choice 

            for(int d = 1; d<=9;d++){

                char cellValue = (char) (d + '0') ;
                if(rows.get(row).contains(cellValue)){
                    continue;
                }

                if(cols.get(col).contains(cellValue)){
                    continue;
                }

                int boxIndex = 3 * (row/3) + (col / 3) ;

                if(boxes.get(boxIndex).contains(cellValue)){
                    continue;
                }

                //mean we find right row , col and box so we can fil the box
              
                board[row][col] = cellValue ;
                rows.get(row).add(cellValue);
                cols.get(col).add(cellValue);
                boxes.get(boxIndex).add(cellValue);

                if(row == n-1 && col == n-1){
                    isSudokuSolve = true;
                } 

                else{

                    if(col == n-1){
                        backtrack(row+1,0,n,board, rows, cols, boxes);
                    } 
                    else if(col != n-1){
                        backtrack(row,col+1,n,board, rows, cols, boxes);
                    }
                }
                

                if(!isSudokuSolve ){

                    board[row][col] = '.' ;
                    rows.get(row).remove(cellValue);
                    cols.get(col).remove(cellValue);
                    boxes.get(boxIndex).remove(cellValue);

                }

            }
        }

    }

    public void solveSudoku(char[][] board) {

        isSudokuSolve = false;
        List<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
        List<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
        List<HashSet<Character>> boxes = new ArrayList<HashSet<Character>>();

        int n = board.length;

        for (int i = 0; i < n; i++) {

            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            boxes.add(new HashSet<Character>());
        }

        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {

                char cell = board[r][c];
                if (cell != '.') {

                    rows.get(r).add(cell);
                    cols.get(c).add(cell);

                    int boxIndex = 3 * (r / 3) + (c / 3);
                    boxes.get(boxIndex).add(cell);
                }
            }
        }

        backtrack(0, 0, n, board, rows, cols, boxes);
    }
}
