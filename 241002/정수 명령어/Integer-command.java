import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, t, k;
	static TreeSet<Integer> treeSet = new TreeSet<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		int x;
		
		for (int T = 0; T < t; T++) {
			
			k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				switch (input) {
				case "I":
					x = Integer.parseInt(st.nextToken());
					treeSet.add(x);
					break;
				case "D":
					x = Integer.parseInt(st.nextToken());
					if (!treeSet.isEmpty()) {
						if (x == 1) {
							treeSet.remove(treeSet.last());
						} else {
							treeSet.remove(treeSet.first());
						}
					}
					break;
				}

			}
			if (treeSet.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(treeSet.last() + " " + treeSet.first());
			}

		}

	}

}