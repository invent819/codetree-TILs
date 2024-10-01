import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class Main {
	public static final int MAX_N = 1000;
	static HashMap<String, Integer> freqArr = new HashMap<String, Integer>();
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String words = br.readLine();
			char[] cWords = words.toCharArray();
			Arrays.sort(cWords);

			String sortedWord = new String(cWords);
			freqArr.put(sortedWord, freqArr.getOrDefault(sortedWord, 0) + 1);
		}
		Optional<Integer> first = freqArr.values().stream().sorted((v1, v2) -> {
			return v1.compareTo(v2) * -1;
		}).findFirst();
		int ans = first.get();
		System.out.println(ans);
	}
}