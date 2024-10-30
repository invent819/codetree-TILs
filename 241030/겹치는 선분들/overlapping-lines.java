import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, k;
	static final int MAX_NUM = 100_001;

	static int[] arr;

	static TreeSet<Point> treeSet = new TreeSet<>();
	static HashSet<Integer> l = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int last = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			Point sp;
			Point ep;
			if (dir.equals("R")) {
				sp = new Point(last, 1, i);
				ep = new Point(last + len, -1, i);
				last += len;
			} else {
				sp = new Point(last - len, 1, i);
				ep = new Point(last, -1, i);
			}

			treeSet.add(sp);
			treeSet.add(ep);
		}

		int cnt = 0;
		int start = 0;
		int ans = 0;
		for (Point p : treeSet) {
			if (p.v == 1) {
				cnt++;
				if (cnt == k) {
					start = p.x;
				}
			} else {
				cnt--;
				if (cnt == k) {
					ans += (p.x - start);
				}
			}

		}
		System.out.println(ans);
	}
}

class Point implements Comparable<Point> {
	int x, v, idx;

	Point(int x, int v, int idx) {
		this.x = x;
		this.v = v;
		this.idx = idx;
	}

	@Override
	public int compareTo(Point o) {
		return Integer.compare(x, o.x);
	}

}