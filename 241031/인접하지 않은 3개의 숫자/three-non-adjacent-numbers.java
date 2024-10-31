import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static int MAX_N = 100000;
	public static int[] arr = new int[MAX_N];
	public static int[] L = new int[MAX_N];
	public static int[] R = new int[MAX_N];
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		L[0] = arr[0];
		R[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			L[i] = Math.max(L[i - 1], arr[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			R[i] = Math.max(R[i + 1], arr[i]);
		}

		int ans = 0;

		for (int i = 2; i < n - 2; i++) {
			ans = Math.max(ans, L[i - 2] + arr[i] + R[i + 2]);
		}
		System.out.println(ans);

	}
}