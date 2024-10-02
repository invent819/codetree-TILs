import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX_G = 250000;
	public static final int MAX_N = 100000;

	static int n, g;
	static boolean[] invited = new boolean[MAX_N];
	// 그룹 당 초대 받지 못한 사람
	static HashSet<Integer>[] groups = new HashSet[MAX_G];
	// 각 사람이 어떤 그룹인지
	static ArrayList<Integer>[] peopleGroups = new ArrayList[MAX_N];

	static Queue<Integer> q = new LinkedList<>();
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			peopleGroups[i] = new ArrayList<>();
		}
		for (int i = 0; i < g; i++) {
			groups[i] = new HashSet<>();
		}

		for (int i = 0; i < g; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			for (int j = 0; j < s; j++) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				groups[i].add(x);
				peopleGroups[x].add(i);
			}
		}

		q.add(0);
		invited[0] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			ans++;

			for (int i = 0; i < peopleGroups[x].size(); i++) {
				int gNum = peopleGroups[x].get(i);

				groups[gNum].remove(x);
				if (groups[gNum].size() == 1) {
					int pNum = new ArrayList<>(groups[gNum]).get(0);
					if (!invited[pNum]) {
						invited[pNum] = true;
						q.add(pNum);
					}
				}
			}
		}
		System.out.println(ans);

	}

}