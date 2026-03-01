class Solution {

    public void backtracking(int row ,Set<Integer> cols,Set<Integer> diags,Set<Integer> antiDiags, List<List<String>> boards,int n,char game[][]){
        
        //compltete all row so store ans in boards
        if(row == n){
            
            List<String> board = new ArrayList<>();

            for(char[] r : game){
                board.add(new String(r));
            }
            
            boards.add(board);

            return;
        }

        for(int col=0; col<n;col++){

            if(cols.contains(col)){
                continue;
            }

            int diag = col - row;
            if(diags.contains(diag)){
                continue;
            }

            int antiDiag = col + row;
            if(antiDiags.contains(antiDiag)){
                continue;
            }

            //mean not contains col diag and antiDiag so we can use as a quen

            game[row][col] = 'Q';

            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);

            backtracking(row+1,cols,diags,antiDiags,boards,n,game);

            //if not space to put q so backtrack

            game[row][col] = '.';

            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);
        }
    }


    public List<List<String>> solveNQueens(int n) {
        
        //for store ans in list in list form
        List<List<String>> boards = new ArrayList<List<String>>();

        //store use cols 
        Set<Integer> cols = new HashSet<>();

        //store use diag 
        Set<Integer> diags = new HashSet<>();

        //store use antiDiag 
        Set<Integer> antiDiags = new HashSet<>();

        
        char game[][] = new char[n][n];

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                game[i][j] = '.';
            }
        }

        backtracking(0,cols,diags,antiDiags,boards,n,game);

        return boards;
    }
}