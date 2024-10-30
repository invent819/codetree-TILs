import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n, k;

	static ArrayList<Point> arr = new ArrayList<>();

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
				last -= len;
			}

			arr.add(sp);
			arr.add(ep);
		}
		Collections.sort(arr);

		Point[] points = arr.toArray(new Point[arr.size()]);
//		System.out.println(Arrays.toString(points));

		int cnt = 0;
		int ans = 0;

		for (int i = 0; i < 2 * n; i++) {
			Point current = arr.get(i);
			if (cnt >= k) {
				int preX = arr.get(i - 1).x;
				ans += (current.x - preX);
			}

			cnt += current.v;
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
		if (x != o.x) {
			return Integer.compare(x, o.x);
		}
		return Integer.compare(v, o.v);

	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", v=" + v + ", idx=" + idx + "]";
	}

}