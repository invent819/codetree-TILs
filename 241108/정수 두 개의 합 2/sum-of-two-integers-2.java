import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, s, k;
	static int MAX_N = 100000;
	static int[] arr = new int[MAX_N + 1];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr, 1, n + 1);

		int ans = 0;
		int j = n;
		for (int i = 1; i <= n; i++) {
			while (j != 1 && arr[i] + arr[j] > k) {
				j--;
			}
			if (j <= i)
				break;

			ans += j - i;
		}

		System.out.println(ans);

	}

}