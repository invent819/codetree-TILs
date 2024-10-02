import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static TreeSet<Integer> nums = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(br.readLine());
			Integer find = nums.ceiling(x);
			if (find == null) {
				System.out.println(-1);
			} else {
				System.out.println(find);
			}
		}

	}
}