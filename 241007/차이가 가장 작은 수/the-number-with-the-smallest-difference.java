import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static char[][] graph;
	static int[] arr;
	static int ans = Integer.MAX_VALUE;

	static TreeSet<Integer> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			treeSet.add(arr[i]);
		}

		for (int i = 0; i < n; i++) {
			int x = arr[i];

			if (treeSet.ceiling(m + x) != null) {
				ans = Math.min(ans, treeSet.ceiling(m + x) - x);
			}

			if (treeSet.floor(x - m) != null) {
				ans = Math.min(ans, x - treeSet.floor(x - m));
			}
		}

		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.println(ans);

	}
}