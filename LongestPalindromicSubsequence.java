
public class LongestPalindromicSubsequence {

    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        // Create a DP table to store results of subproblems
        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the DP table in bottom-up manner
        for (int len = 2; len <= n; len++) { // len is the length of the substring
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1; // End index of the substring
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2; // when the substring is of length 2
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The longest palindromic subsequence length is at dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println("Length of longest palindromic subsequence: " + longestPalindromicSubsequence(s));
    }
}
