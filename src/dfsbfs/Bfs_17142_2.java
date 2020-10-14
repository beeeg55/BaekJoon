package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_17142_2 {

	private static int blank;
	private static int virus;
	private static int M, N;
	private static int min = Integer.MAX_VALUE;
	private static int[][] select;
	private static ArrayList<Integer> virusr;
	private static ArrayList<Integer> virusc;
	private static int[][] lab;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new int[M][2];
		virusr = new ArrayList<>();
		virusc = new ArrayList<>();
		blank = 0;
		virus = 0;
		lab = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 0) {
					blank++;
				}
				if (lab[i][j] == 2) {
					virusr.add(i);
					virusc.add(j);
					virus++;
				}
			}
		}
		if (blank == 0) {
			System.out.println(0);
			System.exit(0);
		}
		combination(0, 0);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);

		} else {

			System.out.println(min);
		}

	}

	private static void combination(int start, int cnt) {
		if (cnt == M) {
			int time = bfs();
			if (time < min) {
				min = time;
			}
			return;
		}
		for (int i = start; i < virus; i++) {
			select[cnt][0] = (int) virusr.get(i);
			select[cnt][1] = (int) virusc.get(i);
			combination(i + 1, cnt + 1);
		}

	}

	private static int bfs() {
		boolean visit[][] = new boolean[N][N];
		int delete = 0;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int time = 0;
		Queue<int[]> qu = new LinkedList<>();
		for (int i = 0; i < select.length; i++) {
			qu.add(new int[] { select[i][0], select[i][1] });
			visit[select[i][0]][select[i][1]] = true;
		}
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				int temp[] = qu.poll();
				for (int j = 0; j < 4; j++) {
					int r = temp[0] + dr[j];
					int c = temp[1] + dc[j];
					if (0 <= r && r < N && 0 <= c && c < N && lab[r][c] != 1 && !visit[r][c]) {
						if (lab[r][c] == 0) {
							delete++;
						}
						visit[r][c] = true;
						qu.add(new int[] { r, c });
						if (blank == delete) {
							return time + 1;
						}
					}
				}
			}
			time++;
		}
		if (blank > 0) {
			return Integer.MAX_VALUE;
		}
		return time;
	}

}
