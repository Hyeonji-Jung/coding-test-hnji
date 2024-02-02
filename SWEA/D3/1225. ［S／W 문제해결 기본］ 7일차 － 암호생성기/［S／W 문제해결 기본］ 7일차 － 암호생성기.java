import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int[] temp;
	private static ArrayDeque<Integer> arr;

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			temp = new int[8];
			arr = new ArrayDeque<>();
			tokens = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				temp[i] = Integer.parseInt(tokens.nextToken());
				min = Math.min(min, temp[i]);
			}
			
			if (min > 15) {
				int multi = min / 15 - 1;
				for (int i = 0; i < 8; i++) {
					temp[i] -= multi * 15;
					arr.add(temp[i]);
				}
			}
			
			loop: while (true) {
				for (int i = 1; i <= 5; i++) {
					int curr = arr.pollFirst() - i;
					if (curr <= 0) {
						arr.add(0);
						break loop;
					} else
						arr.add(curr);
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 8; i++)
				sb.append(arr.pollFirst()).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}