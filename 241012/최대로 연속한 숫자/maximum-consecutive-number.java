import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static TreeSet<Integer> sNum = new TreeSet<>();
	static TreeSet<Node> sLen = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		sNum.add(-1);
		sNum.add(n + 1);
		sLen.add(new Node(n + 1, -1, n + 1));

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int input = Integer.parseInt(st.nextToken());

			sNum.add(input);

			int h = sNum.higher(input);
			int l = sNum.lower(input);

			sLen.remove(new Node(h - l - 1, l, h));
			sLen.add(new Node(input - l - 1, l, input));
			sLen.add(new Node(h - input - 1, input, h));

			System.out.println(sLen.first().len);
		}

	}
}

class Node implements Comparable<Node> {
	int len, s, e;

	public Node(int len, int s, int e) {
		this.len = len;
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Node o) {
		if (this.len != o.len) {
			return Integer.compare(o.len, len);
		} else if (this.s != o.s) {
			return Integer.compare(s, o.s);
		}
		return Integer.compare(e, o.e);
	}

}