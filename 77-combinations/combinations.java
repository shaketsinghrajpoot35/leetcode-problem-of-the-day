// class Solution {

//     public void backtracking(int start, int n, int k, 
//                              List<List<Integer>> combinations, 
//                              List<Integer> list) {

//         // Base Case
//         if (list.size() == k) {
//             combinations.add(new ArrayList<>(list));
//             return;
//         }

//         // Loop from start to n
//         for (int i = start; i <= n; i++) {

//             list.add(i);  // choose

//             backtracking(i + 1, n, k, combinations, list);  // explore

//             list.remove(list.size() - 1);  // un-choose (backtrack)
//         }
//     }

//     public List<List<Integer>> combine(int n, int k) {

//         List<List<Integer>> combinations = new ArrayList<>();

//         backtracking(1, n, k, combinations, new ArrayList<>());

//         return combinations;
//     }
// }


class Solution {

    public void backtracking(int start, int n, int k, 
                             List<List<Integer>> combinations, 
                             List<Integer> list) {

        // Base Case
        if (list.size() == k) {
            combinations.add(new ArrayList<>(list));
            return;
        }

        // Loop from start to n
        int remaining = k - list.size();
        for (int i = start; i <= n-remaining+1; i++) {

            list.add(i);  // choose

            backtracking( i+ 1, n, k, combinations, list);  // explore

            list.remove(list.size() - 1);  // un-choose (backtrack)
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combinations = new ArrayList<>();

        backtracking(1, n, k, combinations, new ArrayList<>());

        return combinations;
    }
}