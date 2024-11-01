import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX_N = 100_000;
	static int n, q;
	static int[] arr = new int[MAX_N];
	static int[] L = new int[MAX_N];
	static int[] R = new int[MAX_N];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		int maxLN = Integer.MIN_VALUE;
		int maxRN = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
		 maxLN=	L[i] = Math.max(maxLN, arr[i]);
		maxRN=	R[n - i - 1] = Math.max(maxRN, arr[n - 1 - i]);
		}
//		System.out.println(Arrays.toString(L));
//		System.out.println(Arrays.toString(R));
		

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(Math.max(L[a - 2], R[b ]));
		}
	}

}