import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static int[][] map;
	static TreeSet<Integer> treeSet = new TreeSet<>();
	static boolean[] visited;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			treeSet.add(Integer.parseInt(st.nextToken()) * -1);
		}
		for (Integer s : treeSet) {
			int find = (s * -1) - 1;
			if (!visited[find]) {
				visited[find] = true;
				ans++;
			}
		}
		System.out.println(ans);
	}
}