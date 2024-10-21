import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] graph;
	static int[][] dp;

	public static int getSum(int x, int y) {
		int ans = Integer.MIN_VALUE;

		for (int i = x; i <= n; i++) {
			for (int j = y; j <= n; j++) {
				ans = Math.max(ans, dp[i][j] - dp[x - 1][j]);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		graph = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
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
			for (int j = 1; j <= n; j++) {
				ans = Math.max(ans, getSum(i, j));
			}

		}
//		for (int i = 1; i <= n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(ans);
	}

}