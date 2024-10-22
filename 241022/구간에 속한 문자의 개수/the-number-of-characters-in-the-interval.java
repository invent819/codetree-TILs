import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static char[][] graph;
	static Node[][] dp;

	static Node getSum(int x1, int y1, int x2, int y2) {
		int a, b, c;

		Node n1 = dp[x2][y2];
		Node n2 = dp[x1 - 1][y2];
		Node n3 = dp[x2][y1 - 1];
		Node n4 = dp[x1 - 1][y1 - 1];

		a = n1.a - n2.a - n3.a + n4.a;
		b = n1.b - n2.b - n3.b + n4.b;
		c = n1.c - n2.c - n3.c + n4.c;

		return new Node(a, b, c);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		graph = new char[n + 1][m + 1];
		dp = new Node[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = new Node(0, 0, 0);
		}
		for (int j = 0; j <= m; j++) {
			dp[0][j] = new Node(0, 0, 0);
		}

		for (int i = 1; i <= n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 1; j <= m; j++) {
				graph[i][j] = row[j - 1];

				Node n1 = dp[i - 1][j];
				Node n2 = dp[i][j - 1];
				Node n3 = dp[i - 1][j - 1];

				int a = n1.a + n2.a - n3.a;
				int b = n1.b + n2.b - n3.b;
				int c = n1.c + n2.c - n3.c;

				switch (graph[i][j]) {
				case 'a': {
					a++;
					break;
				}
				case 'b': {
					b++;
					break;
				}
				case 'c': {
					c++;
					break;
				}
				}
				dp[i][j] = new Node(a, b, c);
			}

		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(getSum(x1, y1, x2, y2) + "\n");

		}
		System.out.println(sb.toString());
	}

}

class Node {
	int a, b, c;

	public Node(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return a + " " + b + " " + c;
	}

}