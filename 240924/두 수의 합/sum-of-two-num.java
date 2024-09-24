import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] nums;
	static boolean[] visited;

	static int result = 0;

	static void comb(int idx, int cnt, int[] choice) {
		if (cnt == 2) {
			if (choice[0] + choice[1] == k) {
				result++;
//				System.out.println(Arrays.toString(choice));
			}

			return;
		}
		if (idx == n) {
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				choice[cnt] = nums[i];
				visited[i] = true;
				comb(i + 1, cnt + 1, choice);
				visited[i] = false;

			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		nums = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		comb(0, 0, new int[2]);

		System.out.println(result);
	}

}