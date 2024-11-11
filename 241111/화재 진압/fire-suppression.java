import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int MAX_NUM = 100_000;
	static int[] fires = new int[MAX_NUM];
	static int[] stations = new int[MAX_NUM + 1];
	static int n, m;

	static int dist(int i, int j) {
		return Math.abs(fires[i] - stations[j]);
	}

	static int putOutFire() {
		int maxDist = 0;
		int j = 1;
		for (int i = 1; i <= n; i++) {
			while (j + 1 <= m && dist(i, j) > dist(i, j + 1)) {
				j++;
			}

			maxDist = Math.max(maxDist, dist(i, j));
		}
		return maxDist;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			fires[i] = sc.nextInt();
		}
		for (int i = 1; i <= m; i++) {
			stations[i] = sc.nextInt();
		}
		Arrays.sort(fires, 1, n + 1);
		Arrays.sort(stations, 1, m + 1);

		System.out.println(putOutFire());
	}

}
