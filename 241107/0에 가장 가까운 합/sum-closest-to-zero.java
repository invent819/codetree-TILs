import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, s, k;

	public static int MAX_N = 100_000;
	public static int[] arr = new int[MAX_N];
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
//		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = n - 1;

		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int ans = Integer.MAX_VALUE;
		while (l < r) {
			int sum = arr[l] + arr[r];
//			System.out.println("sum = " + sum);
			if (sum > 0) {
				r--;
			} else if (sum < 0) {
				l++;
			} else {
//				System.out.println("find !!");
				ans = 0;
				break;
			}

			if (Math.abs(sum) < ans) {
				ans = Math.abs(sum);
			}
		}

		System.out.println(Math.abs(ans));
	}
}