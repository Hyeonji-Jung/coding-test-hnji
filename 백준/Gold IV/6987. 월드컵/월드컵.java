import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	static int[][] matches, scores;
	static int flag;

	private static void game(int matchCnt) {
		if (flag == 1)
			return;
		if (matchCnt == 15) {
			flag = 1;
			return;
		}
		int team1 = matches[matchCnt][0];
		int team2 = matches[matchCnt][1];
		if (scores[team1][0] > 0 && scores[team2][2] > 0) {
			scores[team1][0]--;
			scores[team2][2]--;
			game(matchCnt + 1);
			scores[team1][0]++;
			scores[team2][2]++;
		}
		if (scores[team1][2] > 0 && scores[team2][0] > 0) {
			scores[team1][2]--;
			scores[team2][0]--;
			game(matchCnt + 1);
			scores[team1][2]++;
			scores[team2][0]++;
		}
		if (scores[team1][1] > 0 && scores[team2][1] > 0) {
			scores[team1][1]--;
			scores[team2][1]--;
			game(matchCnt + 1);
			scores[team1][1]++;
			scores[team2][1]++;
		}
	}

	public static void main(String[] args) throws Exception {
		for (int t = 0; t < 4; t++) {
			matches = new int[15][2];
			int idx = 0;
			for (int i = 0; i < 5; i++)
				for (int j = i + 1; j < 6; j++) {
					matches[idx][0] = i;
					matches[idx++][1] = j;
				}
			tokens = new StringTokenizer(br.readLine());
			scores = new int[6][3];
			flag = 1;
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++)
					sum += (scores[i][j] = Integer.parseInt(tokens.nextToken()));
				if (sum % 5 != 0)
					flag = 0;
			}
			if (flag == 1 && sum == 30) {
				flag = 0;
				game(0);
			}
			sb.append(flag).append(" ");
		}
		System.out.println(sb);
	}
}