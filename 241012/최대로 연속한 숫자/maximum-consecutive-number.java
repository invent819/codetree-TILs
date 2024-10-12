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
		treeSet.add(0);
		treeSet.add(n);

		st = new StringTokenizer(br.readLine());
		Integer higher = -1;
		Integer lower = -1;
		for (int i = 0; i < m; i++) {
			int input = Integer.parseInt(st.nextToken());
			treeSet.add(input);

			int maxLength = 0;

			for (Integer s : treeSet) {
				higher = treeSet.higher(s);
				lower = treeSet.lower(s);

				int localMaxLen = 0;
				if (higher != null) {
					int len = higher - s;
					if (higher != n) {
						len--;
					}
					localMaxLen = Math.max(localMaxLen, len);
				}
				if (lower != null) {

					int len = s - lower;
					if (lower != 0) {
						len--;
					}
					localMaxLen = Math.max(localMaxLen, len);

				}
				maxLength = Math.max(maxLength, localMaxLen);
//				System.out.println(maxLength);
			}

			System.out.println(maxLength);
		}

	}
}