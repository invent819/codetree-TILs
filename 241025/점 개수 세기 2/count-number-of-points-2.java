import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Tuple {
	int x1, y1, x2, y2;

	public Tuple(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}

public class Main {
	public static final int MAX_M = 5000;
	public static final int MAX_Q = 300000;
	public static final int MAX_N = 2500;

	static int n, q;
	static Pair[] points = new Pair[MAX_N];
	static Tuple[] queries = new Tuple[MAX_Q];

	static TreeSet<Integer> nums = new TreeSet<>();
	static HashMap<Integer, Integer> mapper = new HashMap<>();

	static int[][] prefixSum = new int[MAX_M + 2][MAX_M + 2];

	static int getUpperBoundary(int x) {
		if (nums.floor(x) != null) {
			return mapper.get(nums.floor(x));
		}
		return 0;
	}

	static int getLowerBoundary(int x) {
		if (nums.ceiling(x) != null) {
			return mapper.get(nums.ceiling(x));
		}
		return (int) nums.size() + 1;
	}

	static int getSum(int x1, int y1, int x2, int y2) {
		return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		q = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Pair(x, y);
			nums.add(x);
			nums.add(y);
		}

		for (int i = 0; i < q; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			queries[i] = new Tuple(x1, y1, x2, y2);
		}

		int cnt = 1;
		for (Integer num : nums) {
			mapper.put(num, cnt);
			cnt++;
		}

		for (int i = 0; i < n; i++) {
			int x = points[i].x;
			int y = points[i].y;

			int newX = mapper.get(x);
			int newY = mapper.get(y);

			prefixSum[newX][newY]++;
		}

		for (int i = 1; i <= cnt; i++) {
			for (int j = 1; j <= cnt; j++) {
				prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
			}
		}

		for (int i = 0; i < q; i++) {
			int x1 = queries[i].x1;
			int y1 = queries[i].y1;
			int x2 = queries[i].x2;
			int y2 = queries[i].y2;

			int newX1 = getLowerBoundary(x1);
			int newY1 = getLowerBoundary(y1);
			int newX2 = getUpperBoundary(x2);
			int newY2 = getUpperBoundary(y2);

			int ans = getSum(newX1, newY1, newX2, newY2);
			System.out.println(ans);
		}
	}
}