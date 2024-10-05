import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static int[][] map;
	static int[] arr;
	static TreeSet<Integer> seats = new TreeSet<>();
	static boolean[] visited;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[m];
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= m; i++) {
			seats.add(i);
		}
		for (int i = 0; i < n; i++) {
			if (seats.floor(arr[i]) != null) {
				int num = seats.floor(arr[i]);
				seats.remove(num);
				ans++;
			} else
				break;
		}

		System.out.println(ans);
	}
}