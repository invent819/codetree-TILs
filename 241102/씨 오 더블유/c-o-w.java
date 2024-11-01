import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX_N = 100_000;
	static int n, q;
	static char[] arr = new char[MAX_N];
	static int[] L = new int[MAX_N];
	static int[] R = new int[MAX_N];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(br.readLine());
		char[] word = br.readLine().toCharArray();
//		L = new int[n];
//		R = new int[n];
		L[0] = word[0] == 'C' ? 1 : 0;
		for (int i = 1; i < n; i++) {
			L[i] += L[i - 1] + (word[i] == 'C' ? 1 : 0);
		}

		R[n - 1] = word[n - 1] == 'W' ? 1 : 0;
		for (int i = n - 2; i >= 0; i--) {
			R[i] += R[i + 1] + (word[i] == 'W' ? 1 : 0);
		}

//		System.out.println(Arrays.toString(L));
//		System.out.println(Arrays.toString(R));
		long ans = 0;
		for (int i = 1; i < n - 1; i++) {
			if (word[i] == 'O') {
				ans += (L[i - 1] * R[i + 1]);
			}

		}
		System.out.println(ans);

	}

}