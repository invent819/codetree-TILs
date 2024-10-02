import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static TreeSet<Integer> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			treeSet.add(Integer.parseInt(st.nextToken()) * -1);
		}

		int i = 0;
		for (Integer t : treeSet) {

			if (i == m)
				break;
			System.out.print(t * -1 + " ");
			i++;
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
		if (this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}

}