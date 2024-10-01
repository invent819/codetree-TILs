import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	static int n;
	static TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			treeMap.put(input, treeMap.getOrDefault(input, 0) + 1);
		}

		for (Entry<String, Integer> e : treeMap.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}