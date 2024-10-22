import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, q;
	static int[] arr;
	static Node[] dp;

	static Node getPrefixSum(int s, int e) {
		Node n1 = dp[s - 1];
		Node n2 = dp[e];
		int x = n2.x - n1.x;
		int y = n2.y - n1.y;
		int z = n2.z - n1.z;

		return new Node(x, y, z);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		dp = new Node[n + 1];
		dp[0] = new Node(0, 0, 0);
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			int x = dp[i - 1].x;
			int y = dp[i - 1].y;
			int z = dp[i - 1].z;
			switch (arr[i]) {
			case 1: {
				x++;
				break;
			}
			case 2: {
				y++;
				break;
			}
			case 3: {
				z++;
				break;
			}
			}
			dp[i] = new Node(x, y, z);
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			System.out.println(getPrefixSum(s, e));
		}
	}

}

class Node {
	int x, y, z;

	public Node(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + z;
	}

}