import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

	static int getLowerBound(int find) {
		int l = 0;
		int r = n - 1;
		int minIdx = n;
		while (l <= r) {
			int mid = (l + r) / 2;
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

	static int getCount(int x1, int x2) {
		int ret = 0;

		int l = getLowerBound(x1);
		int r = getUpperBound(x2);

		return r - l;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);


		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			System.out.println(getCount(x1, x2));
		}


	}
}
