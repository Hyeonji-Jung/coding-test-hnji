import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int len = 19;
	private static int winColor = 0;
	
	private static int[][] omok = new int[len][len];
	
	private static int[] dx = new int[]{1, 0, 1, -1};
	private static int[] dy = new int[]{0, 1, 1, 1};

	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < len; i++) {
			tokens = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < len; j++) {
				omok[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		loop : for (int i = 0; i < len; i++) {
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
							sb.append(i+1).append(" ").append(j+1);
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