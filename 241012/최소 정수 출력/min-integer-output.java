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
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					int num = pq.poll();
					System.out.println(num);
				}

			} else {
				pq.add(input);
			}
		}

	}
}