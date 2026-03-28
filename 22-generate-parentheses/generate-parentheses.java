// class Solution {

//     public boolean isValidParenthesis(String s){

//         int c = 0;
//         for(char ch : s.toCharArray()){

//             if(ch =='('){
//                 c++;
//             }

//             else if(ch == ')'){
//                 c--;
//             }

//             if(c<0){
//                 return false;
//             }
//         }

//         return c==0;
//     }

//     public void generateParenthesisHelper(int n, String s, List<String> ans){

//         if(s.length()==2*n){

//             if(isValidParenthesis(s)){
//                 ans.add(s);
//             }

//             return;
//         }

//         generateParenthesisHelper(n, s+"(", ans);
//         generateParenthesisHelper(n, s+")", ans);


//     }
//     public List<String> generateParenthesis(int n) {
        
//         List<String> ans = new ArrayList<>();
//         generateParenthesisHelper(n,"", ans);

//         return ans;
//     }
// }



class Solution {

    public boolean isValidParenthesis(String s){

        int c = 0;
        for(char ch : s.toCharArray()){

            if(ch =='('){
                c++;
            }

            else if(ch == ')'){
                c--;
            }

            if(c<0){
                return false;
            }
        }

        return c==0;
    }

    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        
        Queue<String> q = new LinkedList<>();
        q.add("");

        while(!q.isEmpty()){

            String curr = q.remove();
            if(curr.length() == 2*n){

                if(isValidParenthesis(curr)){
                    ans.add(curr);
                }

                continue;
            }

            q.add(curr+"(");
            q.add(curr+")");
        }

        return ans;
    }
}