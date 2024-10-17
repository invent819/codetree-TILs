import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static char[][] graph;
	static int ans = 0;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				dp[0] = arr[0];
			} else {
				dp[i] = arr[i] + dp[i - 1];
			}
		}
//		System.out.println(Arrays.toString(dp));
		int max = Integer.MIN_VALUE;
		for (int i = k; i < n; i++) {
			max = Math.max(max, dp[i] - dp[i - k]);
//			if (i - k - 1 < 0) {
//				
//			} else {
//				max = Math.max(max, dp[i] - dp[i - k - 1]);
//			}

		}
		System.out.println(max);
	}

}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}