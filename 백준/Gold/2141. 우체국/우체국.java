import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Town implements Comparable<Town> {
		int x;
		int a;

		Town(int x, int a) {
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Town o) {
			if (this.x == o.x)
				return Integer.compare(this.a, o.a);
			return Integer.compare(this.x, o.x);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N;
	private static long people;
	private static Town[] towns;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		towns = new Town[N];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int a = Integer.parseInt(tokens.nextToken());
			towns[i] = new Town(x, a);
			people += a;
		}
		Arrays.sort(towns);
		long prefix = 0;
		for (Town town : towns) {
			prefix += town.a;
			if (prefix >= (people + 1) / 2) {
				System.out.println(town.x);
				break;
			}
		}
	}
}