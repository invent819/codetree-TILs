import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	static int n, k;

	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<Character> arr = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				map.remove(input.charAt(i));
				arr.remove((Object) input.charAt(i));
			} else {
				map.put(input.charAt(i), 1);
				arr.add(input.charAt(i));
			}
		}

		if (arr.isEmpty()) {
			System.out.println("None");
		} else {
			System.out.println(arr.get(0));
		}

	}

}