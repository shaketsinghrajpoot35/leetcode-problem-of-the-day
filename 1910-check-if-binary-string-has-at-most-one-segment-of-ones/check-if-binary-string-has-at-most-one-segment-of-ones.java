class Solution {
    public boolean checkOnesSegment(String s) {
        int segments = 0;
        int pointer = 0, slen = s.length();

        while (pointer < slen) {
            if (s.charAt(pointer) == '1') {
                segments++;
                while (pointer < slen && s.charAt(pointer) == '1') {
                    pointer++;
                }
            }
            pointer++;
        }
        return segments == 1;
    }
}