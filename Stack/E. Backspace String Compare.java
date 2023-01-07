// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

//Note that after backspacing an empty text, the text will continue empty.



//Stack -O(M+N) O(M+N)

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
