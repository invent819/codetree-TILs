import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, m, s, k;

	public static int MAX_N = 100_000;
	public static int[] arr = new int[MAX_N + 1];
	public static int[] L = new int[MAX_N];
	public static int[] R = new int[MAX_N];
	public static int ans = 0;
	static int r, c, l;
	static int[][] graph;

	static StringBuilder sb = new StringBuilder();
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] nums = new int[MAX_N + 1];

	static long[] dp;
	static int[] a, b;

	static HashMap<Integer, Integer> map = new HashMap<>();

	static int getCount(int find) {

		int lower = getLowerBound(find);
		int upper = getUpperBound(find);
		if (lower == upper) {
			return 0;
		}
		return upper - lower;
	}

	static int getLowerBound(int find) {
		int l = 0;
		int r = n - 1;
		int mid = (l + r) / 2;
		int minIdx = n;
		while (l <= r) {
			mid = (l + r) / 2;
			if (arr[mid] >= find) {
				r = mid - 1;
				minIdx = Math.min(minIdx, mid);
			} else {
				l = mid + 1;
			}
		}
		return minIdx;
	}

	static int getUpperBound(int find) {
		int l = 0;
		int r = n - 1;
		int minIdx = n;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] > find) {
				r = mid - 1;
				minIdx = Math.min(minIdx, mid);
			} else {
				l = mid + 1;
			}
		}
		return minIdx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int find = Integer.parseInt(br.readLine());
			System.out.println(getCount(find));
		}

		
	}
}
