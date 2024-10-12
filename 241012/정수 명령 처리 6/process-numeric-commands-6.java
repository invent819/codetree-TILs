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
		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push": {
				pq.add(Integer.parseInt(st.nextToken()) * -1);
				break;
			}
			case "pop": {
				System.out.println(pq.poll() * -1);
				break;
			}
			case "size": {
				System.out.println(pq.size());
				break;
			}
			case "empty": {
				System.out.println(pq.isEmpty() ? 1 : 0);
				break;
			}
			case "top": {
				System.out.println(pq.peek() * -1);
				break;
			}
			}

		}

	}
}