import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 정현지
 * @date 240129
 * @link https://www.acmicpc.net/problem/2615
 * @keyword_solution 배열, 완전탐색
 * @input 0~2로 구성된 19x19 2차원 배열, 띄어쓰기로 구분
 * @output 0~2 사이의 자연수, 그 다음 줄에는 어느 한 팀이 이겼을 경우 가장 처음 발견된 바둑알의 위치
 * @time_complex O(N^2)
 * @perf 140ms
 */

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int len = 19;
	private static int winColor = 0;

	private static int[][] omok = new int[len][len];

	private static int[] dx = new int[] { 1, 0, 1, -1 };
	private static int[] dy = new int[] { 0, 1, 1, 1 };

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < len; i++) {
			tokens = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < len; j++) {
				omok[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		loop: for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (omok[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int rx = i - dx[k];
						int ry = j - dy[k];
						if (rx >= 0 && rx < len && ry >= 0 && ry < len && omok[rx][ry] == omok[i][j])
							continue;

						int count = 1;
						int nx = i + dx[k];
						int ny = j + dy[k];
						while (nx >= 0 && nx < len && ny >= 0 && ny < len && omok[nx][ny] == omok[i][j]) {
							count++;
							nx += dx[k];
							ny += dy[k];
						}

						if (count == 5) {
							winColor = omok[i][j] == 1 ? 1 : 2;
							sb.append(winColor).append("\n");
							sb.append(i + 1).append(" ").append(j + 1);
							break loop;
						}
					}
				}
			}
		}
		if (winColor == 0)
			sb.append(0);
		System.out.println(sb);
	}
}