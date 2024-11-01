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

		char[] input = br.readLine().toCharArray();

		int cnt = 0;

		int len = input.length;
		for (int i = 0; i < len; i++) {
			if (input[i] == '(') {
				cnt++;
			} else {
				cnt = 0;
			}
			if (i != 0) {
				L[i] = L[i - 1];
			}

			if (cnt >= 2) {
				L[i] += 1;
			}
		}

		cnt = 0;

		for (int i = len - 1; i >= 0; i--) {
			if (input[i] == ')') {
				cnt++;
			} else {
				cnt = 0;
			}
			if (i != len - 1) {
				R[i] = R[i + 1];
			}

			if (cnt >= 2) {
				R[i] += 1;
			}
		}
//		System.out.println(Arrays.toString(L));
//		System.out.println(Arrays.toString(R));

		int ans = L[len - 1] * R[0];

		System.out.println(ans);

	}

}