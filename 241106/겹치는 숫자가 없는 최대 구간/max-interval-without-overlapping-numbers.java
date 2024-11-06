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
	static int[] nums = new int[MAX_N + 1];

	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		arr = new int[MAX_N + 1];

		int ans = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int j = 0;
//		nums[arr[1]] = 1;
		for (int i = 1; i <= n; i++) {
			while (j + 1 <= n && nums[arr[j + 1]] == 0) {
				nums[arr[j + 1]] = 1;
				j++;
			}

			ans = Math.max(ans, j - i + 1);

			nums[arr[i]]--;
		}

		System.out.println(ans);
	}
}