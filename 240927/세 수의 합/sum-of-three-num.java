import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] nums;
	static boolean[] visited;
	static int ret = 0;

	static void comb(int idx, int sIdx, int cnt, int sum) {
		if (cnt == 3) {
			if (sum == k) {
				ret++;
			}
			return;
		}

		for (int i = sIdx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(idx + 1, i, cnt + 1, sum + nums[i]);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nums = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0, 0, 0);
		System.out.println(ret);

	}

}