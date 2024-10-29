import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m, k;

	static TreeSet<Node> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			treeSet.add(new Node(s, -1, i));
			treeSet.add(new Node(e, 1, i));
		}
		int cnt = 0;
		int last = 0;
		int ans = 0;
		for (Node node : treeSet) {

			if (node.v == -1) {
				if (cnt == 0) {
					last = node.x;
//					System.out.println("last " + last);
				}
				cnt++;
			} else {
				cnt--;
				if (cnt == 0) {
					ans += (node.x - last);
				}

			}
		}
		System.out.println(ans);

	}

}

class Node implements Comparable<Node> {
	int x, v, i;

	public Node(int x, int v, int i) {
		this.x = x;
		this.v = v;
		this.i = i;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(x, o.x);
	}

}