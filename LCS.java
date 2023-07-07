import java.util.Arrays;

public class LCS {
/****** Only Recursion ********/
    static int LCS(char[] a, char[] b, int i, int j){
		if(i == a.length || j == b.length){
			return 0;
		}
		
		if(a[i] == b[j]){
			return 1 + LCS(a, b, i + 1, j + 1);
		}
		int x = LCS(a, b, i + 1, j);
		int y = LCS(a, b, i, j + 1);
		return Math.max(x, y);
		
	}

	public static int lcs(String s, String t) {
		//Your code goes here
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		int ans = LCS(a, b, 0, 0);
		return ans;
    }
/***** Memoization *****/
static int LCS1(char[] a, char[] b, int i, int j, int[][] memo){
		if(i == a.length || j == b.length){
			return 0;
		}
		if(memo[i][j] != -1)	return memo[i][j];
		if(a[i] == b[j]){
			return 1 + LCS1(a, b, i + 1, j + 1, memo);
		}
		return memo[i][j] = Math.max(LCS1(a, b, i + 1, j, memo), LCS1(a, b, i, j + 1, memo));
	}

	public static int lcs1(String s, String t) {
		//Your code goes here
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		int[][] memo = new int[a.length][b.length];
		for(int i = 0; i < memo.length; i++)
			Arrays.fill(memo[i], -1);
		int ans = LCS1(a, b, 0, 0, memo);
		return ans;
    }
}
