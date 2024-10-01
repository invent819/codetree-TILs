import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			switch (input) {
			case "add":
				set.add(x);
				break;
			case "remove":
				set.remove(x);
				break;
			case "find":
				if (set.contains(x)) {
					System.out.println("true");
				} else {
					System.out.println("false");
				}
				break;
			}
		}

	}
}