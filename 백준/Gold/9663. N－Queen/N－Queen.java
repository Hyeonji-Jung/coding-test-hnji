import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, ways;

	private static boolean chk(int row, int[] board) {
		for (int i = 0; i < row; i++)
			if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i]))
				return false;
		return true;
	}

	private static void nQueen(int row, int[] board) {
		if (row == N) {
			ways++;
			return;
		}
		for (int i = 0; i < N; i++) {
			board[row] = i;
			if (chk(row, board))
				nQueen(row + 1, board);
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		nQueen(0, new int[N]);
		System.out.println(ways);
	}
}