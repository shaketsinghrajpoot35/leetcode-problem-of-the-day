

class Solution {

    public void backtracking(int row ,Set<Integer> cols,Set<Integer> diags,
                             Set<Integer> antiDiags
                            ,int n,int[]count){
        
        // Agar sabhi rows me queen place ho gayi (row == n),
        // to current board ko answer list me add kar do
        if(row == n){
            
           

            count[0]++;
            return; // yaha se function wapas chala jayega
        }

        // Current row ke liye har column check kar rahe hain
        for(int col=0; col<n;col++){

            // Agar column already kisi queen ne use kiya hai
            // to skip karo
            if(cols.contains(col)){
                continue;
            }

            // Diagonal ka formula: col - row
            int diag = col - row;

            // Agar diagonal already occupied hai
            // to skip karo
            if(diags.contains(diag)){
                continue;
            }

            // Anti-diagonal ka formula: col + row
            int antiDiag = col + row;

            // Agar anti-diagonal already occupied hai
            // to skip karo
            if(antiDiags.contains(antiDiag)){
                continue;
            }

            // Matlab column, diagonal, antiDiagonal safe hai
            // to yaha queen place kar sakte hain

        
            // Column aur diagonals ko mark kar diya occupied
            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);

            // Next row ke liye recursive call
            backtracking(row+1,cols,diags,antiDiags,n,count);

            // Backtracking step:
            // Agar aage solution nahi mila to queen hata do

         

            // Column aur diagonals ko free kar diya
            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);
        }
    }


    public int totalNQueens(int n) {
        
        // // Final answers store karne ke liye list of list banayi
        // List<List<String>> boards = new ArrayList<List<String>>();

        // Columns track karne ke liye set
        Set<Integer> cols = new HashSet<>();

        // Main diagonals track karne ke liye set
        Set<Integer> diags = new HashSet<>();

        // Anti-diagonals track karne ke liye set
        Set<Integer> antiDiags = new HashSet<>();

        // Chess board ko 2D char array me represent kar rahe hain
        // char game[][] = new char[n][n];

        // // Initially sab jagah '.' fill kar diya (empty space)
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         game[i][j] = '.';
        //     }
        // }

        // Backtracking start kar rahe hain row 0 se
        
        int count[] = {0};
        backtracking(0,cols,diags,antiDiags,n,count);

        // Final result return kar diya
        return count[0];
    }
}