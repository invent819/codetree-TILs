import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
};

public class Main {
	static int n, q;
	static int[] point;
	static int[] dp;
	static TreeSet<Integer> treeSet = new TreeSet<>();
	static HashMap<Integer, Integer> mapper = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		point = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
//			point[i] = Integer.parseInt(st.nextToken());
			treeSet.add(Integer.parseInt(st.nextToken()));
		}
		int cnt = 1;
		for (Integer num : treeSet) {
			mapper.put(num, cnt++);
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int sCnt = 0;
			int eCnt = 0;
			if (mapper.containsKey(s)) {
				sCnt = mapper.get(s);
			} else {
				Integer findS = treeSet.ceiling(s);
				if (findS == null) {
					System.out.println(0);
					continue;
				}
				sCnt = mapper.get(findS);

			}
			if (mapper.containsKey(e)) {
				eCnt = mapper.get(e);
			} else {
				Integer findE = treeSet.floor(e);
				if (findE == null) {
					System.out.println(0);
					continue;
				}
				eCnt = mapper.get(findE);
			}

			System.out.println(eCnt - sCnt + 1);
		}
	}
}