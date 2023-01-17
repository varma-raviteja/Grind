class Solution2 {

    public String longestPalindrome(String s) {
        int best = 0;
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                ++i;
            }

            int right = i + 1;
            while (
                left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)
            ) {
                --left;
                ++right;
            }

            if (right - left > best) {
                best = right - left;
                start = left + 1;
                end = right;
            }
        }

        return s.substring(start, end);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
