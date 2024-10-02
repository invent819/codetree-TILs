import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
		int a, b;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}

		HashSet<Integer> tempA = (HashSet<Integer>) A.clone();
		HashSet<Integer> tempB = (HashSet<Integer>) B.clone();

		A.removeAll(tempB);
		B.removeAll(tempA);
		
		System.out.println(A.size() + B.size());
    }
}