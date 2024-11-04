import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static int MAX_N = 100000;
	public static int[] arr = new int[MAX_N];
	public static int[] L = new int[MAX_N];
	public static int[] R = new int[MAX_N];
	public static int ans;
	static int r, c;
	static int[][] graph;

	static StringBuilder sb = new StringBuilder();
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[] energy;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		distance = new int[n - 1];
		energy = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			energy[i] = Integer.parseInt(st.nextToken());
		}

		L = new int[n];
		L[0] = energy[0];

		for (int i = 1; i < n; i++) {
			L[i] = Math.min(L[i - 1], energy[i]);
		}

//		System.out.println(Arrays.toString(L));
		L[n-1] = L[n-2];
		long ans = 0;
		for (int i = 0; i < n - 1; i++) {
			ans += L[i] * distance[i];
		}

		System.out.println(ans);
	}
}