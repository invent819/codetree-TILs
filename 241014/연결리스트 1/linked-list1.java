import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	static int[] arr1 = new int[100_000];
	static int[] arr2 = new int[100_000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		String init = br.readLine();
		Node cur = new Node(init);
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1: {
				String value = st.nextToken();
				Node node = new Node(value);
				if (cur.prev != null) {
					cur.prev.next = node;
					node.prev = cur.prev;
				}
				cur.prev = node;
				node.next = cur;
				break;
			}
			case 2: {
				String value = st.nextToken();
				Node node = new Node(value);
				if (cur.next != null) {
					cur.next.prev = node;
					node.next = cur.next;
				}
				node.prev = cur;
				cur.next = node;
				break;
			}
			case 3: {
				if (cur.prev != null) {
					cur = cur.prev;
				}
				break;
			}
			case 4: {
				if (cur.next != null) {
					cur = cur.next;
				}
				break;
			}
			}
			if (cur.prev == null) {
				System.out.print("(Null) ");
			} else {
				System.out.print(cur.prev.data + " ");
			}
			if (cur.data == null) {
				System.out.print("(Null) ");
			} else {
				System.out.print(cur.data + " ");
			}

			if (cur.next == null) {
				System.out.print("(Null) ");
			} else {
				System.out.print(cur.next.data + " ");
			}
			System.out.println();

		}

	}

}

class Node {
	String data;

	Node prev, next;

	public Node(String data) {
		this.data = data;
	}

}