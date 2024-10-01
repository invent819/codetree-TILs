import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static Map<Integer, Integer> freq = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (freq.containsKey(input)) {
				freq.put(input, freq.get(input) + 1);
			} else {
				freq.put(input, 1);
			}
		}

		freq.entrySet().stream().sorted((e1, e2) -> {
			int ret = e1.getValue().compareTo(e2.getValue()) * -1;
			if (ret == 0) {
				return e1.getKey().compareTo(e2.getKey()) * -1;
			}
			return ret;
		}).limit(k).forEach((e) -> {
			System.out.print(e.getKey() + " ");
		});

	}
}