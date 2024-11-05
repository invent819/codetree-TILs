import java.util.Scanner;

public class Main {
	static int n, s, k;
	static int MAX_N = 100000;
	static int[] arr = new int[MAX_N + 1];

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		n = Integer.parseInt(br.readLine());

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		for (int i = 1; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = Integer.MAX_VALUE;
		int sumVal = 0;
		int j = 0;

		for (int i = 1; i <= n; i++) {
			while (j + 1 <= n && sumVal < s) {
				sumVal += arr[j + 1];
				j++;
			}

			if (sumVal < s) {
				break;
			}

			ans = Math.min(ans, j - i + 1);
			sumVal -= arr[i];
		}

		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.println(ans);

	}

}