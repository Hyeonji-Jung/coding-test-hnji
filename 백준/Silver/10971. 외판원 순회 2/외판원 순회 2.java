import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, min = Integer.MAX_VALUE;
	private static int[][] w;
	private static int[] cities;

	private static boolean np() {
		int i = N - 1;
		while (i > 0 && cities[i - 1] > cities[i])
			i--;
		if (i == 0)
			return false;
		int j = N - 1;
		while (cities[i - 1] > cities[j])
			j--;
		int temp = cities[i - 1];
		cities[i - 1] = cities[j];
		cities[j] = temp;
		int k = N - 1;
		while (i < k) {
			temp = cities[i];
			cities[i++] = cities[k];
			cities[k--] = temp;
		}
		return true;
	}

	private static void calc() {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			if (w[cities[i]][cities[i + 1]] == 0)
				return;
			sum += w[cities[i]][cities[i + 1]];
		}
		if (w[cities[N - 1]][cities[0]] == 0)
			return;
		sum += w[cities[N - 1]][cities[0]];
		min = Math.min(min, sum);
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		cities = new int[N];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			cities[i] = i;
			for (int j = 0; j < N; j++)
				w[i][j] = Integer.parseInt(tokens.nextToken());
		}
		do {
			calc();
		} while (np());
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}