package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_14502 {

	static int[][] wall;
	private static int N;
	private static int M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static int[][] lab;
	static int answer = Integer.MAX_VALUE;
	private static boolean[][] visit;
	private static int countWall;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wall = new int[3][2];
		lab = new int[N][M];
		countWall = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 1)
					countWall++;
			}
		}
		combination(0, 0);
		System.out.println(N * M - answer - countWall - 3);

	}

	private static void combination(int start, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) {
				lab[wall[i][0]][wall[i][1]] = 1;
			}

			visit = new boolean[N][M];
			int size = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (lab[i][j] == 2 && !visit[i][j]) {
						size += Bfs(i, j);
					}
				}
			}
			if (size < answer) {
				answer = size;

			}
			for (int i = 0; i < 3; i++) {
				lab[wall[i][0]][wall[i][1]] = 0;
			}
			return;

		}
		for (int i = start; i < N*M; i++) {

			if (lab[i/M][i%M] == 0) {
				wall[cnt][0] = i/M;
				wall[cnt][1] = i%M;
					combination(i+ 1, cnt + 1);
			}
		}

	}

	private static int Bfs(int i, int j) {
		int count = 1;
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] { i, j });
		visit[i][j] = true;
		while (!qu.isEmpty()) {
			int[] temp = qu.poll();
			for (int k = 0; k < 4; k++) {
				int r = temp[0] + dr[k];
				int c = temp[1] + dc[k];
				if (0 <= r && r < N && 0 <= c && c < M && !visit[r][c] && lab[r][c] != 1) {
					count++;
					visit[r][c] = true;
					qu.add(new int[] { r, c });
				}
			}
		}
		return count;
	}

}
