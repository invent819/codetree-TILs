import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int MAX_N = 100000;
	static Person[] people = new Person[MAX_N + 1];
	static PriorityQueue<WaitingPerson> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			people[i] = new Person(a, i + 1, t);
		}

		people[n] = new Person(Integer.MAX_VALUE, n + 1, 0);

		Arrays.sort(people, 0, n + 1);
		int ans = 0;
		int exitTime = 0;
		for (int i = 0; i <= n; i++) {
			// 각 사람을 순서대로 입장시킵니다.
			int a = people[i].a;
			int num = people[i].num;
			int t = people[i].t;

			// 지금 입장한 사람보다
			// 현재 정원에서 빠져나오는 사람의 시간이 더 앞서다면
			// 계속 정원 입장을 진행해줍니다.
			while (a > exitTime && !pq.isEmpty()) {
				// 기다리던 사람 중에 가장 우선순위가 높은 사람을 골라줍니다.
				WaitingPerson nextWP = pq.poll();
				int nextA = nextWP.a;
				int nextT = nextWP.t;

				// 해당 사람이 얼마나 기다렸는지를 계산하여
				// 최댓값을 갱신해줍니다.
				ans = Math.max(ans, exitTime - nextA);
				// 연속하여 일어난 일이므로
				// 그 다음 사람의 정원 퇴장 시간은
				// nextT만큼 더해진 값이 됩니다.
				exitTime += nextT;
			}

			// 계속 정원 입장을 진행했음에도
			// 지금 입장한 사람이 대기 없이 들어갈 수 있다면
			// 우선순위 큐에 넣지 않고 바로 정원에 입장시킵니다.
			if (a > exitTime)
				exitTime = a + t;
			// 그렇지 않다면
			// 대기 리스트에 넣어줍니다.
			else
				pq.add(new WaitingPerson(num, a, t));
		}

		System.out.println(ans);

	}

}

class Person implements Comparable<Person> {
	int a, t, num;

	public Person(int a, int num, int t) {
		this.a = a;
		this.t = t;
		this.num = num;
	}

	@Override
	public int compareTo(Person o) {
		if (this.a != o.a)
			return Integer.compare(this.a, o.a);
		return Integer.compare(this.num, o.num);

	}
}

class WaitingPerson implements Comparable<WaitingPerson> {
	int num, a, t;

	public WaitingPerson(int num, int a, int t) {
		this.a = a;
		this.t = t;
		this.num = num;
	}

	@Override
	public int compareTo(WaitingPerson o) {
		return Integer.compare(this.num, o.num);
	}
}