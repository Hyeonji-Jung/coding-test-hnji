import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, L;
	private static int[] height;
	
	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(br.readLine());
		height = new int[N];
		for (int i = 0; i < N; i++)
			height[i] = Integer.parseInt(tokens.nextToken());
		Arrays.sort(height);
		for (int h : height) {
			if (h > L)
				break;
			L++;
		}
		System.out.println(L);
	}
}