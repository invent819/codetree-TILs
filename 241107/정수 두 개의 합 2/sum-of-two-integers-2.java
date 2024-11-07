import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, s;

	public static int MAX_N = 100000;
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

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];

//		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int j = n;

		int ans = 0;
//		System.out.println(m);
//		System.out.println(Arrays.toString(arr));
		l = 0;
		r = n - 1;
		while (l < r) {
//			System.out.println("l = " + l + " r = " + r);

			int sum = arr[l] + arr[r];
			if (sum >= m) {
				r--;
			} else if (sum < m) {

				
				l++;
			}
			if(sum <= m) {
				ans ++;
			}

		}
		System.out.println(ans);

	}
}