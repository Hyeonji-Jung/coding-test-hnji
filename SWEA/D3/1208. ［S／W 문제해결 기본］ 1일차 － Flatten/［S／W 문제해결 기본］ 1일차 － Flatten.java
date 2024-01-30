import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int dump;
	private static int[] boxes = new int[100];
	
	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			dump = Integer.parseInt(br.readLine());
			tokens = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++)
				boxes[i] = Integer.parseInt(tokens.nextToken());
			
			while (dump > 0) {
				int maxIdx = 0;
				int minIdx = 0;
				for (int i = 0; i < 100; i++) {
					maxIdx = boxes[maxIdx] < boxes[i] ? i : maxIdx;
					minIdx = boxes[minIdx] > boxes[i] ? i : minIdx;
				}
				if (boxes[maxIdx] - boxes[minIdx] <= 1)
					break;
				boxes[maxIdx]--;
				boxes[minIdx]++;
				dump--;
			}
			
			Arrays.sort(boxes);
			sb.append("#").append(t).append(" ").append(boxes[99] - boxes[0]).append("\n");
		}
		System.out.println(sb);
	}
}