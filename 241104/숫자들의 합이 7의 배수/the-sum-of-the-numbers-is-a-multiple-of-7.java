import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static int MAX_N = 100000;
	public static int[] arr = new int[MAX_N];
	public static int[] L = new int[MAX_N];
	public static int[] R = new int[MAX_N];
	public static int ans = 0;
	static int r, c;
	static int[][] graph;

	static StringBuilder sb = new StringBuilder();
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[] dp;
//
//	static void getMaxSum(int idx, int cnt, int targetCnt, int sum) {
//
//		if (cnt == targetCnt) {
//			if (sum % 7 == 0) {
//				ans = Math.max(ans, sum);
//			}
//			return;
//		}
//
//		for (int i = 0; i < n; i++) {
//			getMaxSum(idx+1, cnt+1, targetCnt, sum + )
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + arr[i];
		}

//		System.out.println(Arrays.toString(dp));
		ans = 0;
//		for (int i = 1; i <= n; i++) {
//			getMaxSum(0, 0, i, 0);
//		}

		int len = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				int sum = dp[j + i] - dp[j];
				if (sum % 7 == 0) {
					len = Math.max(i, len);
					continue;
				}
			}
		}

		System.out.println(len);
	}
}