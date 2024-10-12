import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int x, p, l;
	static TreeSet<Problem> treeSet = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			treeSet.add(new Problem(p, l));
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			switch (input) {
			case "ad": {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				treeSet.add(new Problem(p, l));
				break;
			}
			case "sv": {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				treeSet.remove(new Problem(p, l));
				break;
			}
			case "rc": {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					Problem p = treeSet.last();
					System.out.println(p.no);
				} else {
					Problem p = treeSet.first();
					System.out.println(p.no);
				}
				break;
			}

			}

		}

	}
}

class Problem implements Comparable<Problem> {
	int no, difficult;

	public Problem(int x, int y) {
		this.no = x;
		this.difficult = y;

	}

	@Override
	public int compareTo(Problem o) {
		if (this.difficult == o.difficult) {
			return Integer.compare(this.no, o.no); // 잘못된 부분 수정
		}

		// 난이도 내림차순 정렬
		return Integer.compare(this.difficult, o.difficult); // 난이도는 내림차순으로 정렬
	}

	@Override
	public int hashCode() {
		return Objects.hash(difficult, no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Problem other = (Problem) obj;
		return difficult == other.difficult && no == other.no;
	}

	@Override
	public String toString() {
		return no + " " + difficult;
	}

}