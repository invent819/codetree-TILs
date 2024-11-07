import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, s, k;
	static int MAX_N = 100000;
	static int[] arr = new int[MAX_N + 1];
	static int[] cnt = new int[26];

	static boolean isValid(int idx) {
		int[] copyCnt = Arrays.copyOf(cnt, 26);
		int vCnt = 0;
		copyCnt[idx] += 1;
//		System.out.println(Arrays.toString(copyCnt) + " idx = " + idx);
		for (int i = 0; i < 26; i++) {
			if (copyCnt[i] > 0) {
				vCnt++;
				if (vCnt > k) {
//					System.out.println("vcnt = " + vCnt);
					return false;
				}

			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] words = st.nextToken().toCharArray();

		k = Integer.parseInt(st.nextToken());

		int j = -1;
		int len = words.length;
		int ans = 0;

		for (int i = 0; i < len; i++) {
			int localMax = Integer.MIN_VALUE;
			while (j + 1 < len && isValid((int) (words[j + 1] - 'a'))) {
//				System.out.println("pass");
				cnt[(int) (words[j + 1] - 'a')] += 1;
				j++;
			}
//			System.out.println("i = " + i + " j = " + j);
			if (isValid((int) (words[i] - 'a'))) {
				localMax = j - i + 1;
//				System.out.println("change");
			}

			ans = Math.max(ans, localMax);
			cnt[(int) (words[i] - 'a')] -= 1;
		}

		System.out.println(ans);

	}

}