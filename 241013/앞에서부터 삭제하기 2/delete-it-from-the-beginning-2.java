import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] arr = new int[100_000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		double avgMax = 0;
		for (int i = 0; i < n; i++) {
			int input = (Integer.parseInt(st.nextToken()));
			pq.add(input);
			arr[i] = input;
			sum += input;
		}

		for (int i = 0; i < n - 2; i++) {
			double localAvg = 0;
			pq.remove(arr[i]);
			int min = pq.peek();
//			System.out.println("min = " + min);
			sum -= arr[i];

			localAvg = (sum - min) / ((n - (i + 2) * 1.0));
			avgMax = Math.max(avgMax, localAvg);
		}

		System.out.printf("%.2f", avgMax);
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