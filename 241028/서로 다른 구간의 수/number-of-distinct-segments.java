import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static final int MAX_NUM = 100_001;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[MAX_NUM];

		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			points.add(new Point(x1, 1, i));
			points.add(new Point(x2, -1, i));
		}
		Collections.sort(points);
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < 2 * n; i++) {
			Point point = points.get(i);
			if (point.v == 1) {
				if (map.isEmpty()) {
					ans++;
				}
				map.put(point.idx, point.idx);
			} else {
				map.remove(point.idx);
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