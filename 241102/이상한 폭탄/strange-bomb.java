import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX_N = 1_000_000;
	static int n, k;
	static Point[] arr = new Point[MAX_N];
	static int[] L = new int[MAX_N];
	static int[] R = new int[MAX_N];

	static boolean valid(int creterian, int target) {
		return creterian - k <= target && target <= creterian + k;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new Point[n];
		for (int i = 0; i < n; i++) {
			int v = Integer.parseInt(br.readLine());
			arr[i] = new Point(i, v);
		}
//		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		boolean has = false;

		for (int i = 0; i < n - 1; i++) {
			Point p1 = arr[i];
			Point p2 = arr[i+1];
			if(p1.v == p2.v && valid(p1.x, p2.x)) {
				System.out.println(p1.v);
				has  = true;
				break;
			}
		}
		
		if(!has)
			System.out.println(-1);

	}

}

class Point implements Comparable<Point> {
	int x, v;

	Point(int x, int v) {
		this.x = x;
		this.v = v;
	}

	@Override
	public int compareTo(Point o) {
		if(o.v != v) {
			return Integer.compare(o.v, v);
		}
		return Integer.compare(o.x, x);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", v=" + v + "]";
	}
}