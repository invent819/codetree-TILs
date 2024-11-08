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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int j = -1;
		for (int i = 0; i < n; i++) {

			while (j + 1 < n && map.getOrDefault(arr[j + 1], 0) < k) {
				int cnt = map.getOrDefault(arr[j + 1], 0);
				map.put(arr[j + 1], cnt + 1);
				j++;

			}
			ans = Math.max(ans, j - i + 1);
		}

		System.out.println(ans);
	}
}