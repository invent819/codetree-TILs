import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static long[] nums;
	static HashMap<Long, Integer> count = new HashMap<>();

	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		nums = new long[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			long diff = k - nums[i];

			if (count.containsKey(diff)) {
				result += count.get(diff);
			}

			if (!count.containsKey(nums[i])) {
				count.put(nums[i], 1);
			} else {
				count.put(nums[i], count.get(nums[i]) + 1);
			}

		}
		System.out.println(result);

	}

}