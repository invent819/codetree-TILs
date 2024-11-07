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
	public static char[] arr = new char[MAX_N];
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
		int[] cnt = new int[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = br.readLine().toCharArray();

		int len = arr.length;

		int ans = 0;
		int j = -1;
		int sum = 0;
		for (int i = 0; i < len; i++) {


			while (j + 1 < len && cnt[(int) (arr[j + 1] - 'a')] == 0) {
				sum++;
				j++;
				cnt[(int) (arr[j] - 'a')] = 1;
				ans = Math.max(ans, sum);
			}
			sum -=1;
			
			cnt[(int) (arr[i] - 'a')] -= 1;
		}

		System.out.println(Math.abs(ans));
	}
}