import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, s;

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

	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		l = r = 0;
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MAX_VALUE;

		int sum = arr[0];
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j + 1 < n && sum + arr[j + 1] < s) {
				sum += arr[j + 1];
				j++;
			}

			if (j + 1 < n && sum <  s) {
				sum += arr[j + 1];
				j++;
			}

			if (sum >= s) {
//				System.out.println("j: " + j + " i: " + i + " sum: " + sum);
				ans = Math.min(ans, j - i + 1);
			}

			sum -= arr[i];
		}

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}
}