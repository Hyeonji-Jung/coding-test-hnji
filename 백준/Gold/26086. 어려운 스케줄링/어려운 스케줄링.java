import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] queries = new int[Q][2];
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			queries[i][0] = Integer.parseInt(st.nextToken());
			if (st.hasMoreTokens())
				queries[i][1] = Integer.parseInt(st.nextToken());
		}

		int lastSortIdx = 0;
		for (int i = 0; i < Q; i++)
			if (queries[i][0] == 1)
				lastSortIdx = i;

		boolean isReversed = false;
		for (int i = 0; i < lastSortIdx; i++)
			if (queries[i][0] == 2)
				isReversed = !isReversed;

		List<Integer> prev = new ArrayList<>();
		for (int i = 0; i < lastSortIdx; i++)
			if (queries[i][0] == 0)
				prev.add(queries[i][1]);

		if (isReversed) {
			Collections.sort(prev, Collections.reverseOrder());
		} else {
			Collections.sort(prev);
		}

		List<Integer>[] prevArr = new List[] { prev, new ArrayList<>(prev) };
		Collections.reverse(prevArr[1]);

		List<Integer>[] add = new List[] { new ArrayList<>(), new ArrayList<>() };

		for (int i = lastSortIdx; i < Q; i++) {
			if (queries[i][0] == 0) {
				add[isReversed ? 1 : 0].add(queries[i][1]);
			} else if (queries[i][0] == 2) {
				isReversed = !isReversed;
			}
		}

		List<Integer> result = new ArrayList<>();
		result.addAll(add[isReversed ? 1 : 0]);
		Collections.reverse(result);
		result.addAll(prevArr[isReversed ? 1 : 0]);
		result.addAll(add[isReversed ? 0 : 1]);

		System.out.println(result.get(k - 1));
	}
}