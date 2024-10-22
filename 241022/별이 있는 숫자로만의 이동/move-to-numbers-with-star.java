import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] graph;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Node[][] dp;

	static boolean[][] visited;
	static Queue<Node> queue = new LinkedList<>();

	static int bfs(Node node) {
		visited = new boolean[n + 1][n + 1];
		queue = new LinkedList<>();
		queue.add(node);
		visited[node.x][node.y] = true;
		int cnt = graph[node.x][node.y];

		while (!queue.isEmpty()) {
			Node pNode = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + pNode.x;
				int ny = dy[i] + pNode.y;
				if (0 < nx && nx <= n && 0 < ny && ny <= n) {
					if (!visited[nx][ny] && isInner(node, new Node(nx, ny))) {
						cnt += graph[nx][ny];
						queue.add(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}

		return cnt;

	}

//	static Node getSum(int x1, int y1, int x2, int y2) {
//		int a, b, c;
//
//		Node n1 = dp[x2][y2];
//		Node n2 = dp[x1 - 1][y2];
//		Node n3 = dp[x2][y1 - 1];
//		Node n4 = dp[x1 - 1][y1 - 1];
//
//		a = n1.a - n2.a - n3.a + n4.a;
//		b = n1.b - n2.b - n3.b + n4.b;
//		c = n1.c - n2.c - n3.c + n4.c;
//
//		return new Node(a, b, c);
//	}

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
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				ans = Math.max(ans, bfs(new Node(i, j)));
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