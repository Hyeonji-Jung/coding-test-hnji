import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M, maxHeight;
	private static int[] heights;

	private static long cut(int h) {
		long woods = 0;
		for (int height : heights)
			if (height > h)
				woods += height - h;
		return woods;
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(br.readLine());
		heights = new int[N];
		for (int i = 0; i < N; i++)
			heights[i] = Integer.parseInt(tokens.nextToken());
		Arrays.sort(heights);

		int start = 0;
		int end = heights[N - 1];
		while (start <= end) {
			int mid = (start + end) / 2;
			if (cut(mid) < M)
				end = mid - 1;
			else {
				maxHeight = Math.max(maxHeight, mid);
				start = mid + 1;
			}
		}
		System.out.println(maxHeight);
	}
}