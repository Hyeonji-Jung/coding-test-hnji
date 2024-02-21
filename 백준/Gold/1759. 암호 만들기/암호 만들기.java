import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int L, C;
	private static char[] chars, selected;
	private static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

	private static void dfs(int depth, int start, int vowelCnt) {
		if (depth == L) {
			if (vowelCnt >= 1 && vowelCnt <= L - 2)
				sb.append(String.valueOf(selected)).append("\n");
			return;
		}
		for (int i = start; i < C; i++) {
			selected[depth] = chars[i];
			dfs(depth + 1, i + 1, vowels.contains(chars[i]) ? vowelCnt + 1 : vowelCnt);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		chars = new char[C];
		tokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++)
			chars[i] = tokens.nextToken().charAt(0);
		Arrays.sort(chars);
		selected = new char[L];
		dfs(0, 0, 0);
		System.out.println(sb);
	}
}