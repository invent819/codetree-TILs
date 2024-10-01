import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;
	static HashSet<String> aSet = new HashSet<String>();
	static HashSet<String> bSet = new HashSet<String>();
	static char[][] a;
	static char[][] b;
	static boolean[] visited;
	static int[] selected = new int[3];
	static int ans = 0;

	static void comb(int cIdx, int sIdx) {
		if (cIdx == 3) {
			for (int i = 0; i < n; i++) {
				char[] word = new char[3];
				for (int j = 0; j < 3; j++) {
					int idx = selected[j];
					word[j] = a[i][idx];
				}
				aSet.add(new String(word));
			}

			for (int i = 0; i < n; i++) {
				char[] word = new char[3];
				for (int j = 0; j < 3; j++) {
					int idx = selected[j];
					word[j] = b[i][idx];
				}
				if (aSet.contains(new String(word))) {
					aSet.clear();
					return;
				}
			}
			ans++;
			aSet.clear();
			return;
		}

		for (int i = sIdx; i < m; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cIdx] = i;
				comb(cIdx + 1, i);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[m];
		a = new char[n][m];
		b = new char[n][m];

		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			b[i] = br.readLine().toCharArray();
		}
		comb(0, 0);
		System.out.println(ans);

	}
}