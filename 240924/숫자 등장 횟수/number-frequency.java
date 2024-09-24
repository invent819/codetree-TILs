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
		HashMap<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			int cnt = map.getOrDefault(k, 0);
			map.put(k, cnt + 1);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int v = map.getOrDefault(Integer.parseInt(st.nextToken()), 0);
			System.out.print(v + " ");

		}

	}

}