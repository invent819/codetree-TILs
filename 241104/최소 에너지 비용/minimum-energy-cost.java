import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] distance;
    static int[] energy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        distance = new int[n - 1];
        energy = new int[n];

        // 거리 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        // 에너지 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        int currentMinEnergy = energy[0]; // 시작점의 에너지를 초기 최소 에너지로 설정

        for (int i = 0; i < n - 1; i++) {
            // 현재 위치에서 가장 작은 에너지를 계속 갱신
            currentMinEnergy = Math.min(currentMinEnergy, energy[i]);
            ans += (long) currentMinEnergy * distance[i]; // 현재 최소 에너지로 거리 계산
        }

        System.out.println(ans);
    }
}