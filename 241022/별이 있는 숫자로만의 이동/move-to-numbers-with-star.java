import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] graph;
	static int[][] dp;


	static int getSum(Node node) {

		int sum = 0;
		sum += rowPreSum(node, k);
		for (int i = 1; i <= k; i++) {
			if (node.x - i > 0) {
				sum += rowPreSum(new Node(node.x - i, node.y), k - i );
			}
			if (node.x + i <= n) {
				sum += rowPreSum(new Node(node.x + i, node.y), k - i );
			}
		}

		return sum;
	}

	static int rowPreSum(Node node, int length) {
		int y1 = node.y;
		int y2 = node.y;

		if (y1 - length <= 0) {
			y1 = 1;
		} else {
			y1 -= length;
		}
		if (y2 + length > n) {
			y2 = n;
		} else {
			y2 += length;
		}

		return dp[node.x][y2] - dp[node.x - 1][y2] - dp[node.x][y1 - 1] + dp[node.x - 1][y1 - 1];
	}

	static int getDist(Node n1, Node n2) {
		return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
	}

	static boolean isInner(Node n1, Node n2) {
		return getDist(n1, n2) <= k;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int ans = Integer.MIN_VALUE;
		graph = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + graph[i][j] - dp[i - 1][j - 1];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int sum = getSum(new Node(i, j));

//				if (i == 3 && j == 3) {
//					System.out.println("sum = " + sum);
//				}
				ans = Math.max(ans, sum);
			}
		}
		System.out.println(ans);
	}

}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}