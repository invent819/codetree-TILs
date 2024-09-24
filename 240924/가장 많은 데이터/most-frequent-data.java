import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			int cnt = map.getOrDefault(input, 0);
			map.put(input, cnt + 1);
			if (cnt + 1 > max) {
				max = cnt + 1;
			}
		}
		System.out.println(max);

	}

}