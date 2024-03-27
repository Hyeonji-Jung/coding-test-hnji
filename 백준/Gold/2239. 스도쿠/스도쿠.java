import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	private static int[][] sudoku = new int[9][9];
	private static ArrayList<int[]> list = new ArrayList<>();

	private static boolean isValid(int x, int y) {
		for (int i = 0; i < 9; i++) {
			if (x != i && sudoku[x][y] == sudoku[i][y])
				return false;
			if (y != i && sudoku[x][y] == sudoku[x][i])
				return false;
		}
		int xStart = x / 3 * 3;
		int yStart = y / 3 * 3;
		for (int i = xStart; i < xStart + 3; i++) {
			for (int j = yStart; j < yStart + 3; j++)
				if (x != i && y != j && sudoku[x][y] == sudoku[i][j])
					return false;
		}
		return true;
	}

	private static boolean dfs(int depth) {
		if (depth == list.size())
			return true;
		int x = list.get(depth)[0];
		int y = list.get(depth)[1];
		for (int i = 1; i < 10; i++) {
			sudoku[x][y] = i;
			if (isValid(x, y) && dfs(depth + 1))
				return true;
		}
		sudoku[x][y] = 0;
		return false;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = c[j] - '0';
				if (sudoku[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}
		dfs(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(sudoku[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}