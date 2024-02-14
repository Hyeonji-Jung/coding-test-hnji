import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	private static int N, R, C, cnt;

	private static void divide(int r, int c, int len) {
		if (len == 1)
			return;
		int nextLen = len / 2;
		if (R < r + nextLen && C < c + nextLen)
			divide(r, c, nextLen);
		else if (R < r + nextLen && C >= c + nextLen) {
			cnt += nextLen * nextLen;
			divide(r, c + nextLen, nextLen);
		} else if (R >= r + nextLen && C < c + nextLen) {
			cnt += nextLen * nextLen * 2;
			divide(r + nextLen, c, nextLen);
		} else {
			cnt += nextLen * nextLen * 3;
			divide(r + nextLen, c + nextLen, nextLen);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		divide(0, 0, (int) Math.pow(2, N));
		System.out.println(cnt);
	}
}