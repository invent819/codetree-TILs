import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static TreeSet<Integer> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		treeSet.add(0);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int insert = Integer.parseInt(st.nextToken());
			treeSet.add(insert);

			Integer lower = treeSet.lower(insert);
			Integer higher = treeSet.higher(insert);
			if (lower == null) {
				min = Math.min(min, Math.abs(insert - higher));
				System.out.println(min);
			} else if (higher == null) {
				min = Math.min(min, Math.abs(insert - lower));
				System.out.println(min);
			} else {
				min = Math.min(min, Math.min(Math.abs(insert - lower), Math.abs(insert - higher)));
				System.out.println(min);
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
		if (this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}

}