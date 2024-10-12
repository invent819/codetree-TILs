import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new Node(x, y));
		}

		for (int i = 0; i < m; i++) {
			Node node = pq.poll();
			node.x += 2;
			node.y += 2;
			pq.add(node);
		}
		System.out.println(pq.peek());
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
		if ((x + y) != (o.x + o.y)) {
			return Integer.compare((x + y), o.x + o.y);
		} else if (x != o.x) {
			return Integer.compare(x, o.x);
		}
		return Integer.compare(y, o.y);

	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}