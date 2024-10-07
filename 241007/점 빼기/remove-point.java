import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static char[][] graph;
	static int[] arr;
	static int ans = Integer.MAX_VALUE;

	static TreeSet<Node> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			treeSet.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for (int i = 0; i < m; i++) {
			int k = Integer.parseInt(br.readLine());
			Node find = treeSet.ceiling(new Node(k, 0));
			if (find != null) {
				System.out.println(find);
				treeSet.remove(find);
			} else {
				System.out.println("-1 -1");
			}
		}
	}
}

class Node implements Comparable<Node> {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		if (this.x == o.x) {
			return Integer.compare(this.y, o.y);
		}
		return Integer.compare(this.x, o.x);
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}