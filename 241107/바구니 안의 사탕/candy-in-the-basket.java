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

	public static int MAX_N = 1_000_000;
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
		k = Integer.parseInt(st.nextToken());
		arr = new int[MAX_N + 2];

		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = cnt;
			
		}

		int l = 0;
		int r = k * 2 + 1 >= MAX_N ? MAX_N : k * 2  ;
		int sum = 0;
		int ans = 0;

		for (int i = l; i <= r; i++) {
			sum += arr[i];
		}
		ans = sum;
//		System.out.println(ans);

		for (int i = r; i < MAX_N + 1; i++) {
			int nl = l++;
			int nr = r++;
//			
			sum = sum - arr[nl] + arr[r];
			if(ans < sum ) {
//				System.out.println("nl = "+nl + " nr = "+ nr + " sum = " + sum);
			}
			ans = Math.max(ans, sum);
		}

		
		System.out.println(ans);
		

	}
}