import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int n;
	static final int MAX_NUM = 100_001;

	static int[] arr;

	static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			if (!treeMap.containsKey(x1)) {
				treeMap.put(x1, 1);
			} else {
				int cnt = treeMap.get(x1);
				treeMap.put(x1, cnt + 1);
			}
			if (!treeMap.containsKey(x2)) {
				treeMap.put(x2, -1);
			} else {
				int cnt = treeMap.get(x2);
				treeMap.put(x2, cnt - 1);
			}
		}
		int temp = 0;
		int ans = 0;
		for (Entry<Integer, Integer> entry : treeMap.entrySet()) {
			int cnt = entry.getValue();
			temp += cnt;
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);

	}
}

class Point implements Comparable<Point> {
	int x, v, idx;

	Point(int x, int v, int idx) {
		this.x = x;
		this.v = v;
		this.idx = idx;
	}

	@Override
	public int compareTo(Point o) {
		return Integer.compare(x, o.x);
	}

}