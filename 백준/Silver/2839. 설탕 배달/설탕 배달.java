import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, cnt;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		while (N >= 0) {
			if (N % 5 == 0) {
				cnt += N / 5;
				break;
			}
			N -= 3;
			cnt++;
		}
		System.out.println(N >= 0 ? cnt : -1);
	}
}