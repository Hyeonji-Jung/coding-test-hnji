import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	private static Deque<Character> stack;

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			char[] braces = br.readLine().trim().toCharArray();
			if (braces.length % 2 == 1) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;
			}
			stack = new ArrayDeque<>();
			int flag = 1;

			for (char brace : braces) {
				switch (brace) {
				case ')':
					if (stack.pollLast() != '(')
						flag = 0;
					break;
				case ']':
					if (stack.pollLast() != '[')
						flag = 0;
					break;
				case '}':
					if (stack.pollLast() != '{')
						flag = 0;
					break;
				case '>':
					if (stack.pollLast() != '<')
						flag = 0;
					break;
				default:
					stack.offer(brace);
				}
				if (flag == 0)
					break;
			}
			if (!stack.isEmpty())
				flag = 0;
			sb.append("#").append(t).append(" ").append(flag).append("\n");
		}
		System.out.println(sb);
	}
}