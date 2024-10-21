import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX_N = 100000;
	static int n, k, b;
	static int[] arr = new int[MAX_N];
	static int[] prefixSum = new int[MAX_N];

	public static int getSum(int s, int e) {
		if (s == 1) {
			return prefixSum[e];
		}
		return prefixSum[e] - prefixSum[s - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		prefixSum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = 1;
			prefixSum[i]++;
		}
		for (int i = 0; i < b; i++) {
			int idx = Integer.parseInt(br.readLine());
			arr[idx] = 0;
		}
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n - k + 1; i++) {
			int sum = k - getSum(i, i + k - 1);
//			System.out.println("sum " + sum);
			ans = Math.min(ans, sum);
		}

//		System.out.println(Arrays.toString(prefixSum));
		System.out.println(ans);

	}

}