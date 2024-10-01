import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int n;
	static TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k, v;
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			switch (input) {
			case "add":
				k = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				treeMap.put(k, v);
				break;
			case "remove":
				k = Integer.parseInt(st.nextToken());
				treeMap.remove(k);
				break;
			case "find":
				k = Integer.parseInt(st.nextToken());
				if (treeMap.containsKey(k)) {
					System.out.println(treeMap.get(k));
				} else {
					System.out.println("None");
				}
				break;
			case "print_list":
				if (treeMap.isEmpty()) {
					System.out.println("None");
				} else {
					treeMap.forEach((K, V) -> {
						System.out.print(V + " ");
					});
					System.out.println();
				}

				break;
			}
		}
	}
}