import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int n;
	static TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (!treeMap.containsKey(x)) {
				treeMap.put(x, i);
			}
		}

		for (Entry<Integer, Integer> e : treeMap.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}