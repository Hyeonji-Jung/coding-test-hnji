import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder sb = new StringBuilder();

	static int T, N;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			dist = new int[N];
			tokens = new StringTokenizer(br.readLine());
			dist[0] = Math.abs(Integer.parseInt(tokens.nextToken())) + Math.abs(Integer.parseInt(tokens.nextToken()));
			boolean flag = true;
			int max = dist[0];
			for (int i = 1; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				dist[i] = Math.abs(Integer.parseInt(tokens.nextToken()))
						+ Math.abs(Integer.parseInt(tokens.nextToken()));
				if (dist[i] % 2 != dist[i - 1] % 2)
					flag = false;
				max = Math.max(max, dist[i]);
			}
			int sec = 0;
			if (flag) {
				int accum = 0;
				while (true) {
					accum += sec;
					if (accum >= max && (accum - max) % 2 == 0)
						break;
					sec++;
				}
			}
			sb.append("#" + t + " ").append(flag ? sec : -1).append("\n");
		}
		System.out.println(sb);
	}
}