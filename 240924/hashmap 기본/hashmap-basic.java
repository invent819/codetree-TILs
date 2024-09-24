import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			switch (input) {
			case "add":
				int key = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				map.put(key, value);
				break;
			case "find":
				int find = Integer.parseInt(st.nextToken());
				Integer v = map.get(find);
				System.out.println(v == null ? "None" : v);

				break;
			case "remove":
				int remove = Integer.parseInt(st.nextToken());
				map.remove(remove);
				break;
			}
		}

	}

}