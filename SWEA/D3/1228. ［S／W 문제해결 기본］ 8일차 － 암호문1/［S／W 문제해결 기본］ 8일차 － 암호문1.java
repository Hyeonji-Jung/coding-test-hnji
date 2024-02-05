import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int length, commands;
	private static LinkedList<Integer> codes;

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			length = Integer.parseInt(br.readLine());
			tokens = new StringTokenizer(br.readLine());
			codes = new LinkedList<>();
			for (int i = 0; i < length; i++)
				codes.add(Integer.parseInt(tokens.nextToken()));

			commands = Integer.parseInt(br.readLine());
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < commands; i++) {
				tokens.nextToken();
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				for (int j = 0; j < y; j++)
					codes.add(x++, Integer.parseInt(tokens.nextToken()));
			}

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++)
				sb.append(codes.get(i)).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}