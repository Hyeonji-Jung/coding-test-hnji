import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	private static int T;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			char[] memory = br.readLine().trim().toCharArray();
			if (memory.length < 2) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;
			}
			int count = memory[0] == '0' ? 0 : 1;
			for (int i = 1; i < memory.length; i++) {
				if (memory[i - 1] != memory[i])
					count++;
			}
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}