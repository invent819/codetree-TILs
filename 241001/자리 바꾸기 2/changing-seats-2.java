import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] arr;
	static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ArrayList<HashSet<Integer>> setList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			setList.add(new HashSet<Integer>());
		}
		arr = new int[n];
		int[][] input = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken()) - 1;
			input[i][1] = Integer.parseInt(st.nextToken()) - 1;
			arr[i] = i;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < k; j++) {
				int a = input[j][0];
				int b = input[j][1];
				setList.get(arr[a]).add(b);
				setList.get(arr[b]).add(a);
				int temp = arr[a];
				arr[a] = arr[b];
				arr[b] = temp;

			}
		}

		for (int i = 0; i < n; i++) {
			int size = setList.get(i).size();
			if (size == 0) {
				System.out.println(1);
			} else {
				System.out.println(size);
			}

		}
	}
}