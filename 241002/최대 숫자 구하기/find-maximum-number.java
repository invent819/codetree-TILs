import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static TreeSet<Integer> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= m; i++) {
			treeSet.add(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			treeSet.remove(Integer.parseInt(st.nextToken()));
			System.out.println(treeSet.last());
		}

	}
}