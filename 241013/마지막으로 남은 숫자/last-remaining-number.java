import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(st.nextToken()) * -1);
		}

		while (pq.size() > 1) {
			int n1 = pq.poll() * -1;
			int n2 = pq.poll() * -1;

			int diff = n1 - n2;
			if (n1 - n2 != 0) {
				pq.add(diff * -1);
			}

		}
		if (pq.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(pq.peek() * -1);
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
		if ((x + y) == (o.x + o.y)) {
			return Integer.compare((x + y), o.x + o.y);
		} else if (x == o.x) {
			return Integer.compare(x, o.x);
		}
		return Integer.compare(y, o.y);

	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}