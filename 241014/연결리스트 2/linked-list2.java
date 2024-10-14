import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;

	static HashMap<Integer, Node> map = new HashMap<>();
	static int[] arr1 = new int[100_000];
	static int[] arr2 = new int[100_000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			map.put(i, new Node(i));
		}
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			switch (command) {
			case 1: {
				int n1 = Integer.parseInt(st.nextToken());
				Node node = map.get(n1);

				if (node.prev != null) {
					node.prev.next = node.next;

				}
				if (node.next != null) {
					node.next.prev = node.prev;

				}
				node.prev = null;
				node.next = null;
				break;
			}
			case 2: {
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				Node node1 = map.get(n1);
				Node node2 = map.get(n2);
				if (node1.prev != null) {
					node1.prev.next = node2;
					node2.prev = node1.prev;
				}
				node1.prev = node2;
				node2.next = node1;
				break;
			}
			case 3: {
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				Node node1 = map.get(n1);
				Node node2 = map.get(n2);
				if (node1.next != null) {
					node1.next.prev = node2;
					node2.next = node1.next;
				}
				node1.next = node2;
				node2.prev = node1;
				break;
			}
			case 4: {
				int n1 = Integer.parseInt(st.nextToken());
				Node node = map.get(n1);
				System.out.print(node.prev == null ? "0 " : node.prev.data + " ");
				System.out.print(node.next == null ? "0 " : node.next.data + " ");
				System.out.println();
				break;
			}
			}

		}
		for (int i = 1; i <= n; i++) {
			Node node = map.get(i);
			System.out.print(node.next == null ? "0 " : node.next.data + " ");
		}

	}

}

class Node {
	int data;
	Node prev, next;

	public Node(int data) {
		this.data = data;
	}
}