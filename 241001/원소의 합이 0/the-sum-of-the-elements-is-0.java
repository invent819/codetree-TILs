import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX_N = 5000;

	public static int n;
	public static int[] A = new int[MAX_N];
	public static int[] B = new int[MAX_N];
	public static int[] C = new int[MAX_N];
	public static int[] D = new int[MAX_N];
	public static HashMap<Integer, Integer> freq = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int key = A[i] + B[j];
				freq.put(key, freq.getOrDefault(key, 0) + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int diff = -C[i] - D[j];
				if (freq.getOrDefault(diff, 0) > 0) {
					ans += freq.get(diff);
				}
			}
		}
		System.out.println(ans);

	}
}