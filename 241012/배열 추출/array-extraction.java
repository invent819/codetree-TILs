import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int n, m;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine()) * -1;
			if (input == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					int num = pq.poll() * -1;
					System.out.println(num);
				}

			} else {
				pq.add(input);
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