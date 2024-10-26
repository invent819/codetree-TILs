import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static char[][] graph;
	static int ans = 0;
	static Node[] arr;
	static int[] dpLeft;
	static int[] dpRight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new Node[n];
		dpLeft = new int[n];
		dpRight = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i < n; i++) {
			Node n1 = arr[i - 1];
			Node n2 = arr[i];
			dpLeft[i] = Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y) + dpLeft[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			Node n1 = arr[i];
			Node n2 = arr[i + 1];
			dpRight[i] = Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y) + dpRight[i + 1];
		}
		ans = Integer.MAX_VALUE;
		for (int i = 1; i < n - 1; i++) {
			int sum = Math.abs(arr[i - 1].x - arr[i + 1].x) + Math.abs(arr[i - 1].y - arr[i + 1].y);
			ans = Math.min(ans, dpLeft[i - 1] + dpRight[i + 1] + sum);
		}

		System.out.println(ans);

	}

}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}