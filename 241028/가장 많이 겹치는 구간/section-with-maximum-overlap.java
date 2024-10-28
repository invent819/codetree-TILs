import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static final int MAX_NUM = 100_000;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[MAX_NUM];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			arr[x1] += 1;
			arr[x2] -= 1;

		}

		int sum = 0;
		int ans = 0;
		for (int i = 0; i < MAX_NUM; i++) {
			sum += arr[i];
			ans = Math.max(ans, sum);
		}

		System.out.println(ans);

	}
}