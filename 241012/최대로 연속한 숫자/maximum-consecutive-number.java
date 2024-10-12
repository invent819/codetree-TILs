import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static TreeSet<Node> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		treeSet.add(new Node(0, 0, n));
		treeSet.add(new Node(n, n, 0));

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int input = Integer.parseInt(st.nextToken());
			Node initInput = new Node(input, 0, 0);
			treeSet.add(initInput);
			Node h = treeSet.higher(initInput);
			Node l = treeSet.lower(initInput);

			if (h != null) {
				treeSet.remove(h);
				h.left = h.n - input;
				if (h.n != n) {
					h.left--;
				}
				treeSet.add(new Node(h.n, h.left, h.right));
			}

			if (l != null) {
				treeSet.remove(l);
				l.right = input - l.n;
				if (l.n != 0) {
					l.right--;
				}
				treeSet.add(new Node(l.n, l.left, l.right));
			}

			treeSet.remove(initInput);
			initInput.left = l.right;
			initInput.right = h.left;
			treeSet.add(new Node(initInput.n, initInput.left, initInput.right));
			int ans = 0;
			for (Node n : treeSet) {
				ans = Math.max(ans, n.maxLength);
			}

			System.out.println(ans);
		}

	}
}

class Node implements Comparable<Node> {
	int n;
	int left;
	int right;
	int maxLength;

	public Node(int n, int left, int right) {
		this.n = n;
		this.left = left;
		this.right = right;
		this.maxLength = Math.max(left, right);
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(n, o.n);
//		return Integer.compare(maxLength, o.maxLength);
	}

	@Override
	public int hashCode() {
		return Objects.hash(n);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return n == other.n;
	}

}