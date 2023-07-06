public class LPS {
    /******** Excluding manacher's algorithm *********/

    /********** Second best solution (best for interview) O(n^2) O(1) ********/
    public static int expand(String str, int left, int right) {
        int n = str.length();
        while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalinSubstring(String str) {
        // Write your code here.
        int n = str.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expand(str, i, i);
            int len2 = expand(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        String ans = str.substring(start, end + 1);
        return ans;
    }

    /*********** DP O(n^2) O(n^2) ***********/

    public static String longestPalindrome(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int start = 0;

        // Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for palindromes of length 2 or more
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    // If the characters at i and j are equal,
                    // it's a palindrome if the substring inside them is also a palindrome.
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        if (len > maxLength) {
                            maxLength = len;
                            start = i;
                        }
                    }
                }
            }
        }
        return str.substring(start, start + maxLength);
    }

    /*********** Brute Force ***********/

    public static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalinSubstring1(String str) {
        int n = str.length();
        String longestPalindrome = "";
        int maxLength = 0;

        for (int i = 0; i < n - maxLength; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(str, i, j)) {
                    int currentLength = j - i + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        longestPalindrome = str.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPalindrome;
    }
}
