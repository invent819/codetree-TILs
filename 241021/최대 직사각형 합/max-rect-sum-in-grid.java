import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] graph;
	static int[][] dp;
	static int[] colDp;

	public static int getSum(int x1, int y1, int x2, int y2) {
		return dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
	}

	public static int getAreaSum(int x1, int x2) {
		for (int y = 1; y <= n; y++) {
			int value = getSum(x1, y, x2, y);
			colDp[y] = Math.max(value, colDp[y - 1] + value);
		}
		int maxArea = Integer.MIN_VALUE;
		for (int y = 1; y <= n; y++) {
			maxArea = Math.max(maxArea, colDp[y]);
		}
		return maxArea;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		graph = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		colDp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + graph[i][j];
			}
		}

		int ans = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				ans = Math.max(ans, getAreaSum(i, j));
			}
		}
//		for (int i = 1; i <= n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		System.out.println(ans);
	}

}