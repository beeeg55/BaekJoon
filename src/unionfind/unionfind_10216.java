package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class unionfind_10216 {
	public static int[] parents;
	public static int[] pick = new int[2];
	private static int n;
	private static int[][] enemy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			enemy = new int[n][3];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				enemy[i][0] = Integer.parseInt(st.nextToken());
				enemy[i][1] = Integer.parseInt(st.nextToken());
				enemy[i][2] = Integer.parseInt(st.nextToken());
			}
			make();
			combination(0,0);
			HashSet<Integer> answer = new HashSet<>();
			for (int i = 0; i < n; i++) {
				answer.add(find(i));
			}
			System.out.println(answer.size());
		}
	}

	public static void combination(int start, int cnt) {
		if (cnt == 2) {
			double distance = calDistance(enemy[pick[0]][0], enemy[pick[0]][1], enemy[pick[1]][0], enemy[pick[1]][1]);
			if (distance <= enemy[pick[0]][2] + enemy[pick[1]][2]) {
				union(pick[0], pick[1]);
			}
			return;
		}
		for (int i = start; i < parents.length; i++) {
			pick[cnt] = i;
			combination(start+1, cnt + 1);

		}
	}

	public static double calDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public static void make() {
		parents = new int[n];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parents[rootA] = rootB;
		}

	}

}
