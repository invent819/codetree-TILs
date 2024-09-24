import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			map.put(input, i + 1);
			words[i] = input;
		}

		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if (map.containsKey(input)) {
				System.out.println(map.get(input));
			} else {
				int idx = Integer.parseInt(input);
				System.out.println(words[idx - 1]);
			}

		}

	}

}