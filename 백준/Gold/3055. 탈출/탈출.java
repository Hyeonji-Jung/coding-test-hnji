import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Node {
		Pos pos;
		int d;

		Node(int x, int y, int d) {
			this.pos = new Pos(x, y);
			this.d = d;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int R, C;
	static char map[][];
	static boolean visited[][];
	static Node start;
	static ArrayList<Pos> water = new ArrayList<Pos>();
	static int d[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void move() {
		ArrayDeque<Node> q = new ArrayDeque<Node>();
		visited = new boolean[R][C];
		visited[start.pos.x][start.pos.y] = true;
		q.offer(start);

		while (true) {
			int length = water.size();
			for (int i = 0; i < length; i++) {
				for (int[] delta : d) {
					int wx = water.get(i).x + delta[0];
					int wy = water.get(i).y + delta[1];
					if (wx >= 0 && wx < R && wy >= 0 && wy < C && map[wx][wy] == '.') {
						map[wx][wy] = '*';
						water.add(new Pos(wx, wy));
					}
				}
			}
			length = q.size();
			if (length == 0) {
				System.out.println("KAKTUS");
				return;
			}
			for (int i = 0; i < length; i++) {
				Node curr = q.poll();
				if (map[curr.pos.x][curr.pos.y] == 'D') {
					System.out.println(curr.d);
					return;
				}
				for (int[] delta : d) {
					int nx = curr.pos.x + delta[0];
					int ny = curr.pos.y + delta[1];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] != '*'
							&& map[nx][ny] != 'X') {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, curr.d + 1));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					start = new Node(i, j, 0);
				} else if (map[i][j] == '*')
					water.add(new Pos(i, j));
			}
		}
		move();
	}
}