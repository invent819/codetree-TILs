import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n;
	static TreeSet<Integer> treeSet = new TreeSet<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int x;
		Integer find;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			switch (input) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				treeSet.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				treeSet.remove(x);
				break;
			case "find":
				x = Integer.parseInt(st.nextToken());
				if (treeSet.contains(x))
					System.out.println("true");
				else
					System.out.println("false");
				break;
			case "lower_bound":
				x = Integer.parseInt(st.nextToken());
				if (treeSet.isEmpty()) {
					System.out.println("None");
				} else {

					find = treeSet.ceiling(x);
					if (find == null) {
						System.out.println("None");
					} else {
						System.out.println(find);
					}
				}
				break;
			case "upper_bound":
				x = Integer.parseInt(st.nextToken());
				if (treeSet.isEmpty()) {
					System.out.println("None");
				} else {
					find = treeSet.higher(x);
					if (find == null) {
						System.out.println("None");
					} else {
						System.out.println(find);
					}
				}

				break;
			case "largest":
				if (treeSet.isEmpty()) {
					System.out.println("None");
				} else {
					find = treeSet.last();
					System.out.println(find);
				}

				break;
			case "smallest":
				if (treeSet.isEmpty()) {
					System.out.println("None");
				} else {
					find = treeSet.first();
					System.out.println(find);
				}

				break;
			}
		}

	}

}