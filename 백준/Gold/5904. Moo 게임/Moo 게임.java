import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;

	private static char moo(int len, int midLen, int pos) {
		int prevLen = (len - midLen) / 2;
		if (pos <= prevLen)
			return moo(prevLen, midLen - 1, pos);
		else if (pos > prevLen + midLen)
			return moo(prevLen, midLen - 1, pos - prevLen - midLen);
		else {
			if (pos - prevLen - 1 == 0)
				return 'm';
			return 'o';
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int k = 0;
		int len = 3;
		while (N > len)
			len = len * 2 + ++k + 3;
		System.out.println(moo(len, k + 3, N));
	}
}